package com.example.codelabnavigation.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.codelabnavigation.R
import com.example.codelabnavigation.data.OrderUiState


/**
 * This composable expects [orderUiState] that represents the order state, [onCancelButtonClicked]
 * lambda that triggers canceling the order and passes the final order to [onSendButtonClicked]
 * lambda
 */
@Composable
fun SummaryScreen(
    orderUiState: OrderUiState,
    onCancelButtonClicked: () -> Unit,
    onSendButtonClicked: (String, String) -> Unit,
    modifier: Modifier = Modifier
) {


    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            Text(text = "QUANTITY")
            Text(text = "${orderUiState.quantity}")
            Divider(thickness = dimensionResource(id = R.dimen.thickness_divider))
            Text(text = "FLAVOR")
            Text(text = orderUiState.flavor)
            Divider(thickness = dimensionResource(id = R.dimen.thickness_divider))
            Text(text = "PICK UP DATE")
            Text(text = "${orderUiState.pickupOptions}")
            Divider(thickness = dimensionResource(id = R.dimen.thickness_divider))
            Text(text = "TOTAL")
            Text(text = orderUiState.price)
            }
        Row(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { val summary = "Quantity: ${orderUiState.quantity} | Flavor: ${orderUiState.flavor} | PickupDate: ${orderUiState.date} | Total: ${orderUiState.price}"
                        onSendButtonClicked("order #123456J", summary) }
                ) {
                    Text(stringResource(R.string.send))
                }
                OutlinedButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onCancelButtonClicked
                ) {
                    Text(stringResource(R.string.cancel))
                }
            }
        }
        }

    }

