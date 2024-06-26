package com.noah.viewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 *     implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1") 추가하기
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            val data = remember {
//                mutableStateOf("hello")
//            }
            val viewModel = viewModel<MainViewModel>()
            MyScreen(viewModel)
        }
    }
}

@Composable
fun MyScreen(viewModel: MainViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = viewModel.data.value, fontSize = 30.sp)
        Button(onClick = {
            viewModel.changeValue()
        }) {
            Text(text = "변경")
        }
    }
}

class MainViewModel : ViewModel() {
    private val _data = mutableStateOf("hello")
    val data = _data

    fun changeValue() {
        _data.value = "world"
    }
}
