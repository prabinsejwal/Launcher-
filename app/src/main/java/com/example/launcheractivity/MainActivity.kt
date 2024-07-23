package com.example.launcheractivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnSendMsgToNextActivity: Button = findViewById(R.id.calculator)
        val btnSendMsgToThirdActivity: Button = findViewById(R.id.weather)

        btnSendMsgToNextActivity.setOnClickListener {
            val message: String = "Super App"
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("key", message)
            startActivity(intent)
        }

        btnSendMsgToThirdActivity.setOnClickListener {
            val message: String = "Super App"
            val intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra("key", message)
            startActivity(intent)
        }
    }
}