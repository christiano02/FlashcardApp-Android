package com.christiano.flashcardsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.christiano.flashcardsapp.ui.theme.FlashcardsAppTheme
import com.christiano.flashcardsapp.ui.flashcard.FlashcardAppScreen

class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent {
            FlashcardsAppTheme {
                FlashcardAppScreen()
            }
        }
    }
}