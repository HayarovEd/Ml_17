package com.savingsmart.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.savingsmart.R
import com.savingsmart.R.drawable
import com.savingsmart.R.string
import com.savingsmart.data.VALUE_ONE
import com.savingsmart.domain.model.basedto.BaseDto
import com.savingsmart.domain.model.basedto.BaseState
import com.savingsmart.domain.model.basedto.BaseState.Cards
import com.savingsmart.domain.model.basedto.BaseState.Credits
import com.savingsmart.domain.model.basedto.BaseState.Loans
import com.savingsmart.domain.model.basedto.CardsCredit
import com.savingsmart.domain.model.basedto.CardsDebit
import com.savingsmart.domain.model.basedto.CardsInstallment
import com.savingsmart.ui.theme.baseText
import com.savingsmart.ui.theme.secondText
import com.savingsmart.ui.theme.white


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConnectScreen(
    modifier: Modifier = Modifier,
    db: BaseDto,
    baseState: BaseState,
    creditCards: List<CardsCredit>,
    debitCards: List<CardsDebit>,
    installmentCards: List<CardsInstallment>,
    onEvent: (MainEvent) -> Unit,
    onClickPrimary: () -> Unit,
    onClickLoans: () -> Unit,
    onClickCards: () -> Unit,
    onClickCredits: () -> Unit,
    onClickRules: () -> Unit,
    loanLazyState: LazyListState,
    creditLazyState: LazyListState,
    creditCardloanLazyState: LazyListState,
    debitCardLazyState: LazyListState,
    instalmentCardLazyState: LazyListState,
) {
    val title = when (baseState) {
        is Cards -> stringResource(id = string.cards)
        Credits -> stringResource(id = string.credits)
        Loans -> stringResource(id = string.loans)
        is BaseState.WebPrimary -> db.appConfig.namePrimary ?: ""
    }
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = modifier
                                .fillMaxWidth(),
                            color = baseText,
                            fontStyle = FontStyle(R.font.dinpro),
                            fontSize = 24.sp,
                            fontWeight = FontWeight(700),
                            text = title,
                            textAlign = TextAlign.Center
                        )
                        /* IconButton(onClick = onClickRules) {
                             Icon(
                                 imageVector = ImageVector.vectorResource(id = R.drawable.info),
                                 tint = black,
                                 contentDescription = "")
                         }*/
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = white
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = white,
                modifier = modifier
                .clip(shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            ) {
                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    if (!db.appConfig.showedIconPrimary.isNullOrEmpty()
                        && db.appConfig.showedIconPrimary == VALUE_ONE
                        && !db.appConfig.namePrimary.isNullOrEmpty()
                        && !db.appConfig.urlPrimary.isNullOrEmpty()
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            IconButton(
                                modifier = modifier.size(70.dp),
                                onClick = onClickPrimary
                            ) {
                                Image(
                                    imageVector = ImageVector.vectorResource(drawable.money_1),
                                    contentDescription = ""
                                )
                            }
                            /*Text(
                                color = if (baseState is Loans) green else lightGray,
                                fontStyle = FontStyle(R.font.onest_400),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Normal,
                                text = db.appConfig.namePrimary
                            )*/
                        }
                    }
                    if (!db.loans.isNullOrEmpty()) {
                        ItemBottomBar(
                            color = secondText,//if (baseState is Loans) orange else grey,
                            content = stringResource(id = string.loans),
                            icon = if (baseState is Loans) drawable.loans_fill else
                                drawable.loans,
                            onClick = onClickLoans
                        )
                    }
                    if (!db.cards.isNullOrEmpty()) {
                        ItemBottomBar(
                            color = secondText,//if (baseState is Cards) orange else grey,
                            icon = if (baseState is Cards) drawable.cards_fill else
                                drawable.cards,
                            content = stringResource(id = string.cards),
                            onClick = onClickCards,
                        )
                    }
                    if (!db.credits.isNullOrEmpty()) {
                        ItemBottomBar(
                            color = secondText,//if (baseState is Credits) orange else grey,
                            icon = if (baseState is Credits) drawable.cards_fill else
                                drawable.credits,
                            content = stringResource(id = string.credits),
                            onClick = onClickCredits,
                        )
                    }
                }

            }
        }
    ) { valuePaddings ->
        when (baseState) {
            is Cards -> {
                CardsScreen(
                    valuePaddings = valuePaddings,
                    creditCards = creditCards,
                    debitCards = debitCards,
                    installmentCards = installmentCards,
                    typeCard = baseState.typeCard,
                    onEvent = onEvent,
                    baseState = baseState,
                    creditCardloanLazyState = creditCardloanLazyState,
                    debitCardLazyState = debitCardLazyState,
                    instalmentCardLazyState = instalmentCardLazyState,
                )
            }

            Credits -> {
                Credits(
                    valuePaddings = valuePaddings,
                    credits = db.credits,
                    onEvent = onEvent,
                    baseState = baseState,
                    creditLazyState = creditLazyState
                )
            }

            Loans -> {
                Loans(
                    valuePaddings = valuePaddings,
                    loans = db.loans,
                    onEvent = onEvent,
                    baseState = baseState,
                    loanLazyState = loanLazyState
                )
            }

            is BaseState.WebPrimary -> {
                WebViewScreenPrimary(
                    url = db.appConfig.urlPrimary ?: "",
                    offerName = db.appConfig.namePrimary ?: "",
                    valuePaddings = valuePaddings,
                    onEvent = onEvent
                )
            }
        }
    }
}

@Composable
fun ItemBottomBar(
    color: Color,
    icon: Int,
    content: String,
    onClick: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(
            /*colors = IconButtonDefaults.iconButtonColors(
                contentColor = colorIcon
            ),*/
            onClick = onClick
        ) {
            Image(
                modifier = Modifier.size(36.dp),
                painter = painterResource(id = icon),
                contentDescription = ""
            )
        }
        Text(
            color = color,
            fontStyle = FontStyle(R.font.roboto),
            fontSize = 14.sp,
            fontWeight = FontWeight(500),
            text = content
        )
    }
}
