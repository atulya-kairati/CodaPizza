package com.atulya.codapizza.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.atulya.codapizza.R
import com.atulya.codapizza.model.Pizza
import com.atulya.codapizza.model.PizzaSize
import com.atulya.codapizza.model.Topping
import com.atulya.codapizza.model.ToppingPlacement.*

@Composable
fun PizzaHeroImage(
    pizza: Pizza,
    modifier: Modifier = Modifier,
) {

    Box(
        modifier = modifier
            .aspectRatio(1f)
    ) {
        // box stacks its children on top of each other

        Image(
            painter = painterResource(R.drawable.pizza_crust),
            contentDescription = stringResource(R.string.pizza_preview),
            modifier = Modifier.fillMaxSize()
        )


        pizza.toppings.forEach { (topping, placement) ->
            Image(
                painter = painterResource(topping.overlayPizzaImage),
                contentDescription = null,
                modifier = Modifier
                    .focusable(false) // screen reader will ignore the image
                    .aspectRatio(
                        when (placement) {
                            All -> 1f
                            Left, Right -> 0.5f
                        }
                    )
                    // this aligns the image in Box
                    .align(when(placement){
                        Left -> Alignment.CenterStart
                        All -> Alignment.Center
                        Right -> Alignment.CenterEnd
                    }),
                contentScale = ContentScale.Crop,

                // This aligns the picture in Image
                alignment = when(placement){
                    Left -> Alignment.TopStart
                    All -> Alignment.Center
                    Right -> Alignment.TopEnd
                }
            )
        }
    }
}

@Preview
@Composable
private fun PizzaHeroImagePreview() {
    PizzaHeroImage(
        pizza = Pizza(
            toppings = mapOf(
                Topping.Pepperoni to Left,
                Topping.Mushroom to Right,
                Topping.Basil to All,
            ),
            size = PizzaSize.Small,
        )
    )
}