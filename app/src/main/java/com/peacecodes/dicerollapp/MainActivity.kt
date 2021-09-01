package com.peacecodes.dicerollapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonRoll: Button = findViewById(R.id.btnRoll)
        buttonRoll.setOnClickListener { diceRoll() }
    }

    private fun diceRoll() {
        val dice = Dice(6)
        val rollFirstDice = dice.roll()
        val rollSecondDice = dice.roll()

        val DiceImage_1: ImageView = findViewById(R.id.DiceImage_1)
        val DiceImage_2: ImageView = findViewById(R.id.DiceImage_2)

        val firstDrawableResource = when (rollFirstDice) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val secondDrawableResource = when (rollSecondDice) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        DiceImage_1.setImageResource(firstDrawableResource)
        DiceImage_1.contentDescription = DiceImage_1.toString()
        DiceImage_2.setImageResource(secondDrawableResource)
        DiceImage_2.contentDescription = DiceImage_2.toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}