package com.apptive.easywine.domain.util

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.UiComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/**
 * Crude copy of the Scaffold function in Compose, slightly modified to support bringing in the
 * navigation drawer from the right
 *
 * List extension functions copied from https://android.googlesource.com/platform/frameworks/support/+/refs/heads/androidx-main/compose/ui/ui-util/src/commonMain/kotlin/androidx/compose/ui/util/ListUtils.kt
 * */

@Suppress("BanInlineOptIn")
@OptIn(ExperimentalContracts::class)
inline fun <T, R : Comparable<R>> List<T>.fastMaxBy(selector: (T) -> R): T? {
    contract { callsInPlace(selector) }
    if (isEmpty()) return null
    var maxElem = get(0)
    var maxValue = selector(maxElem)
    for (i in 1..lastIndex) {
        val e = get(i)
        val v = selector(e)
        if (maxValue < v) {
            maxElem = e
            maxValue = v
        }
    }
    return maxElem
}

@Suppress("BanInlineOptIn")
@OptIn(ExperimentalContracts::class)
inline fun <T> List<T>.fastForEach(action: (T) -> Unit) {
    contract { callsInPlace(action) }
    for (index in indices) {
        val item = get(index)
        action(item)
    }
}


@Suppress("BanInlineOptIn")
@OptIn(ExperimentalContracts::class)
inline fun <T, R> List<T>.fastMap(transform: (T) -> R): List<R> {
    contract { callsInPlace(transform) }
    val target = ArrayList<R>(size)
    fastForEach {
        target += transform(it)
    }
    return target
}


@Stable
class ScaffoldState(
    val drawerState: DrawerState,
    val snackbarHostState: SnackbarHostState
)

/**
 * Creates a [ScaffoldState] with the default animation clock and memoizes it.
 *
 * @param drawerState the drawer state
 * @param snackbarHostState instance of [SnackbarHostState] to be used to show [Snackbar]s
 * inside of the [Scaffold]
 */
@Composable
fun rememberScaffoldState(
    drawerState: DrawerState = rememberDrawerState(DrawerValue.Closed),
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
): ScaffoldState = remember {
    ScaffoldState(drawerState, snackbarHostState)
}

/**
 * The possible positions for a [FloatingActionButton] attached to a [Scaffold].
 */
@kotlin.jvm.JvmInline
value class FabPosition internal constructor(@Suppress("unused") private val value: Int) {
    companion object {
        /**
         * Position FAB at the bottom of the screen in the center, above the [BottomAppBar] (if it
         * exists)
         */
        val Center = FabPosition(0)

        /**
         * Position FAB at the bottom of the screen at the end, above the [BottomAppBar] (if it
         * exists)
         */
        val End = FabPosition(1)
    }

    override fun toString(): String {
        return when (this) {
            Center -> "FabPosition.Center"
            else -> "FabPosition.End"
        }
    }
}

@Composable
fun RtlDrawerScaffold(
    modifier: Modifier = Modifier,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    snackbarHost: @Composable (SnackbarHostState) -> Unit = { SnackbarHost(it) },
    floatingActionButton: @Composable () -> Unit = {},
    floatingActionButtonPosition: FabPosition = FabPosition.End,
    isFloatingActionButtonDocked: Boolean = false,
    drawerContent: @Composable (ColumnScope.() -> Unit)? = null,
    drawerGesturesEnabled: Boolean = true,
    drawerShape: Shape = MaterialTheme.shapes.large,
    drawerElevation: Dp = DrawerDefaults.Elevation,
    drawerBackgroundColor: Color = MaterialTheme.colors.surface,
    drawerContentColor: Color = contentColorFor(drawerBackgroundColor),
    drawerScrimColor: Color = DrawerDefaults.scrimColor,
    backgroundColor: Color = MaterialTheme.colors.background,
    contentColor: Color = contentColorFor(backgroundColor),
    content: @Composable (PaddingValues) -> Unit
) {
    val child = @Composable { childModifier: Modifier ->
        Surface(modifier = childModifier, color = backgroundColor, contentColor = contentColor) {
            ScaffoldLayout(
                isFabDocked = isFloatingActionButtonDocked,
                fabPosition = floatingActionButtonPosition,
                topBar = topBar,
                content = content,
                snackbar = {
                    snackbarHost(scaffoldState.snackbarHostState)
                },
                fab = floatingActionButton,
                bottomBar = bottomBar
            )
        }
    }

    if (drawerContent != null) {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) { // 1
            ModalDrawer(
                modifier = modifier,
                drawerState = scaffoldState.drawerState,
                gesturesEnabled = drawerGesturesEnabled,
                drawerContent = drawerContent,
                drawerShape = drawerShape,
                drawerElevation = drawerElevation,
                drawerBackgroundColor = drawerBackgroundColor,
                drawerContentColor = drawerContentColor,
                scrimColor = drawerScrimColor,
                content = {
                    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {  // 2
                        child(Modifier)
                    }
                }
            )
        }
    } else {
        child(modifier)
    }
}

