package com.example.tp2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp2.ui.theme.TP2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TP2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding),
                        onValidate = { name, yearOfBirth ->
                            if (name.isNotEmpty() && yearOfBirth.isNotEmpty()) {
                                // Si les champs sont remplis, passe à MainActivity2
                                val intent = Intent(this, MainActivity2::class.java)
                                intent.putExtra("USER_NAME", name)
                                intent.putExtra("USER_YEAR", yearOfBirth)
                                startActivity(intent)
                            } else {
                                // Si un des champs est vide, affiche un message d'erreur
                                Toast.makeText(
                                    this,
                                    "Veuillez remplir tous les champs avant de valider.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier, onValidate: (String, String) -> Unit) {
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var yearOfBirth by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Afficher le titre du haut de la page
        Text(
            text = "Bienvenue",
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 50.dp)
        )

        // Affiche le texte saisi
        Text(
            text = " ${name.text}",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )

        // Champ de saisie pour le nom
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Votre prénom et nom") },
            modifier = Modifier
                .fillMaxWidth()
        )

        // Champ de saisie pour l'année de naissance
        OutlinedTextField(
            value = yearOfBirth,
            onValueChange = { yearOfBirth = it },
            label = { Text("Votre année de naissance") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        )

        // Bouton Valider
        Button(
            onClick = { onValidate(name.text, yearOfBirth.text) },
            modifier = Modifier.align(alignment = androidx.compose.ui.Alignment.CenterHorizontally)
        ) {
            Text("Valider")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    TP2Theme {
        MainScreen(onValidate = { _, _ -> })
    }
}
