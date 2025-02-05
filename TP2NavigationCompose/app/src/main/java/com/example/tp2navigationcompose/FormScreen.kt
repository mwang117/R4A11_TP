package com.example.tp2navigationcompose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.text.input.KeyboardType


@Composable
fun FormScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Page du formulaire",
            style = MaterialTheme.typography.titleMedium
        )

        TextField(
            value = name,
            onValueChange = { newText -> name = newText },
            label = { Text("Entrez votre nom") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        )

        TextField(
            value = age,
            onValueChange = { newText -> age = newText },
            label = { Text("Entrez votre âge") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { navController.navigate("display/$name/$age")
                }) {
            Text(text = "Valider")
        }

        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Retour")
        }
    }
}
