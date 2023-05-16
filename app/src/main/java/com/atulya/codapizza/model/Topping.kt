package com.atulya.codapizza.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.atulya.codapizza.R

enum class Topping(
    @StringRes val toppingName: Int,
    @DrawableRes val overlayPizzaImage: Int
) {
    Basil(
        toppingName = R.string.topping_basil,
        overlayPizzaImage = R.drawable.topping_basil
    ),
    Mushroom(
        toppingName = R.string.topping_mushroom,
        overlayPizzaImage = R.drawable.topping_mushroom
    ),
    Olive(
        toppingName = R.string.topping_olive,
        overlayPizzaImage = R.drawable.topping_olive
    ),
    Peppers(
        toppingName = R.string.topping_peppers,
        overlayPizzaImage = R.drawable.topping_peppers
    ),
    Pepperoni(
        toppingName = R.string.topping_pepperoni,
        overlayPizzaImage = R.drawable.topping_pepperoni
    ),
    Pineapple(
        toppingName = R.string.topping_pineapple,
        overlayPizzaImage = R.drawable.topping_pineapple
    )
}