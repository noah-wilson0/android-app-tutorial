package com.noah.snackbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.noah.snackbar.ui.theme.SnackBarTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}
@ExperimentalComposeUiApi
@Composable
fun MainScreen() {
    // 코틀린의 구조분해 사용가능
    // val (text, setValue) = remember { mutableStateOf("") }
    val textValue = remember { mutableStateOf("") }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope= rememberCoroutineScope()
    val keyboardController=LocalSoftwareKeyboardController.current
    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }

    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = textValue.value,
                // 코틀린의 구조분해 사용가능
                // onValueChange = setValue,
                onValueChange = { textValue.value = it }
            )

            Button(onClick = {
                keyboardController?.hide()
                scope.launch {
                    snackbarHostState.showSnackbar("hello${textValue.value}")
                }
            }) {
                Text(text = "클릭!!")
            }
        }
    }
}

