package com.atulya.codapizza.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atulya.codapizza.R
import com.atulya.codapizza.model.Pizza
import com.atulya.codapizza.model.Topping
import java.text.NumberFormat


@Preview
@Composable
fun PizzaBuilderScreen(
    modifier: Modifier = Modifier
) {

    var pizza by rememberSaveable { mutableStateOf(Pizza()) }

    Column(
        modifier = modifier
    ) {
        ToppingList(
            pizza,
            onEditPizza = { updatedPizza ->
                // callback to edit the state 
                pizza = updatedPizza
            },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f, fill = true)
        )

        OrderButton(
            pizza,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}

@Composable
private fun ToppingList(
    pizza: Pizza,
    onEditPizza: (Pizza) -> Unit,
    modifier: Modifier = Modifier
) {
    Log.d("#> ToppingList", "${pizza.hashCode()}")

    var toppingToBePlaced by rememberSaveable { mutableStateOf<Topping?>(null) }

    toppingToBePlaced?.let { topping: Topping ->
        ToppingPlacementDialog(
            onDismissRequest = {
                toppingToBePlaced = null
            },
            topping = topping,
            onSelectedPlacement = { placement ->
                onEditPizza(
                    pizza.withTopping(
                        topping,
                        placement
                    )
                )
            }
        )
    }

    LazyColumn(modifier = modifier) {
        items(Topping.values()) { topping: Topping ->
            ToppingCell(
                topping = topping,
                placement = pizza.toppings[topping],
                onClickTopping = {

                    toppingToBePlaced = topping
//                    onEditPizza(
//                        // updating the pizza toppings
//                        // and passing a new updated pizza object
//                        pizza.withTopping(
//                            topping,
//                            if (isOnPizza) null else ToppingPlacement.All
//                        )
//                    )
                }
            )
        }
    }
}

@Composable
private fun OrderButton(
    pizza: Pizza,
    modifier: Modifier = Modifier,
) {
    Button(
        modifier = modifier,
        onClick = {},
    ) {


//        val currencyFormatter = NumberFormat.getCurrencyInstance()
        /**
         * [NumberFormat.getCurrencyInstance] is an expensive operation
         * so we can use [remember] to save it during recomposition
         * to reduce the overhead
         */

        val currencyFormatter = remember { NumberFormat.getCurrencyInstance() }
        val price = currencyFormatter.format(pizza.price)
        Text(
            text = stringResource(R.string.place_order_button, price)
                .toUpperCase(Locale.current)
        )
    }
}