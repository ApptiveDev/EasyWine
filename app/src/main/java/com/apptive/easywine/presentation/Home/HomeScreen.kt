package com.apptive.easywine.presentation.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import coil.compose.AsyncImage
import com.apptive.easywine.R
import com.apptive.easywine.presentation.components.TextTopBar
import com.apptive.easywine.ui.theme.gray_button
import com.apptive.easywine.ui.theme.gray_text
import com.apptive.easywine.ui.theme.white_gray
import com.apptive.easywine.ui.theme.wine_main
import com.google.accompanist.pager.*
import kotlin.math.absoluteValue

@Composable
fun HomeScreen() {

	val scrollState = rememberScrollState()

	Column(
		modifier = Modifier
			.background(Color.White)
			.fillMaxSize()
			.verticalScroll(scrollState)
	) {
		TextTopBar(title = "EASY WINE",27)
		WavyLines()
		HomeMainBanner()

		Spacer(modifier = Modifier.size(30.dp))

		OtherServices()
	}


}

@Composable
fun HomeMainBanner() {
	Box(
		modifier = Modifier
			.fillMaxWidth()
			.height(400.dp)
	) {
		Surface(
			modifier = Modifier
				.fillMaxWidth()
				.fillMaxHeight()
				.shadow(elevation = 2.dp, shape = CircleShape, clip = true)
		) {
			WineBannerPager(
				listOf(
					"https://user-images.githubusercontent.com/46425142/192774628-d66ad349-5d77-446d-894b-914d9bfede43.png",
					"https://user-images.githubusercontent.com/46425142/192770225-de2198ae-955f-44e6-b00a-403ad29dc942.png",
					"https://user-images.githubusercontent.com/46425142/192770249-56ccf188-8517-451e-b9f1-e379f5f7e21f.png",
					"https://user-images.githubusercontent.com/46425142/192770281-792f3796-d76e-464a-9967-7b9daf86d75e.png",
					"https://user-images.githubusercontent.com/46425142/192770309-fb401cca-300f-48b8-8eff-66405a134659.png"
				)
			)
		}

		Icon(
			painter = painterResource(id = R.drawable.wine_right_arrow),
			contentDescription = "wine_right_arrow icon",
			modifier = Modifier
				.size(50.dp)
				.align(Alignment.CenterStart),
			tint = wine_main
		)

		Icon(
			painter = painterResource(id = R.drawable.wine_left_arrow),
			contentDescription = "wine_left_arrow icon",
			modifier = Modifier
				.size(50.dp)
				.align(Alignment.CenterEnd),
			tint = wine_main
		)

		Button(
			onClick = {}, // TODO naviagate to surveyform
			modifier = Modifier
				.align(Alignment.BottomCenter)
				.size(212.dp, 47.dp),
			colors = ButtonDefaults.buttonColors(
				backgroundColor = wine_main
			),
			shape = RoundedCornerShape(9.dp)
		) {
			Text(
				text = "검사하기",
				color = Color.White,
				fontSize = 20.sp,
				fontWeight = FontWeight.ExtraBold
			)
		}
	}
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun BoxScope.WineBannerPager(
	images: List<String>
) {
	val pagerState = rememberPagerState()

	Box(
		modifier = Modifier
			.fillMaxSize()
			.align(Alignment.Center),
		contentAlignment = Alignment.Center
	) {
		HorizontalPager(
			count = images.size,
			state = pagerState,
			contentPadding = PaddingValues(horizontal = 46.dp),
			modifier = Modifier
				.padding(0.dp)
				.fillMaxWidth()
		) { page ->
			AsyncImage(
				model = coil.request.ImageRequest.Builder(LocalContext.current)
					.data(images[page])
					.crossfade(true)
					.build(),
				contentDescription = "",
				placeholder = painterResource(R.drawable.wine_img_placeholder),
				contentScale = ContentScale.Fit,
				modifier = Modifier
					.graphicsLayer {
						val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
						lerp(
							start = 0.85f,
							stop = 1f,
							fraction = 1f - pageOffset.coerceIn(0f, 1f)
						).also { scale ->
							scaleX = scale
							scaleY = scale
						}

						alpha = lerp(
							start = 0.5f,
							stop = 1f,
							fraction = 1f - pageOffset.coerceIn(0f, 1f)
						)
					}
					.fillMaxSize(),
			)
		}
	}
}


@Composable
fun WavyLines() {
	Spacer(Modifier.size(10.dp))
	Image(
		painterResource(id = R.drawable.home_wave),
		contentDescription = "top bar image",
		contentScale = ContentScale.FillWidth,
		modifier = Modifier.fillMaxWidth()
	)
	Spacer(Modifier.size(10.dp))
}

@Composable
fun OtherServices() {
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.wrapContentHeight()
	) {
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(horizontal = 30.dp),
			horizontalArrangement = Arrangement.Start
		) {
			Text(
				text = "Other Services",
				color = wine_main,
				fontWeight = FontWeight.Bold,
				fontSize = 18.sp
			)
		}

		LazyRow() {
			item { Spacer(Modifier.size(10.dp)) }
			repeat(4) {
				item { QCard("와인창고", "현재까지 추천받은 와인들을 모두 모아 보여드려요") }
			}
		}
	}
}

@Composable
fun QCard(
	title: String,
	textContent: String,
	onButtonClick: () -> Unit = {}
) {
	Card(
		modifier = Modifier
			.padding(vertical = 20.dp, horizontal = 10.dp)
			.size(315.dp, 126.dp)
//			.fillMaxSize(),
//		elevation = 1.dp,
		,
		shape = RoundedCornerShape(2.dp),
		backgroundColor = white_gray
	) {
		Box(
			modifier = Modifier
				.padding(15.dp)
		) {
			Column(
				modifier = Modifier.fillMaxWidth(),
				verticalArrangement = Arrangement.spacedBy(10.dp)
			) {
				Row(
					horizontalArrangement = Arrangement.Start,
					verticalAlignment = Alignment.CenterVertically
				) {
					Icon(
						painter = painterResource(id = R.drawable.icon_wine_barrel),
						contentDescription = "wine barrel icon",
						modifier = Modifier.size(28.dp)
					)

					Spacer(Modifier.size(15.dp))

					Text(
						text = title,
						color = gray_text,
						fontSize = 14.sp,
						fontWeight = FontWeight.ExtraBold
					)
				}

				Box(modifier = Modifier.fillMaxSize()) {
					Text(
						text = textContent,
						color = gray_text,
						fontSize = 14.sp,
						fontWeight = FontWeight.Bold,
						modifier = Modifier
							.width(170.dp)
							.align(Alignment.TopStart)
					)
					TextButton(
						onClick = onButtonClick,
						colors = ButtonDefaults.buttonColors(
							backgroundColor = gray_button,
						),
						shape = RoundedCornerShape(68.dp),
						modifier = Modifier
							.size(96.dp, 32.dp)
							.align(Alignment.BottomEnd)
					) {
						Text(
							text = title,
							color = Color.White,
							fontSize = 14.sp,
							fontWeight = FontWeight.ExtraBold
						)
					}
				}
			}

			Row(
				Modifier.align(Alignment.TopEnd)
			) {
				Text(
					text = "more",
					color = Color(0xFF929292),
					fontWeight = FontWeight.Normal,
					fontSize = 15.sp
				)
				Image(
					painterResource(id = R.drawable.right_double_shift),
					contentDescription = "placeholder circle image",
					modifier = Modifier.size(15.dp)
				)
			}
		}
	}
}


@Preview
@Composable
fun PreviewHome() {
	HomeScreen()
}