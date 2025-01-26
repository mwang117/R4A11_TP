package com.example.tp1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TEXT = "text_to_display"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Récupération les éléments du layout
        val inputText: EditText = findViewById(R.id.inputText)
        val validateButton: Button = findViewById(R.id.validateButton)
        val displayText: TextView = findViewById(R.id.displayText)

        validateButton.setOnClickListener {
            val text = inputText.text.toString()
            if (text.isNotEmpty()) {
                displayText.text = text
            } else {
                Toast.makeText(this, "Veuillez saisir du texte", Toast.LENGTH_SHORT).show()
            }
        }

        val buttonNext: Button = findViewById(R.id.buttonNext)
        buttonNext.setOnClickListener {
            val textToSend = inputText.text.toString()
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra(EXTRA_TEXT, textToSend)
            startActivity(intent)
        }

    }
}

