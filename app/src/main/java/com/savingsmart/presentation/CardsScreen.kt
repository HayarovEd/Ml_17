package com.walletwizard.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.savingsmart.presentation.MainEvent
import com.walletwizard.R
import com.walletwizard.domain.model.TypeCard
import com.walletwizard.domain.model.basedto.BaseState
import com.walletwizard.domain.model.basedto.CardsCredit
import com.walletwizard.domain.model.basedto.CardsDebit
import com.walletwizard.domain.model.basedto.CardsInstallment
import com.walletwizard.ui.theme.baseBackground
import com.walletwizard.ui.theme.baseText
import com.walletwizard.ui.theme.cardColor
import com.walletwizard.ui.theme.orange
import com.walletwizard.ui.theme.white

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
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = baseBackground)
            .padding(valuePaddings),
    ) {
        Row(
            modifier = modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .background(color = cardColor),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (!creditCards.isNullOrEmpty()) {
                Button(
                    modifier = modifier
                        .weight(1f),
                    onClick = { onEvent(MainEvent.OnChangeTypeCard(TypeCard.CardCredit)) },
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if (typeCard is TypeCard.CardCredit) orange else cardColor
                    ),
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(5.dp),
                    /*border = BorderStroke(
                        width = 1.dp,
                        color = if (typeCard is TypeCard.CardCredit) green else baseBackground
                    )*/
                ) {
                    Text(
                        color = if (typeCard is TypeCard.CardCredit) white else baseText,
                        fontStyle = FontStyle(R.font.montserrat),
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
                        containerColor = if (typeCard is TypeCard.CardDebit) orange else cardColor
                    ),
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(5.dp),
                    /*border = BorderStroke(
                        width = 1.dp,
                        color = if (typeCard is TypeCard.CardDebit) green else baseBackground
                    )*/
                ) {
                    Text(
                        color = if (typeCard is TypeCard.CardDebit) white else baseText,
                        fontStyle = FontStyle(R.font.montserrat),
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
                        containerColor = if (typeCard is TypeCard.CardInstallment) orange else cardColor
                    ),
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(vertical = 5.dp),
                   /* border = BorderStroke(
                        width = 1.dp,
                        color = if (typeCard is TypeCard.CardInstallment) green else baseBackground
                    )*/
                ) {
                    Text(
                        color = if (typeCard is TypeCard.CardInstallment) white else baseText,
                        fontStyle = FontStyle(R.font.montserrat),
                        fontSize = 13.sp,
                        fontWeight = FontWeight(600),
                        text = stringResource(id = R.string.installment),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
        Spacer(modifier = modifier.height(20.dp))
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
