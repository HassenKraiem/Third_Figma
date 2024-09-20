package com.example.thirdfigma

import android.os.Bundle
import android.widget.ScrollView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ScrollingView
import com.example.thirdfigma.ui.theme.ThirdFigmaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThirdFigmaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AllViews(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ThirdFigmaTheme {
        AllViews()
    }
}

@Composable
fun UpView(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
        Box {
            Button(
                onClick = { /*TODO*/ }, colors = ButtonColors(
                    contentColor = Color.Yellow,
                    containerColor = Color.White,
                    disabledContentColor = Color.Yellow,
                    disabledContainerColor = Color.Red
                ), modifier = Modifier.fillMaxWidth(0.25f), border = BorderStroke(2.dp, Color.Black)
            ) {
                Image(
                    painter = painterResource(R.drawable.arrow___left),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxWidth(0.5f)
                )
            }
        }
        Text(
            text = "إعدادات أوقات الصلاة",
            fontSize = 20.sp,
            modifier = Modifier.fillMaxWidth(0.8f),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.cairobold))
        )
    }


}

@Composable
fun MainView(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = ":" + "تعديل وقت الصلاة يدويا",
            textAlign = TextAlign.End,
            modifier = Modifier.fillMaxWidth(),
            fontFamily = FontFamily(Font(R.font.cairomedium))

        )
        Text(
            text = stringResource(R.string.Guide),
            textAlign = TextAlign.End,
            fontFamily = FontFamily(Font(R.font.cairomedium))
        )

        Boxes(title = "ضبط وقت الفجر", minutes = "0")
        Boxes(title = "ضبط وقت الشروق", minutes = "-4")
        Boxes(title = "ضبط وقت الظهر", minutes = "3")
        Boxes(title = "ضبط وقت العصر", minutes = "-3")
        Boxes(title = "ضبط وقت المغرب", minutes = "0")
        Boxes(title = "ضبط وقت العشاء", minutes = "12")
    }
}


@Composable
fun Boxes(modifier: Modifier = Modifier, title: String, minutes: String) {
    Column(modifier = modifier) {
        Text(
            text = title, modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.End,
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.cairolight))
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "دقائق",
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .padding(horizontal = 15.dp),
                textAlign = TextAlign.End,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.cairolight))
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(35.dp)
                    .border(2.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))
            ) {
                Text(
                    text = minutes,
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth(0.90f).padding(top = 5.dp)
                )
            }

        }
    }
}

@Composable
fun MiddleView(modifier: Modifier = Modifier) {
    Column {
        Text(
            text = ":" + "التعديل الهجري",
            textAlign = TextAlign.End,
            fontSize = 25.sp,
            modifier = Modifier.fillMaxWidth(),
            fontFamily = FontFamily(Font(R.font.cairobold),)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))
        ) {
            Button(
                onClick = {}, colors = ButtonColors(
                    containerColor = Color.White,
                    contentColor = Color.Yellow,
                    disabledContainerColor = Color.Black,
                    disabledContentColor = Color.Black
                )
            ) {
                Image(
                    painter = painterResource(R.drawable.vector),
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )
            }
            Text(
                text = "0 أيام", textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth(0.90f).
                padding(top = 10.dp),
                fontFamily = FontFamily(Font(R.font.cairomedium))
            )
        }
    }

}

@Composable
fun DownView(modifier: Modifier = Modifier) {
    var isSelected by remember { mutableStateOf(false) }
    val TargetColor = if (isSelected) colorResource(R.color.Asfar) else Color.White
    Column {
        Text(text = ":"+"قاعدة خطوط العرض العالية",
            textAlign = TextAlign.End,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 25.sp,
            fontFamily = FontFamily(Font(R.font.cairobold)))
        Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            Text(text = "ضبط القاعدة تلقائيًا",
                modifier=Modifier.padding(top = 12.dp),
                fontFamily = FontFamily(Font(R.font.cairolight)),
                fontSize = 25.sp)
            Button(
                onClick = { isSelected = !isSelected }, Modifier.padding(top = 12.dp)
                    .background(color = Color.White)
                    .border(2.dp, color = colorResource(R.color.Asfar), shape = RoundedCornerShape(15.dp))
                , colors = ButtonColors(
                    containerColor =TargetColor,
                    contentColor = Color.Black,
                    disabledContainerColor = Color.Black,
                    disabledContentColor = Color.Black
                )
            ) {
                if (isSelected) {
                    Text(text = "⎷",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 25.sp)
                } else {
                    Text(text = "")
                }
            }
        }
        Text(text = ":"+"اختيار القاعدة",
            modifier=Modifier.fillMaxWidth(),
            textAlign = TextAlign.End,
            fontSize = 25.sp,
            fontFamily = FontFamily(Font(R.font.cairobold)))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))
        ) {
            Button(
                onClick = {}, colors = ButtonColors(
                    containerColor = Color.White,
                    contentColor = Color.Yellow,
                    disabledContainerColor = Color.Black,
                    disabledContentColor = Color.Black
                )
            ) {
                Image(
                    painter = painterResource(R.drawable.vector),
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )
            }
            Text(
                text = "0 أيام", textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth(0.90f)
                    .padding(12.dp),
                fontFamily = FontFamily(Font(R.font.cairomedium))
            )
        }
    }

}
@Composable
fun AllViews(modifier: Modifier=Modifier){
    Box(modifier=modifier.fillMaxSize().verticalScroll(state = rememberScrollState()).padding(20.dp)) {
        Image(
            painter = painterResource(R.drawable.group_580),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(modifier = Modifier.fillMaxSize()) {
            UpView()
            MainView()
            MiddleView()
            DownView()
        }
    }
}
