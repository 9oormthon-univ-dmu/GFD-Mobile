package com.brake.composetemplate.WeekSecond

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brake.composetemplate.R
import com.brake.composetemplate.ui.theme.ComposeTemplateTheme

class IconActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTemplateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    IconContainer()
                }
            }
        }
    }
}

@Composable
fun IconContainer() {
    Icon(
        modifier = Modifier.size(24.dp),
        imageVector = ImageVector.vectorResource(id = R.drawable.ic_android_black_24dp),
        contentDescription = "지우기",
    )

    Icon(
        modifier = Modifier.size(24.dp),
        imageVector = Icons.Default.Add,
        contentDescription = "Add"
    )
}

@Preview(showBackground = true)
@Composable
fun IconPreview() {
    ComposeTemplateTheme {
        IconContainer()
    }
}