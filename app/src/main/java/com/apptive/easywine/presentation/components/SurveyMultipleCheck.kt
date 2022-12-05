import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.easywine.presentation.viewmodel.MultiCheckButtonViewModel
import com.apptive.easywine.ui.theme.wine_button

val viewModel = MultiCheckButtonViewModel()

@Composable
fun SurveyMultipleCheck(){
    viewModel.initIsChecked(8)

    Column(
        modifier = Modifier.padding(horizontal = 23.dp)
    ){
        Row(
            horizontalArrangement = Arrangement.Center
        ){
            CustomButton(buttonNo = 0, width = 95.dp , text = "#축하파티")
            Spacer(modifier = Modifier.width(11.dp))
            CustomButton(buttonNo = 1, width = 91.dp , text = "#선물")
            Spacer(modifier = Modifier.width(11.dp))
            CustomButton(buttonNo = 2, width = 102.dp , text = "#회와_함께")
        }
        Spacer(modifier = Modifier.height(22.dp))
        Row(
            horizontalArrangement = Arrangement.Center
        ){
            CustomButton(buttonNo = 3, width = 138.dp , text = "#육고기와_함께")
            Spacer(modifier = Modifier.width(18.dp))
            CustomButton(buttonNo = 4, width = 154.dp , text = "#간단한__와")
        }
        Spacer(modifier = Modifier.height(22.dp))
        Row(
            horizontalArrangement = Arrangement.Center
        ){
            CustomButton(buttonNo = 5, width = 140.dp , text = "#연인과_데이트")
            Spacer(modifier = Modifier.width(16.dp))
            CustomButton(buttonNo = 6, width = 154.dp , text = "#부모님과_함께")
        }
        Spacer(modifier = Modifier.height(22.dp))
        Row(
            horizontalArrangement = Arrangement.Center
        ){
            CustomButton(buttonNo = 7, width = 154.dp , text = "#친구들과_함께")
            Spacer(modifier = Modifier.width(156.dp))
        }
    }
}

@Composable
fun CustomButton(
    buttonNo: Int,
    width: Dp,
    text: String
) {
    Button(
        onClick = {viewModel.setIsChecked(buttonNo, ischecked = !viewModel.ischecked[buttonNo])},
        modifier = Modifier
            .width(width)
            .height(42.dp)
            .alpha(if(viewModel.ischecked[buttonNo]) 0.3f  else 1f),
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
    SurveyMultipleCheck()
}
