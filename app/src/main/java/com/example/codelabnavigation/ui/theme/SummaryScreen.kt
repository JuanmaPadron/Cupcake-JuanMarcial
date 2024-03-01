package com.example.codelabnavigation.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.codelabnavigation.R

@Composable
fun SummaryScreen(modifier : Modifier){
    Column() {
        Text(text = "QUANTITY")
        //Text(text = "${orderUiState.quantity}")
        Spacer(modifier = modifier.height(dimensionResource(R.dimen.padding_small)))
        Text(text = "FLAVOR")
        Text(text = "Valor2")
        Spacer(modifier = modifier.height(dimensionResource(R.dimen.padding_small)))
        Text(text = "PICK UP DATE")
        Text(text = "Valor3")
        Spacer(modifier = modifier.height(dimensionResource(R.dimen.padding_small)))
    }
}