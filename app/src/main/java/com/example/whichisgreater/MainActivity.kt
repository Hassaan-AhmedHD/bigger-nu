package com.example.whichisgreater

import android.content.ContentValues.TAG
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assignNumToBtns()


      //


        btnLeft.setOnClickListener{
            checkAnswer(true)
            assignNumToBtns()
    }



        btnRight.setOnClickListener{
            checkAnswer(false)
            assignNumToBtns()
        }


}


    private fun assignNumToBtns() {
        val r = Random
        val leftNum =  r.nextInt(10)
        var rightNum = r.nextInt(10)
        while (leftNum==rightNum){
               rightNum = r.nextInt(10)
        }
        btnLeft.text =  leftNum.toString()
        btnRight.text = rightNum.toString()

    }


    private fun checkAnswer(isLeftBtnSlected:Boolean) {
        val leftNum  = btnLeft.text.toString().toInt()
        val rightNum = btnRight.text.toString().toInt()
        val correctAns:Boolean = if (isLeftBtnSlected) leftNum>rightNum else leftNum<rightNum
        Log.d(TAG, "checkAnswer: $correctAns")
        if (correctAns){
            background.setBackgroundColor(Color.CYAN)
            Toast.makeText(this,"Correct",Toast.LENGTH_SHORT).show()
        }
        else{
            background.setBackgroundColor(Color.RED)
            Toast.makeText(this,"Wrong",Toast.LENGTH_SHORT).show()
        }
    }

}