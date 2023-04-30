package com.atulya.codapizza

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.atulya.codapizza.model.Topping
import com.atulya.codapizza.model.ToppingPlacement
import com.atulya.codapizza.ui.ToppingCell

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ToppingCell(
                topping = Topping.Pepperoni,
                toppingPlacement = ToppingPlacement.Left,
                onClickTopping = {}
            )
        }
    }
}