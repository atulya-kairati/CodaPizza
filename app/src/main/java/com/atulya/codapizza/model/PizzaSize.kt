package com.atulya.codapizza.model

import androidx.annotation.StringRes
import com.atulya.codapizza.R

enum class PizzaSize(
    @StringRes val size: Int,
    val extraCost: Float
) {
    Small(R.string.pizza_size_small, 0f),
    Medium(R.string.pizza_size_medium, 5f),
    Big(R.string.pizza_size_big, 10f)
}