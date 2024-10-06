package com.brake.composetemplate.WeekThird

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brake.composetemplate.ui.theme.ComposeTemplateTheme

class SnackbarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTemplateTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SnackbarContainer()
                }
            }
        }
    }
}

@Composable
fun SnackbarContainer() {
    var showSnackbar by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Button(onClick = {
            showSnackbar = true
        }) {
            Text("Show Snackbar")
        }

        if (showSnackbar) {
            Snackbar(
                action = {
                    TextButton(onClick = {
                        showSnackbar = false
                    }) {
                        Text("Undo")
                    }
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "This is a snackbar message")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SnackbarPreview() {
    ComposeTemplateTheme {
        SnackbarContainer()
    }
}
