package com.example.thirdfigma

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thirdfigma.ui.theme.ThirdFigmaTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            CompositionLocalProvider(
                LocalLayoutDirection provides LayoutDirection.Rtl
            ) {

                ThirdFigmaTheme {
                    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                        CenterAlignedTopAppBar(
                            title = {
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(color = Color.White)
                                ) {Text(
                                    text = "إعدادات أوقات الصلاة",
                                    fontSize = 20.sp,
                                    modifier = Modifier,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily(Font(R.font.cairobold))
                                )
                                    Box {
                                        Button(
                                            onClick = { /*TODO*/ },
                                            colors = ButtonColors(
                                                contentColor = Color.Yellow,
                                                containerColor = Color.White,
                                                disabledContentColor = Color.Yellow,
                                                disabledContainerColor = Color.Red
                                            ),
                                            modifier = Modifier,
                                            border = BorderStroke(2.dp, Color.White)
                                        ) {
                                            Image(
                                                painter = painterResource(R.drawable.arrow___left),
                                                contentDescription = null,
                                                contentScale = ContentScale.Fit,
                                                modifier = Modifier
                                            )
                                        }
                                    }

                                }

                            }
                        )
                    }) { innerPadding ->
                        AllViews(
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
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
fun MainView(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "تعديل وقت الصلاة يدويا :",
            modifier = Modifier
                .fillMaxWidth()
                .height(34.dp),
            fontFamily = FontFamily(Font(R.font.cairobold)),
            fontSize = 20.sp,
            color = colorResource(R.color.assouad1)


        )
        Text(
            text = stringResource(R.string.Guide),
            fontFamily = FontFamily(Font(R.font.cairomedium)),
            fontSize = 14.sp,
            color = colorResource(R.color.assouad1)
        )

        Boxes(title = "ضبط وقت الفجر", minutes = "0")
        Boxes(title = "ضبط وقت الشروق", minutes = "4-")
        Boxes(title = "ضبط وقت الظهر", minutes = "3")
        Boxes(title = "ضبط وقت العصر", minutes = "3-")
        Boxes(title = "ضبط وقت المغرب", minutes = "0")
        Boxes(title = "ضبط وقت العشاء", minutes = "12")
    }
}


@Composable
fun Boxes(modifier: Modifier = Modifier, title: String, minutes: String) {
    Column(modifier = modifier) {
        Text(
            text = title, modifier = Modifier.fillMaxWidth(),
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.cairomedium))
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .width(211.dp)
                    .height(46.dp)
                    .border(2.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))
            ) {
                Text(
                    text = minutes,
                    modifier = Modifier
                        .fillMaxWidth(0.90f)
                        .padding(horizontal = 10.dp)
                        .padding(top = 10.dp)
                )
            }
            Text(
                text = "دقائق",
                modifier = Modifier
                    .padding(top = 6.dp)
                    .padding(horizontal = 15.dp),
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.cairomedium))
            )

        }
    }
}

@Composable
fun MiddleView(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text =  "التعديل الهجري",
            fontSize = 18.sp,
            modifier = Modifier
                .fillMaxWidth()
                .height(34.dp),
            fontFamily = FontFamily(Font(R.font.cairobold))
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(46.dp)
                .border(2.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))
        ) {
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "0 أيام",
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .padding(horizontal = 15.dp),
                    fontFamily = FontFamily(Font(R.font.cairomedium))
                )
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


            }
        }
    }

}

@Composable
fun DownView(modifier: Modifier = Modifier) {
    var isSelected by remember { mutableStateOf(false) }
    Column(modifier=modifier) {
        Text(
            text =  "قاعدة خطوط العرض العالية :",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 25.sp,
            fontFamily = FontFamily(Font(R.font.cairobold))
        )
        Row(modifier = Modifier.fillMaxWidth()) {


            Checkbox(checked = isSelected, onCheckedChange = {
                    isSelected = !isSelected
                }, modifier = Modifier, colors = CheckboxColors(
                checkedCheckmarkColor = colorResource(R.color.assouad2),
                uncheckedCheckmarkColor = Color.Yellow,
                checkedBoxColor = colorResource(R.color.Asfar),
                uncheckedBoxColor =Color.White,
                disabledCheckedBoxColor = Color.Yellow,
                disabledUncheckedBoxColor =Color.Red,
                disabledIndeterminateBoxColor = Color.Green,
                checkedBorderColor = colorResource(R.color.Asfar),
                uncheckedBorderColor = colorResource(R.color.Asfar),
                disabledBorderColor = Color.Black,
                disabledUncheckedBorderColor = Color.Cyan,
                disabledIndeterminateBorderColor = Color.DarkGray
            ))
            Text(
                text = "ضبط القاعدة تلقائيًا",
                modifier = Modifier.padding(top = 12.dp),
                fontFamily = FontFamily(Font(R.font.cairomedium)),
                fontSize = 14.sp
            )

//            Button(
//                onClick = { isSelected = !isSelected }, Modifier.padding(top = 12.dp)
//                    .background(color = Color.White)
//                    .border(2.dp, color = colorResource(R.color.Asfar), shape = RoundedCornerShape(15.dp))
//                , colors = ButtonColors(
//                    containerColor =TargetColor,
//                    contentColor = Color.Black,
//                    disabledContainerColor = Color.Black,
//                    disabledContentColor = Color.Black
//                )
//            ) {
//                if (isSelected) {
//                    Text(text = "⎷",
//                        fontWeight = FontWeight.ExtraBold,
//                        fontSize = 25.sp)
//                } else {
//                    Text(text = "")
//                }
//            }
        }
        Text(
            text = "اختيار القاعدة :",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 25.sp,
            fontFamily = FontFamily(Font(R.font.cairobold))
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(46.dp)
                .border(2.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))
        ) {
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "0 أيام",
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .padding(horizontal = 15.dp),
                    fontFamily = FontFamily(Font(R.font.cairomedium))
                )
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


            }
        }
    }

}


@Composable
fun AllViews(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
            .padding(20.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.group_580),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(modifier = Modifier.fillMaxSize()) {
            MainView()
            MiddleView()
            DownView()
        }
    }
}