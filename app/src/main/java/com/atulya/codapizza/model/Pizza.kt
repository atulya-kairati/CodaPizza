package com.atulya.codapizza.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pizza(
    val toppings: Map<Topping, ToppingPlacement> = emptyMap(),
    val size: PizzaSize = PizzaSize.Small
) : Parcelable {

    val price: Double
        get() = 9.99 + size.extraCost + toppings.asSequence().sumOf { topping ->
            val (_, toppingPlacement) = topping

            when (toppingPlacement){
                ToppingPlacement.Left, ToppingPlacement.Right -> 0.5
                ToppingPlacement.All -> 1.0
            }
        }

    fun withTopping(topping: Topping, placement: ToppingPlacement?): Pizza{
        return this.copy(
            toppings = if (placement == null){
                toppings - topping
            }
            else {
                toppings + (topping to placement)
            }
        )
    }

    fun withSize(size: PizzaSize): Pizza{
        return this.copy(
            size = size
        )
    }
}
