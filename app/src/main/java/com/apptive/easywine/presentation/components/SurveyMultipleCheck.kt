import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.easywine.domain.model.Question
import com.apptive.easywine.presentation.components.QuestionContainer
import com.apptive.easywine.ui.theme.wine_button
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment


@Composable
fun SurveyMultipleCheck(
	question: Question,
	onClick: (Int) -> Unit,
) {
	var checkedButtonIdx by remember { mutableStateOf(-1) }
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.padding(vertical = 20.dp)
			.padding(horizontal = 23.dp)
			.wrapContentSize(Alignment.Center),
		horizontalAlignment = Alignment.CenterHorizontally,
	) {
		QuestionContainer("Q${question.id}. ${question.context}")
		FlowRow(
			mainAxisAlignment = MainAxisAlignment.SpaceEvenly
		) {
			question.question_option.forEachIndexed { idx, it ->
				CustomButton(
					onClick = {
						if(checkedButtonIdx == idx) checkedButtonIdx = -1
						else {
							checkedButtonIdx = idx
							onClick(idx+1)
						}
					},
					text = it,
					isChecked = (checkedButtonIdx == idx)
				)
			}
		}
		Spacer(Modifier.size(20.dp))
	}
}

@Composable
fun CustomButton(
	onClick: () -> Unit = {},
	text: String,
	isChecked: Boolean,
) {
	Button(
		onClick = onClick,
		modifier = Modifier
			.padding(vertical = 10.dp)
			.padding(horizontal = 5.dp)
			.height(42.dp)
			.alpha(if (isChecked) 1f else 0.3f),
		colors = ButtonDefaults.buttonColors(backgroundColor = wine_button),
		shape = RoundedCornerShape(12.dp)
	) {
		Text(
			text = text,
			color = Color.White,
			fontSize = 13.sp,
			fontFamily = FontFamily.SansSerif,
			fontWeight = FontWeight.Normal
		)
	}
}

@Preview
@Composable
fun PreviewSurveyScreen() {
//    SurveyMultipleCheck(it)
}
