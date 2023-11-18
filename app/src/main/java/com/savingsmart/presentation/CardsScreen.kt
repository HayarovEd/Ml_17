package com.savingsmart.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.savingsmart.R
import com.savingsmart.R.drawable
import com.savingsmart.domain.model.TypeCard
import com.savingsmart.domain.model.basedto.BaseState
import com.savingsmart.domain.model.basedto.CardsCredit
import com.savingsmart.domain.model.basedto.CardsDebit
import com.savingsmart.domain.model.basedto.CardsInstallment
import com.savingsmart.ui.theme.baseText
import com.savingsmart.ui.theme.green
import com.savingsmart.ui.theme.grey
import com.savingsmart.ui.theme.white
import com.savingsmart.ui.theme.yellow

@Composable
fun CardsScreen(
    modifier: Modifier = Modifier,
    valuePaddings: PaddingValues,
    creditCards: List<CardsCredit>,
    debitCards: List<CardsDebit>,
    installmentCards: List<CardsInstallment>,
    typeCard: TypeCard,
    onEvent: (MainEvent) -> Unit,
    baseState: BaseState,
    creditCardloanLazyState: LazyListState,
    debitCardLazyState: LazyListState,
    instalmentCardLazyState: LazyListState,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = white)
            .padding(valuePaddings)
    ) {
        Image(
            modifier = modifier
                .fillMaxSize(),
            painter = painterResource(id = drawable.background_image),
            contentDescription = ""
        )
        Column(
            modifier = modifier
                .fillMaxSize()
                //.background(color = baseBackground)
                .padding(valuePaddings),
        ) {
            Row(
                modifier = modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = grey,
                        shape = RoundedCornerShape(size = 8.dp)
                    )
                    .clip(shape = RoundedCornerShape(size = 8.dp))
                    .background(color = white),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (!creditCards.isNullOrEmpty()) {
                    Button(
                        modifier = modifier
                            .weight(1f),
                        onClick = { onEvent(MainEvent.OnChangeTypeCard(TypeCard.CardCredit)) },
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = if (typeCard is TypeCard.CardCredit) yellow else white
                        ),
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(5.dp),
                        /*border = BorderStroke(
                            width = 1.dp,
                            color = if (typeCard is TypeCard.CardCredit) green else baseBackground
                        )*/
                    ) {
                        Text(
                            color = if (typeCard is TypeCard.CardCredit) green else baseText,
                            fontStyle = FontStyle(R.font.dinpro),
                            fontSize = 13.sp,
                            fontWeight = FontWeight(600),
                            text = stringResource(id = R.string.credit),
                            textAlign = TextAlign.Center
                        )
                    }
                }
                if (!debitCards.isNullOrEmpty()) {
                    Button(
                        modifier = modifier
                            .weight(1f),
                        onClick = { onEvent(MainEvent.OnChangeTypeCard(TypeCard.CardDebit)) },
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = if (typeCard is TypeCard.CardDebit) yellow else white
                        ),
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(5.dp),
                        /*border = BorderStroke(
                            width = 1.dp,
                            color = if (typeCard is TypeCard.CardDebit) green else baseBackground
                        )*/
                    ) {
                        Text(
                            color = if (typeCard is TypeCard.CardDebit) green else baseText,
                            fontStyle = FontStyle(R.font.dinpro),
                            fontSize = 13.sp,
                            fontWeight = FontWeight(600),
                            text = stringResource(id = R.string.debit),
                            textAlign = TextAlign.Center
                        )
                    }
                }
                if (!installmentCards.isNullOrEmpty()) {
                    Button(
                        modifier = modifier
                            .weight(1f),
                        onClick = { onEvent(MainEvent.OnChangeTypeCard(TypeCard.CardInstallment)) },
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = if (typeCard is TypeCard.CardInstallment) yellow else white
                        ),
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(vertical = 5.dp),
                        /* border = BorderStroke(
                             width = 1.dp,
                             color = if (typeCard is TypeCard.CardInstallment) green else baseBackground
                         )*/
                    ) {
                        Text(
                            color = if (typeCard is TypeCard.CardInstallment) green else baseText,
                            fontStyle = FontStyle(R.font.dinpro),
                            fontSize = 13.sp,
                            fontWeight = FontWeight(600),
                            text = stringResource(id = R.string.installment),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
            Spacer(modifier = modifier.height(10.dp))
            when (typeCard) {
                TypeCard.CardCredit -> {
                    LazyColumn(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        state = creditCardloanLazyState
                    ) {
                        items(creditCards) { card ->
                            ItemCreditCard(
                                card = card,
                                onEvent = onEvent,
                                baseState = baseState
                            )
                        }
                    }
                }

                TypeCard.CardDebit -> {
                    LazyColumn(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        state = debitCardLazyState
                    ) {
                        items(debitCards) { card ->
                            ItemDebitCard(
                                card = card,
                                onEvent = onEvent,
                                baseState = baseState,
                            )
                        }
                    }
                }

                TypeCard.CardInstallment -> {
                    LazyColumn(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        state = instalmentCardLazyState
                    ) {
                        items(installmentCards) { card ->
                            ItemInstallmentCard(
                                card = card,
                                baseState = baseState,
                                onEvent = onEvent
                            )
                        }
                    }
                }
            }

        }
    }
}
