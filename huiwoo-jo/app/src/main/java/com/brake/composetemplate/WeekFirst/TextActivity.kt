package com.brake.composetemplate.WeekFirst

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brake.composetemplate.R
import com.brake.composetemplate.ui.theme.ComposeTemplateTheme

class TextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTemplateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    textContainer(this@TextActivity, "Surface")
                }
            }
        }
    }
}

@Composable
fun textContainer(context: Context, name: String) {

    val title = "BreakCompose"
    val scrollState = rememberScrollState()  // 스크롤 적용
    val offset = Offset(5.0f, 10.0f) // 그림자 설정

    // Column 설정
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(10.dp)  // Column의 Layout을 10dp 간격으로 띄우기
    ) {
        // Text 선언
        Text(
            text = "Hello World!",
            modifier = Modifier.background(Color.Green)
        )

        // Resource 사용 : stringResource, colorResource
        Text(
            text = stringResource(id = R.string.hello_world),
            color = Color.Blue,
            modifier = Modifier
                .background(colorResource(id = R.color.purple_200))
        )

        // 가로 영역을 최대로
        Text(
            text = "Hello, $title",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green)
        )

        // style 적용 - TextAlign
        Text(
            text = "Hello, $title",
            style = TextStyle(
                textAlign = TextAlign.Justify
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green)
        )

        // style 적용 - TextAlign
        Text(
            text = "Hello, $title",
            style = TextStyle(
                textAlign = TextAlign.End
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green)
        )

        // font Weight, size 적용
        // font Size는 dp는 불가능 / sp 혹은 em으로 설정
        Text(
            text = "Hello, $title",
            style = TextStyle(
                textAlign = TextAlign.Justify
            ),
            fontWeight = FontWeight.W400, // 굵기
            fontSize = 20.sp, // 크기
            fontFamily = FontFamily.Monospace, // 폰트 적용
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green)
        )

        // 커스텀 폰트 (TTF)
        Text(
            text = "Hello, $title",
            style = TextStyle(
                textAlign = TextAlign.Justify,
                fontFamily = FontFamily(
                    Font(R.font.pretendard_regular)
                )
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green)
        )

        // style - textDecoration : line 만들기
        Text(
            text = "Hello, $title",
            style = TextStyle(
                textAlign = TextAlign.Justify,
                textDecoration = TextDecoration.LineThrough
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green)
        )

        // style - textDecoration : line 여러개 만들기
        Text(
            text = "Hello, $title",
            style = androidx.compose.ui.text.TextStyle(
                textAlign = TextAlign.Justify,
                textDecoration = TextDecoration.combine(
                    listOf(
                        TextDecoration.LineThrough, TextDecoration.Underline
                    )
                )
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green)
        )

        // style - 줄 높이 설정 : lineHeight
        Text(
            text = stringResource(id = R.string.hello_world), style = TextStyle(
                textAlign = TextAlign.Justify, lineHeight = 40.sp
            ), modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green)
        )

        // 라인 수 제한
        Text(
            text = stringResource(id = R.string.hello_world),
            maxLines = 2,
            style = TextStyle(
                textAlign = TextAlign.Justify
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green)
        )

        // 라인 수 제한 : 잘림 표현
        Text(
            text = stringResource(id = R.string.hello_world),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis, // Visible은 기본
            style = TextStyle(
                textAlign = TextAlign.Justify
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green)
        )

        // style - 그림자
        Text(
            text = "Hello world!",
            style = TextStyle(
                fontSize = 24.sp,
                shadow = Shadow(
                    color = Color.Blue,
                    offset = offset,
                    blurRadius = 3f
                )
            )
        )

        // 직접 하나의 문장을 다양한 형태로 만들기
        Text(text = buildAnnotatedString {
            append("preview와 surface의 변수를 각자 지정하면 미리보기에는 ")

            withStyle(
                style = SpanStyle(
                    Color.Red,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W400
                )
            ) {
                append("$name")
            }

            append(" 가 출력됨")
        })

        // 클릭 사용
        ClickableText(
            text = AnnotatedString("This text is cliable"),
            onClick = {
            Toast.makeText(context, "Text 클릭됨!!", Toast.LENGTH_SHORT).show() // in Activity
        })

        // 선택 사용
        SelectionContainer {
            Text("This text is selectable")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TextPreview() {
    ComposeTemplateTheme {
        textContainer(context = LocalContext.current, "Preview")
    }
}