package com.atulya.codapizza.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atulya.codapizza.model.Topping
import com.atulya.codapizza.model.ToppingPlacement

@Composable
fun ToppingCell(
    topping: Topping,
    placement: ToppingPlacement?,
    modifier: Modifier = Modifier,
    onClickTopping: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,

        /**
         * modifier order matters
         */
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClickTopping() }
            .background(Color.Yellow.copy(alpha = 0.2f))
            .padding(
                vertical = 4.dp,
                horizontal = 16.dp
            )
    ) {
        Checkbox(
            checked = placement != null,
            onCheckedChange = { onClickTopping() }
        )
        Column {
            Text(
                text = stringResource(id = topping.toppingName),
                color = Color.DarkGray,
                style = MaterialTheme.typography.body1
            )
            if (placement != null) {
                Text(
                    text = stringResource(id = placement.label),
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Preview
@Composable
private fun ToppingCellPreviewOnLeftHalf() {
    ToppingCell(
        topping = Topping.Basil,
        placement = ToppingPlacement.Left,
        onClickTopping = {}
    )
}

@Preview
@Composable
private fun ToppingCellPreviewNotOnPizza() {
    ToppingCell(
        topping = Topping.Basil,
        placement = null,
        onClickTopping = {}
    )
}