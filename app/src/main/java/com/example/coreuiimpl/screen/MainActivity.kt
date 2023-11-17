package com.example.coreuiimpl.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.coreuiimpl.navigation.FoodiezApp
import com.example.coreuiimpl.theme.MyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                FoodiezApp()
            }
        }
    }
}