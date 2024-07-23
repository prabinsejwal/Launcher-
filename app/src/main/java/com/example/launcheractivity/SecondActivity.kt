package com.example.launcheractivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var editTextNumber1: EditText
    private lateinit var editTextNumber2: EditText
    private lateinit var textViewResult: TextView
    private lateinit var buttonAdd: Button
    private lateinit var buttonSubtract: Button
    private lateinit var buttonMultiply: Button
    private lateinit var buttonDivide: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        editTextNumber1 = findViewById(R.id.editTextNumber1)
        editTextNumber2 = findViewById(R.id.editTextNumber2)
        textViewResult = findViewById(R.id.textViewResult)
        buttonAdd = findViewById(R.id.buttonAdd)
        buttonSubtract = findViewById(R.id.buttonSubtract)
        buttonMultiply = findViewById(R.id.buttonMultiply)
        buttonDivide = findViewById(R.id.buttonDivide)

        buttonAdd.setOnClickListener { calculate('+') }
        buttonSubtract.setOnClickListener { calculate('-') }
        buttonMultiply.setOnClickListener { calculate('*') }
        buttonDivide.setOnClickListener { calculate('/') }
    }

    private fun calculate(operation: Char) {
        val number1 = editTextNumber1.text.toString().toDoubleOrNull()
        val number2 = editTextNumber2.text.toString().toDoubleOrNull()

        if (number1 != null && number2 != null) {
            val result = when (operation) {
                '+' -> number1 + number2
                '-' -> number1 - number2
                '*' -> number1 * number2
                '/' -> {
                    if (number2 != 0.0) {
                        number1 / number2
                    } else {
                        textViewResult.text = "Cannot divide by zero"
                        return
                    }
                }
                else -> 0.0
            }
            textViewResult.text = "Result: $result"
        } else {
            textViewResult.text = "Please enter valid numbers"
        }
    }
}
