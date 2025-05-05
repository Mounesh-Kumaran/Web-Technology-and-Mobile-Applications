package com.example.textstyler

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var myText: TextView
    private lateinit var styleButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myText = findViewById(R.id.myText)
        styleButton = findViewById(R.id.styleButton)

        styleButton.setOnClickListener {
            myText.setTextColor(Color.parseColor("#E91E63")) // Vibrant pink
            myText.setTypeface(null, Typeface.BOLD_ITALIC)
            myText.textSize = 24F
            Toast.makeText(this, "Style Changed!", Toast.LENGTH_SHORT).show()
        }
    }
}
