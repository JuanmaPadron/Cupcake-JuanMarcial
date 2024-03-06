package com.example.codelabnavigation.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.codelabnavigation.R

/**
 * Composable that displays the list of items as [RadioButton] options,
 * [onSelectionChanged] lambda that notifies the parent composable when a new value is selected,
 * [onCancelButtonClicked] lambda that cancels the order when user clicks cancel and
 * [onNextButtonClicked] lambda that triggers the navigation to next screen
 */
@Composable
fun SelectOptionScreen(
    modifier: Modifier = Modifier,
    radioButtonList: List<String>,
    currentPrice: String,
    onSelectionChanged: (String) -> Unit = {},
    onCancelButtonClicked: () -> Unit = {},
    onNavigateNext: () -> Unit = {}
) {
    var selectedOption by remember { mutableStateOf(radioButtonList[0]) }
    var showError by remember { mutableStateOf(true) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))) {
            radioButtonList.forEach { eachOption ->
                Row(
                    modifier = Modifier.selectable(
                        selected = (selectedOption == eachOption),
                        onClick = {
                            if (selectedOption.isBlank()) {
                                showError = true
                            } else {
                                selectedOption = eachOption
                                onSelectionChanged(selectedOption)
                                showError = false
                            }
                        }
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (selectedOption == eachOption),
                        onClick = {
                            if (selectedOption.isBlank()) {
                                showError = true
                            } else {
                                selectedOption = eachOption
                                onSelectionChanged(selectedOption)
                                showError = false
                            }
                        }
                    )
                    Text(text = eachOption)
                }
            }
            Divider(
                thickness = dimensionResource(R.dimen.thickness_divider),
                modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium))
            )
            if (showError) {
                Text(
                    text = "Debe seleccionar una opción primero",
                    modifier = Modifier.padding(
                        top = dimensionResource(R.dimen.padding_small),
                        bottom = dimensionResource(R.dimen.padding_medium)
                    ),
                    color = MaterialTheme.colorScheme.error,
                    fontWeight = FontWeight.Bold
                )
            } else {
                Text(
                    text = "Has seleccionado: $selectedOption",
                    modifier = Modifier.padding(
                        top = dimensionResource(R.dimen.padding_small),
                        bottom = dimensionResource(R.dimen.padding_medium)
                    ),
                )
                Text(
                    text = "Precio: $currentPrice",
                    modifier = Modifier.padding(
                        top = dimensionResource(R.dimen.padding_small),
                        bottom = dimensionResource(R.dimen.padding_medium)
                    )
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
            verticalAlignment = Alignment.Bottom
        ) {
            OutlinedButton(
                modifier = Modifier.weight(1f),
                onClick = onCancelButtonClicked
            ) {
                Text(stringResource(R.string.cancel))
            }
            Button(
                modifier = Modifier.weight(1f),
                // the button is enabled when the user makes a selection
                enabled = showError.not(),
                onClick = onNavigateNext
            ) {
                Text(stringResource(R.string.next))
            }
        }
    }

}

