package com.example.tp2

import com.example.tp2.utils.AgeCalculator
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tp2.ui.theme.TP2Theme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Récupération du nom transmis depuis MainActivity
        val userName = intent.getStringExtra("USER_NAME") ?: "Utilisateur"
        val userYear = intent.getStringExtra("USER_YEAR")?.toIntOrNull() ?: 0
        val ageCalculator = AgeCalculator()
        val userAge = if (userYear > 0) ageCalculator.calculateAge(userYear) else -1

        setContent {
            TP2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SecondScreen(
                        name = userName,
                        age = if (userAge >= 0) userAge.toString() else "inconnue",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun SecondScreen(name: String, age: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Hello $name ! Vous avez $age ans",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview() {
    TP2Theme {
        SecondScreen(name = "Utilisateur", age = "23")
    }
}
