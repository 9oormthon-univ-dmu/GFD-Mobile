package com.brake.composetemplate.WeekSecond

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brake.composetemplate.ui.theme.ComposeTemplateTheme

class CheckboxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTemplateTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CheckboxContainer()
                }
            }
        }
    }
}

@Composable
fun CheckboxContainer() {
    var checked by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it },
            enabled = false,
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Blue,
                uncheckedColor = Color.Green,
                checkmarkColor = Color.Yellow,
                disabledCheckedColor = Color.Cyan,
                disabledIndeterminateColor = Color.Magenta
            )
        )

        Text(
            text = if (checked) "Checked" else "Unchecked",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CheckboxPreview() {
    ComposeTemplateTheme {
        CheckboxContainer()
    }
}