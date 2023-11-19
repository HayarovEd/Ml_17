package com.savingsmart.presentation

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import coil.compose.AsyncImage
import com.savingsmart.R
import com.savingsmart.R.drawable
import com.savingsmart.R.string
import com.savingsmart.data.VALUE_ONE
import com.savingsmart.domain.model.ElementOffer
import com.savingsmart.domain.model.StatusApplication
import com.savingsmart.domain.model.basedto.BaseState
import com.savingsmart.ui.theme.baseText
import com.savingsmart.ui.theme.green
import com.savingsmart.ui.theme.grey
import com.savingsmart.ui.theme.white
import com.savingsmart.ui.theme.yellow

@SuppressLint("ResourceAsColor")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OfferScreen(
    modifier: Modifier = Modifier,
    elementOffer: ElementOffer,
    baseState: BaseState,
    onEvent: (MainEvent) -> Unit,
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = white
                ),
                title = {
                    Row(
                        modifier = modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = {
                            onEvent(
                                MainEvent.OnChangeStatusApplication(
                                    StatusApplication.Connect(baseState)
                                )
                            )
                        }) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_back_24),
                                tint = baseText,
                                contentDescription = ""
                            )
                        }
                        Spacer(modifier = modifier.width(15.dp))
                        Text(
                            color = baseText,
                            fontStyle = FontStyle(R.font.dinpro),
                            fontSize = 16.sp,
                            fontWeight = FontWeight(700),
                            text = elementOffer.name
                        )
                    }
                }
            )
        },
        /*bottomBar = {
            BottomAppBar(
                containerColor = white
            ) {
                Button(
                    modifier = modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .weight(3f),
                    //.padding(horizontal = 15.dp)
                    //.fillMaxWidth(),
                    shape = RoundedCornerShape(80.dp),
                    contentPadding = PaddingValues(
                        vertical = 16.dp,
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = orange,
                        contentColor = white,
                    ),
                    onClick = {
                        onEvent(
                            MainEvent.OnGoToWeb(
                                urlOffer = elementOffer.order,
                                nameOffer = elementOffer.name
                            )
                        )
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.checkout),
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontFamily = FontFamily(Font(R.font.montserrat)),
                            fontWeight = FontWeight(600),
                        )
                    )
                }
                */
        /* Row (
                             modifier = modifier
                                 .fillMaxWidth()
                                 .padding(horizontal = 24.dp),
                             verticalAlignment = Alignment.CenterVertically
                         ) {
                             OutlinedButton(
                                 modifier = modifier.weight(1f),
                                 onClick = {
                                 onEvent(
                                     MainEvent.OnChangeStatusApplication(
                                         StatusApplication.Connect(baseState)
                                     )
                                 )
                             },
                                 shape = RoundedCornerShape(5.dp),
                                 border = BorderStroke(
                                     width = 2.dp,
                                     color = blue
                                 ),
                                 contentPadding = PaddingValues(
                                     vertical = 16.dp,
                                 ),
                                 colors = ButtonDefaults.outlinedButtonColors(
                                     containerColor = baseBackground,
                                     contentColor = blue,
                                 ),
                             ) {
                                 Icon(
                                     imageVector = ImageVector.vectorResource(id = R.drawable.route_left),
                                     tint = blue,
                                     contentDescription = ""
                                 )
                             }
                             Spacer(modifier = modifier.width(12.dp))
                             Button(
                                 modifier = modifier
                                     .weight(3f),
                                     //.padding(horizontal = 15.dp)
                                     //.fillMaxWidth(),
                                 shape = RoundedCornerShape(5.dp),
                                 contentPadding = PaddingValues(
                                     vertical = 16.dp,
                                 ),
                                 colors = ButtonDefaults.buttonColors(
                                     containerColor = blue,
                                     contentColor = baseBackground,
                                 ),
                                 onClick = {
                                     onEvent(
                                         MainEvent.OnGoToWeb(
                                             urlOffer = elementOffer.order,
                                             nameOffer = elementOffer.name
                                         )
                                     )
                                 }
                             ) {
                                 Text(
                                     text = stringResource(id = R.string.checkout),
                                     style = TextStyle(
                                         fontSize = 20.sp,
                                         fontFamily = FontFamily(Font(R.font.inter)),
                                         fontWeight = FontWeight(600),
                                     )
                                 )
                             }
                         }*/
        /*
                    }
                }*/
    ) { paddingValues ->
        Box(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            Image(
                modifier = modifier
                    .fillMaxSize(),
                painter = painterResource(id = drawable.background_image),
                contentDescription = ""
            )
            Column(
                modifier = modifier
                    .padding(top = 15.dp, start = 15.dp, end = 15.dp)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .shadow(
                        elevation = 12.dp,
                        spotColor = grey,
                        ambientColor = grey,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .clip(shape = RoundedCornerShape(20.dp))
                    .background(color = white)
                    .padding(12.dp)
                //.clip(shape = RoundedCornerShape(20.dp))
                //.background(color = lightGrey)
                //.padding(16.dp),
            ) {
                AsyncImage(
                    modifier = modifier
                        .fillMaxWidth()
                        .shadow(
                            elevation = 12.dp,
                            spotColor = grey,
                            ambientColor = grey,
                            shape = RoundedCornerShape(20.dp)
                        ),
                    model = elementOffer.pathImage,
                    contentScale = ContentScale.FillWidth,
                    contentDescription = ""
                )
                Spacer(modifier = modifier.height(16.dp))
                Text(
                    text = elementOffer.name,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.dinpro)),
                        fontWeight = FontWeight(700),
                    ),
                    color = baseText,
                )
                Spacer(modifier = modifier.height(12.dp))
                AndroidView(
                    modifier = modifier
                        .fillMaxWidth(),
                    // .clip(shape = RoundedCornerShape(5.dp))
                    // .background(color = white)
                    //.padding(5.dp),
                    factory = { context -> TextView(context) },
                    update = {
                        it.setTextColor(R.color.white)
                        it.text = HtmlCompat.fromHtml(
                            elementOffer.description,
                            HtmlCompat.FROM_HTML_MODE_COMPACT
                        )
                    }
                )
                Spacer(modifier = modifier.height(16.dp))
                RowData(
                    title = stringResource(id = string.amount),
                    content = elementOffer.amount,
                )
                if (elementOffer.showPercent == VALUE_ONE) {
                    /*Divider(
                        thickness = 1.dp,
                        color = grey
                    )*/
                    //Spacer(modifier = modifier.height(8.dp))
                    RowData(
                        title = stringResource(id = string.bet),
                        content = elementOffer.bet,
                    )
                }
                if (elementOffer.showTerm == VALUE_ONE) {
                    //Spacer(modifier = modifier.height(8.dp))
                    /*Divider(
                        thickness = 1.dp,
                        color = grey
                    )*/
                    RowData(
                        title = stringResource(id = string.term),
                        content = elementOffer.term,
                    )
                }
                Spacer(modifier = modifier.height(31.dp))
                RowCard(
                    showVisa = elementOffer.showVisa,
                    showMaster = elementOffer.showMaster,
                    showYandex = elementOffer.showYandex,
                    showMir = elementOffer.showMir,
                    showQivi = elementOffer.showQiwi,
                    showCache = elementOffer.showCache
                )
                Spacer(modifier = modifier.height(16.dp))
                Button(
                    modifier = modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                    contentPadding = PaddingValues(
                        vertical = 10.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = yellow,
                        contentColor = green,
                    ),
                    onClick = {
                        onEvent(
                            MainEvent.OnGoToWeb(
                                urlOffer = elementOffer.order,
                                nameOffer = elementOffer.name
                            )
                        )
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.checkout),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.dinpro)),
                            fontWeight = FontWeight(500),
                        )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun SampleOfferScreen() {
    OfferScreen(
        onEvent = {},
        baseState = BaseState.Loans,
        elementOffer = ElementOffer(
            name = "Google",
            order = "www.google.ru",
            amount = "30000",
            bet = "15%",
            description = "Google, Google,Google",
            nameButton = "Google",
            pathImage = "https://masterimrukami.ru/wp-content/uploads/2023/06/footbal_men_goalkeeper_football_two_ball_glove_542575_7000x46701.jpg",
            rang = "4/5",
            showCache = "1",
            showMaster = "0",
            showMir = "1",
            showQiwi = "0",
            showVisa = "1",
            showYandex = "0",
            showPercent = "1",
            showTerm = "1",
            term = "30 age"
        )
    )
}