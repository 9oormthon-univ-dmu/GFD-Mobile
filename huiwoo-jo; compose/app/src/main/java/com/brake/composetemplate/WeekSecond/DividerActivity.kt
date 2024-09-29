package com.brake.composetemplate.WeekSecond

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brake.composetemplate.ui.theme.ComposeTemplateTheme

class DividerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTemplateTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DividerContainer()
                }
            }
        }
    }
}

@Composable
fun DividerContainer() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text("Item 1")
        Divider(
            color = Color.Cyan,
            thickness = 2.dp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Text("Item 2")
        Divider(
            color = Color.Gray,
            thickness = 2.dp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Text("Item 3")
    }
}

@Preview(showBackground = true)
@Composable
fun DividerPreview() {
    ComposeTemplateTheme {
        DividerContainer()
    }
}
