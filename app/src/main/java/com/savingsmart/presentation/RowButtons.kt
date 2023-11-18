package com.savingsmart.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.savingsmart.R
import com.savingsmart.domain.model.ElementOffer
import com.savingsmart.domain.model.StatusApplication
import com.savingsmart.domain.model.basedto.BaseState
import com.savingsmart.ui.theme.baseText
import com.savingsmart.ui.theme.green
import com.savingsmart.ui.theme.grey
import com.savingsmart.ui.theme.secondText
import com.savingsmart.ui.theme.yellow

@Composable
fun RowButtons(
    modifier: Modifier = Modifier,
    titleOffer: String,
    currentBaseState: BaseState,
    onEvent: (MainEvent) -> Unit,
    name: String,
    pathImage: String,
    rang: String,
    description: String,
    amount: String,
    bet: String,
    term: String,
    showMir: String,
    showVisa: String,
    showMaster: String,
    showQiwi: String,
    showYandex: String,
    showCache: String,
    showPercent: String,
    showTerm: String,
    order: String
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = modifier
                .weight(1f)
                .clip(shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .background(color = yellow)
                .clickable(onClick = {
                    onEvent(
                        MainEvent.OnGoToWeb(
                            urlOffer = order,
                            nameOffer = name
                        )
                    )
                })
                .padding(vertical = 10.dp /*horizontal = 16.dp*/)
        ) {
            Text(
                modifier = modifier.fillMaxWidth(),
                text = stringResource(id = R.string.checkout),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.dinpro)),
                    fontWeight = FontWeight(500),
                ),
                color = green,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = modifier.width(12.dp))
        Box(
            modifier = modifier
                .weight(1f)
                //.border(width = 2.dp, color = orange, shape = RoundedCornerShape(20.dp))
                .clip(shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .background(color = grey)
                .clickable(onClick = {
                    onEvent(
                        MainEvent.OnChangeStatusApplication(
                            StatusApplication.Offer(
                                currentBaseState = currentBaseState,
                                ElementOffer(
                                    name = name,
                                    pathImage = pathImage,
                                    rang = rang,
                                    description = description,
                                    amount = amount,
                                    bet = bet,
                                    term = term,
                                    showMir = showMir,
                                    showVisa = showVisa,
                                    showMaster = showMaster,
                                    showQiwi = showQiwi,
                                    showYandex = showYandex,
                                    showCache = showCache,
                                    showPercent = showPercent,
                                    showTerm = showTerm,
                                    nameButton = titleOffer,
                                    order = order
                                )
                            )
                        )
                    )
                })
                .padding(vertical = 10.dp)
        ) {
            Text(
                modifier = modifier.fillMaxWidth(),
                text = stringResource(id = R.string.more),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.dinpro)),
                    fontWeight = FontWeight(500),
                ),
                color = secondText,
                textAlign = TextAlign.Center
            )
            /*Icon(
                modifier = modifier.align(alignment = Alignment.Center),
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_more_vert_32),
                tint = orange,
                contentDescription = ""
            )*/
        }
    }
}
