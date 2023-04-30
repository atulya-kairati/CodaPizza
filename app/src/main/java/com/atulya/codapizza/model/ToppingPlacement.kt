package com.atulya.codapizza.model

import androidx.annotation.StringRes
import com.atulya.codapizza.R

enum class ToppingPlacement(@StringRes val label: Int) {
    // @StringRes makes sure that only string resource values can be passed to the constructor
    Left(R.string.placement_left),
    Right(R.string.placement_right),
    All(R.string.placement_all)
}