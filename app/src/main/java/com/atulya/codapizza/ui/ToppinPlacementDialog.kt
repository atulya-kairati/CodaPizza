package com.atulya.codapizza.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.atulya.codapizza.R
import com.atulya.codapizza.model.Topping
import com.atulya.codapizza.model.ToppingPlacement

@Composable
fun ToppingPlacementDialog(
    topping: Topping,
    onDismissRequest: () -> Unit,
    onSelectedPlacement: (placement: ToppingPlacement?) -> Unit
) {
    Dialog(onDismissRequest = onDismissRequest) {

        val toppingName = stringResource(topping.toppingName)

        Card {
            Column {
                Text(
                    text = stringResource(R.string.placement_prompt, toppingName),
                    style = MaterialTheme.typography.subtitle1,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(24.dp)
                )

                ToppingPlacement.values().forEach { toppingPlacement ->
                    ToppingPlacementOption(
                        placementName = toppingPlacement.label,
                        onClick = {
                            onDismissRequest()
                            onSelectedPlacement(toppingPlacement)
                        }
                    )
                }

                ToppingPlacementOption(
                    placementName = R.string.placement_none,
                    onClick = {
                        onSelectedPlacement(null)
                        onDismissRequest()
                    }
                )
            }
        }
    }
}
@Composable
fun ToppingPlacementOption(
    @StringRes placementName: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    TextButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = placementName),
            modifier = Modifier.padding(8.dp)
        )
    }
}