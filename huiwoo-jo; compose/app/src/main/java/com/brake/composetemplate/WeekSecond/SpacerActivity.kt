package com.brake.composetemplate.WeekSecond

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brake.composetemplate.ui.theme.ComposeTemplateTheme

class SpacerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTemplateTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SpacerContainer()
                }
            }
        }
    }
}

@Composable
fun SpacerContainer() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp) // 전체 패딩 추가
    ) {
        Text("Item 1")
        Spacer(modifier = Modifier.height(16.dp))
        Text("Item 2")
        Spacer(modifier = Modifier.height(16.dp))
        Text("Item 3")
    }
}

@Preview(showBackground = true)
@Composable
fun SpacerPreview() {
    ComposeTemplateTheme {
        SpacerContainer()
    }
}