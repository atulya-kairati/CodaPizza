package com.atulya.codapizza.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.atulya.codapizza.model.Topping
import com.atulya.codapizza.model.ToppingPlacement

@Composable
fun ToppingCell(
    topping: Topping,
    toppingPlacement: ToppingPlacement?,
    onClickTopping: () -> Unit
) {
    Row {
        Checkbox(checked = true, onCheckedChange = {})
        Column {
            Text(text = stringResource(id = topping.toppingName), color = Color.Cyan)
            Text(text = "Combo Pizza")
        }
    }
}

@Preview
@Composable
private fun ToppingCellPreview() {
    ToppingCell(
        topping = Topping.Basil,
        toppingPlacement = ToppingPlacement.Left,
        onClickTopping = {}
    )
}