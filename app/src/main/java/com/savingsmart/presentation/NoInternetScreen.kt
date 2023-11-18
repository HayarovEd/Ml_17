package com.savingsmart.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.savingsmart.R
import com.savingsmart.presentation.MainEvent.Reconnect
import com.savingsmart.ui.theme.baseText
import com.savingsmart.ui.theme.grey
import com.savingsmart.ui.theme.secondText
import com.savingsmart.ui.theme.thirdText

@Composable
fun NoInternetScreen(
    modifier: Modifier = Modifier,
    onEvent: (MainEvent) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            //.background(color = baseBackground)
            .padding(27.dp)
    ) {
        Image(
            modifier = modifier
                .fillMaxSize(),
            painter = painterResource(id = R.drawable.background_image),
            contentDescription = ""
        )
        Column(
            modifier = modifier.align(alignment = Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = modifier.fillMaxWidth(),
                painter = painterResource(
                    id = R.drawable.no_connection
                ),
                contentDescription = "",
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = modifier.height(62.dp))
            Text(
                text = stringResource(id = R.string.not_connect),
                fontSize = 16.sp,
                fontWeight = FontWeight(700),
                fontStyle = FontStyle(R.font.dinpro),
                color = baseText,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.try_internet),
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                fontStyle = FontStyle(R.font.dinpro),
                color = secondText,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = modifier.height(60.dp))
            Button(
                modifier = modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                contentPadding = PaddingValues(
                    vertical = 16.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = grey,
                    contentColor = thirdText,
                ),
                onClick = { onEvent(Reconnect) }
            ) {
                Text(
                    text = stringResource(id = R.string.reconnect),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.dinpro)),
                        fontWeight = FontWeight(500),
                    )
                )
            }
        }
        /*Button(
            modifier = modifier
                .fillMaxWidth()
                .align(alignment = Alignment.BottomCenter),
            shape = RoundedCornerShape(80.dp),
            *//*border = BorderStroke(
                width = 1.dp,
                color = green
            ),*//*
            contentPadding = PaddingValues(
                vertical = 16.dp
            ),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = orange,
                contentColor = white,
            ),
            onClick = { onEvent(Reconnect) }
        ) {
            Text(
                text = stringResource(id = R.string.reconnect),
                style = TextStyle(
                    fontSize = 22.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontWeight = FontWeight(600),
                )
            )
        }*/
    }
}

@Preview
@Composable
fun SampleNoInternetScreen() {
    NoInternetScreen(onEvent = {})
}
