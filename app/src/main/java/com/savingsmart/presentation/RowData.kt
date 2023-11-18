package com.walletwizard.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walletwizard.R
import com.walletwizard.ui.theme.baseText
import com.walletwizard.ui.theme.cardColor

@Composable
fun RowData(
    modifier: Modifier = Modifier,
    title: String,
    content: String,
) {
    Row (
        modifier = modifier
            .fillMaxWidth()
            .background(color = cardColor)
            .padding(vertical = 7.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            color = baseText,
            fontStyle = FontStyle(R.font.montserrat),
            fontSize = 16.sp,
            fontWeight = FontWeight(400),
            text = title,
            textAlign = TextAlign.Start
        )
        Text(
            color = baseText,
            fontStyle = FontStyle(R.font.montserrat),
            fontSize = 16.sp,
            fontWeight = FontWeight(400),
            text = content,
            textAlign = TextAlign.End
        )
    }
}
/*
@Preview
@Composable
private fun SampleRowData () {
    RowData(
        title = stringResource(id = R.string.bet),
        content = "elementOffer.bet"
    )
}*/
