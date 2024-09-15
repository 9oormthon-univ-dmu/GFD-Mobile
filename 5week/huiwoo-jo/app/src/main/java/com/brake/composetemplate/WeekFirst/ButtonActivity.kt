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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
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

class ButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTemplateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ButtonContainer(this@ButtonActivity)
                }
            }
        }
    }
}

@Composable
fun ButtonContainer(context: Context) {
    // 버튼 테두리 그라이데션 색상을 적용 값
    val buttonBorderGradient = Brush.horizontalGradient(listOf(Color.Green, Color.Red))

    // 상태 감지
    val interactionSource = remember {
        MutableInteractionSource()
    }

    // 버튼 상태 저장
    // interactionSource 변수를 지정 -> 버튼 상태를 저장
    val isPressed by interactionSource.collectIsPressedAsState()

    val pressState = if (isPressed) {
        "버튼 누르는 중"
    } else {
        "버튼 누르기 stop"
    }

    val interactionSourceForSecondBtn = remember { MutableInteractionSource() }
    val isPressedForSecondBtn by interactionSourceForSecondBtn.collectIsPressedAsState()

    val pressedBtnRadiusWithAnim: Dp by animateDpAsState(
        if (isPressedForSecondBtn) 0.dp else 20.dp, label = "",
    )

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        // button - 채워진 버튼
        Button(onClick = {}) {
            Text(text= "Filled")
        }

        // button - 색조 버튼
        FilledTonalButton(onClick = { }) {
            Text("Tonal")
        }

        // button - 윤곽선 버튼
        OutlinedButton(onClick = { }) {
            Text("Outlined")
        }

        // button - 돌출 버튼
        Button(
            onClick = { },
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 10.dp
            )
        ) {
            Text(text = "Button elevation")
        }

        // button - 텍스트 버튼
        TextButton(
            onClick = { }
        ) {
            Text("Text Button")
        }

        // 버튼 비활성화
        Button(
            enabled = false,
            onClick = { },
        ) {
            Text(text = "Button enabled false")
        }

        // PressedElevation 적용
        // 누르면 그림자가 사라지면서 눌렀다는 변화가 발생
        Button(
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 10.dp, // 그림자 주기
                pressedElevation = 0.dp, // 눌렀을때 그림자 없애기
            ),
            onClick = { },
        ) {
            Text(text = "Button PressedElevation")
        }

        // shape 적용
        Button(
            shape = RoundedCornerShape(10.dp),
            onClick = { },
        ) {
            Text(text = "Button shape")
        }

        // border 적용
        Button(
            border = BorderStroke(4.dp, Color.Red), // 굵기 , 색상 (그라데이션 색상 적용)
            onClick = { },
        ) {
            Text(text = "Button border")
        }

        // 버튼 색 적용
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                disabledContainerColor = Color.Red // 버튼이 비활성시 색 지정
            ),
            onClick = { },
        ) {
            Text(text = "Button color")
        }

        // content padding 적용
        Button(
            // horizontal, vertical 개별 지정 가능
            contentPadding = PaddingValues(horizontal = 40.dp),
            onClick = { },
        ) {
            Text(text = "Button padding")
        }

        // button 인터렉션
        Button(
            // 위에서 선언한 interactionSource 적용
            // 버튼이 눌려지면 그 상태를 해당 변수에 저장
            interactionSource = interactionSource,
            onClick = { },
        ) {
            Text(text = "Button 인터렉션")
        }

        Text(text = "$pressState")

        // 버튼 커스텀 그림자
        // ex) 색이 있는 그라데이션, 그림자를 넣을 위치 크기 등등
        Button(
            enabled = true,
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(4.dp, buttonBorderGradient),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                disabledContainerColor = Color.LightGray,
            ),
            interactionSource = interactionSourceForSecondBtn,
            modifier = Modifier.drawColoredShadow(
                // Extensions에 fun Modifier.drawColoredShadow 적용
                color = Color.Blue,
                alpha = 0.5f, // 투명도
                borderRadius = 10.dp,
                shadowRadius = pressedBtnRadiusWithAnim,
                offsetY = 0.dp,
                offsetX = 0.dp,
            ),
            onClick = { },
        ) {
            Text(text = "커스텀 그라데이션", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    ComposeTemplateTheme {
        ButtonContainer(LocalContext.current)
    }
}