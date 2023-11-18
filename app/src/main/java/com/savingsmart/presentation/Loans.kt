
package com.savingsmart.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.savingsmart.R.drawable
import com.savingsmart.domain.model.basedto.BaseState
import com.savingsmart.domain.model.basedto.Loan
import com.savingsmart.ui.theme.white

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Loans(
    modifier: Modifier = Modifier,
    valuePaddings: PaddingValues,
    loans: List<Loan>,
    onEvent: (MainEvent) -> Unit,
    baseState: BaseState,
    loanLazyState: LazyListState,
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
                .fillMaxWidth()
                //.background(color = baseBackground)
                //.padding(valuePaddings),
        ) {
            LazyColumn(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                state = loanLazyState
            ) {
                items(loans) { loan ->
                    ItemLoan(
                        loan = loan,
                        onEvent = onEvent,
                        baseState = baseState,
                    )
                }
            }
        }
    }
}
