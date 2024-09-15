package com.brake.composetemplate.WeekFirst

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brake.composetemplate.ui.theme.ComposeTemplateTheme

class BoxWithConstraintsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTemplateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BoxContainer()
                    BoxLargerContainer()
                    BoxSmallerContainer()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoxLargerContainer() {
    Row(modifier = Modifier.height(250.dp)) {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            if (this.minHeight > 220.dp) {
                Text(text = "Larger then 220dp")
            }
            if (this.minHeight < 220.dp) {
                Text(text = "Smaller then 220dp")
            }
            if (this.minHeight == 220.dp) {
                Text(text = "This is 220dp")
            }
            Text(
                modifier = Modifier.align(Alignment.BottomStart), text = "minHeight :${this.minHeight}"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoxBoundaryContainer() {
    Row(modifier = Modifier.height(220.dp)) {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            if (this.minHeight > 220.dp) {
                Text(text = "Larger then 220dp")
            } else if (this.minHeight < 220.dp) {
                Text(text = "Smaller then 220dp")
            } else{
                Text(text = "This is 220dp")
            }
            Text(
                modifier = Modifier.align(Alignment.BottomStart), text = "minHeight :${this.minHeight}"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoxSmallerContainer() {
    Row(modifier = Modifier.height(200.dp)) {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            Text(text =
                when{
                    this.minHeight > 220.dp -> "Larger then 220dp"
                    this.minHeight < 220.dp -> "Smaller then 220dp"
                    else -> "This is 220dp"
                }
            )
            Text(
                modifier = Modifier.align(Alignment.BottomStart), text = "minHeight :${this.minHeight}"
            )
        }
    }
}