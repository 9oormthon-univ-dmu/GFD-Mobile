package com.brake.composetemplate.WeekFirst

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.brake.composetemplate.ui.theme.ComposeTemplateTheme

class BoxActivity : ComponentActivity() {
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
                }
            }
        }
    }
}

@Composable
fun BoxContainer() {
    Row(modifier = Modifier.padding(all = 12.dp).height(200.dp)) {
        Box (modifier = Modifier.fillMaxHeight().weight(1f)){
            Text(text = "First")
            Text(text = "Second")
            Text(text = "Third")
        }

        Box(modifier = Modifier.fillMaxHeight().weight(1f),
            contentAlignment = Alignment.BottomEnd) {
            Text(text = "First")
            Text(text = "Second")
            Text(text = "Third")
        }

        Box (modifier = Modifier.fillMaxHeight().weight(1f)){
            // Top
            Text(modifier = Modifier.align(Alignment.TopStart), text = "1")
            Text(modifier = Modifier.align(Alignment.TopCenter), text = "2")
            Text(modifier = Modifier.align(Alignment.TopEnd), text = "3")
            // Center
            Text(modifier = Modifier.align(Alignment.CenterStart), text = "4")
            Text(modifier = Modifier.align(Alignment.Center), text = "5")
            Text(modifier = Modifier.align(Alignment.CenterEnd), text = "6")
            // Bottom
            Text(modifier = Modifier.align(Alignment.BottomStart), text = "7")
            Text(modifier = Modifier.align(Alignment.BottomCenter), text = "8")
            Text(modifier = Modifier.align(Alignment.BottomEnd), text = "9")
        }

        Box(modifier = Modifier.fillMaxHeight().weight(1f),
            contentAlignment = Alignment.BottomEnd) {
            Text(modifier = Modifier.align(Alignment.TopStart), text = "First")
            Text(modifier = Modifier.align(Alignment.Center), text = "Second")
            Text(modifier = Modifier.align(Alignment.BottomEnd), text = "Third")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoxPreview() {
    ComposeTemplateTheme {
        BoxContainer()
    }
}