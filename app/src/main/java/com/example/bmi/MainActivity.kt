package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val width = findViewById<EditText>(R.id.tnWidth)
        val height = findViewById<EditText>(R.id.tnHeight)
        val bnCalculate = findViewById<Button>(R.id.bnCalculate)

        val result = findViewById<TextView>(R.id.tvResult)
        val description = findViewById<TextView>(R.id.tvDescription)
        val norma = findViewById<TextView>(R.id.tvNorma)

        bnCalculate.setOnClickListener{
            if (width.text.isNullOrEmpty() || height.text.isNullOrEmpty()) {
                Toast.makeText(this, "empty", Toast.LENGTH_LONG).show()
            }
            else {
                val BMI: Double = calculateBMI(width.text.toString(), height.text.toString())


                if (BMI < 18.5) {
                    result.text = String.format("%.2f", BMI)
                    description.text = "Underweight"
                    norma.text = "Normal range is 18.5 – 24.9"
                } else if (BMI >= 18.5 && BMI < 24.9) {
                    result.text = String.format("%.2f", BMI)
                    description.text = "Normal"
                    norma.text = "Normal range is 18.5 – 24.9"
                }

                if (BMI >= 24.9) {
                    result.text = String.format("%.2f", BMI)
                    description.text = "Obese"
                    norma.text = "Normal range is 18.5 – 24.9"
                }
            }
        }


    }

    fun calculateBMI(width: String, height: String): Double {
        val widthKg = width.toDouble()
        val heightM: Double = height.toDouble() / 100

        return widthKg / (heightM * heightM)

    }
}