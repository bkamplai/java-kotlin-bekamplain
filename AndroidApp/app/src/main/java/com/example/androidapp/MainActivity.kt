package com.example.androidapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val calculateButton: Button get() = binding.calculateButton
    private val pointsReceivedEditText: EditText get() = binding.pointsReceivedEditText
    private val pointsReceived: Double
        get() = pointsReceivedEditText.text.toString().toDoubleOrNull() ?: 0.0
    private val pointsPossibleEditText: EditText get() = binding.pointsPossibleEditText
    private val pointsPossible: Double
        get() = pointsPossibleEditText.text.toString().toDoubleOrNull() ?: 0.0
    private val resultTextView: TextView get() = binding.resultTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calculateButton.setOnClickListener {
            onClickCalculate()
        }
    }

    private fun onClickCalculate() {
        val overallGrade = calculateOverallGrade(pointsReceived, pointsPossible)

        val finalGrade = if (overallGrade >= 90) {
            "A"
        } else if (overallGrade >= 80) {
            "B"
        } else if (overallGrade >= 70) {
            "C"
        } else if (overallGrade >= 60) {
            "D"
        } else {
            "F"
        }

        resultTextView.text = "Overall Grade: ${String.format("%.2f%%", overallGrade)} $finalGrade"
    }
}