@Composable
@UiComposable
private fun ScaffoldLayout(
    isFabDocked: Boolean,
    fabPosition: FabPosition,
    topBar: @Composable @UiComposable () -> Unit,
    content: @Composable @UiComposable (PaddingValues) -> Unit,
    snackbar: @Composable @UiComposable () -> Unit,
    fab: @Composable @UiComposable () -> Unit,
    bottomBar: @Composable @UiComposable () -> Unit
) {
    SubcomposeLayout { constraints ->
        val layoutWidth = constraints.maxWidth
        val layoutHeight = constraints.maxHeight

        val looseConstraints = constraints.copy(minWidth = 0, minHeight = 0)

        layout(layoutWidth, layoutHeight) {
            val topBarPlaceables = subcompose(ScaffoldLayoutContent.TopBar, topBar).fastMap {
                it.measure(looseConstraints)
            }

            val topBarHeight = topBarPlaceables.fastMaxBy { it.height }?.height ?: 0

            val snackbarPlaceables = subcompose(ScaffoldLayoutContent.Snackbar, snackbar).fastMap {
                it.measure(looseConstraints)
            }

            val snackbarHeight = snackbarPlaceables.fastMaxBy { it.height }?.height ?: 0

            val fabPlaceables =
                subcompose(ScaffoldLayoutContent.Fab, fab).mapNotNull { measurable ->
                    measurable.measure(looseConstraints).takeIf { it.height != 0 && it.width != 0 }
                }

            val fabPlacement = if (fabPlaceables.isNotEmpty()) {
                val fabWidth = fabPlaceables.fastMaxBy { it.width }!!.width
                val fabHeight = fabPlaceables.fastMaxBy { it.height }!!.height
                // FAB distance from the left of the layout, taking into account LTR / RTL
                val fabLeftOffset = if (fabPosition == FabPosition.End) {
                    if (layoutDirection == LayoutDirection.Ltr) {
                        layoutWidth - FabSpacing.roundToPx() - fabWidth
                    } else {
                        FabSpacing.roundToPx()
                    }
                } else {
                    (layoutWidth - fabWidth) / 2
                }

                FabPlacement(
                    isDocked = isFabDocked,
                    left = fabLeftOffset,
                    width = fabWidth,
                    height = fabHeight
                )
            } else {
                null
            }

            val bottomBarPlaceables = subcompose(ScaffoldLayoutContent.BottomBar) {
                CompositionLocalProvider(
                    LocalFabPlacement provides fabPlacement,
                    content = bottomBar
                )
            }.fastMap { it.measure(looseConstraints) }

            val bottomBarHeight = bottomBarPlaceables.fastMaxBy { it.height }?.height ?: 0
            val fabOffsetFromBottom = fabPlacement?.let {
                if (bottomBarHeight == 0) {
                    it.height + FabSpacing.roundToPx()
                } else {
                    if (isFabDocked) {
                        // Total height is the bottom bar height + half the FAB height
                        bottomBarHeight + (it.height / 2)
                    } else {
                        // Total height is the bottom bar height + the FAB height + the padding
                        // between the FAB and bottom bar
                        bottomBarHeight + it.height + FabSpacing.roundToPx()
                    }
                }
            }

            val snackbarOffsetFromBottom = if (snackbarHeight != 0) {
                snackbarHeight + (fabOffsetFromBottom ?: bottomBarHeight)
            } else {
                0
            }

            val bodyContentHeight = layoutHeight - topBarHeight

            val bodyContentPlaceables = subcompose(ScaffoldLayoutContent.MainContent) {
                val innerPadding = PaddingValues(bottom = bottomBarHeight.toDp())
                content(innerPadding)
            }.fastMap { it.measure(looseConstraints.copy(maxHeight = bodyContentHeight)) }

            // Placing to control drawing order to match default elevation of each placeable

            bodyContentPlaceables.fastForEach {
                it.place(0, topBarHeight)
            }
            topBarPlaceables.fastForEach {
                it.place(0, 0)
            }
            snackbarPlaceables.fastForEach {
                it.place(0, layoutHeight - snackbarOffsetFromBottom)
            }
            // The bottom bar is always at the bottom of the layout
            bottomBarPlaceables.fastForEach {
                it.place(0, layoutHeight - bottomBarHeight)
            }
            // Explicitly not using placeRelative here as `leftOffset` already accounts for RTL
            fabPlacement?.let { placement ->
                fabPlaceables.fastForEach {
                    it.place(placement.left, layoutHeight - fabOffsetFromBottom!!)
                }
            }
        }
    }
}

/**
 * Placement information for a [FloatingActionButton] inside a [Scaffold].
 *
 * @property isDocked whether the FAB should be docked with the bottom bar
 * @property left the FAB's offset from the left edge of the bottom bar, already adjusted for RTL
 * support
 * @property width the width of the FAB
 * @property height the height of the FAB
 */
@Immutable
internal class FabPlacement(
    val isDocked: Boolean,
    val left: Int,
    val width: Int,
    val height: Int
)

/**
 * CompositionLocal containing a [FabPlacement] that is read by [BottomAppBar] to calculate notch
 * location.
 */
internal val LocalFabPlacement = staticCompositionLocalOf<FabPlacement?> { null }

// FAB spacing above the bottom bar / bottom of the Scaffold
private val FabSpacing = 16.dp

private enum class ScaffoldLayoutContent { TopBar, MainContent, Snackbar, Fab, BottomBar }