package com.noah.composestatedeep


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 *     implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1") 추가하기
 *
 *     state가 변경되면 화면이 다시 그려진다.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyScreen()
        }
    }
}

@Composable
fun MyScreen(viewModel: MainViewModel= viewModel()) {
    val text1:MutableState<String> = remember {
        mutableStateOf("Hello World")
    }
    var text2 by remember {
        mutableStateOf("Hello World")
    }
    val (text:String,setText:(String)->Unit)= remember {
        mutableStateOf("Hello World")
    }
    val test3 = viewModel.liveData.observeAsState("Hello World")
    Column() {
        Text("Hello World")
        Button(onClick = {
            text1.value="변경"
            text2="변경"
            println(text2)
            setText("변경")
            viewModel.data.value="변경" //TextField(value = viewModel.data.value, onValueChange = setText)을 쓰거나 fun changeValue()사용하기
            //viewModel.changeValue()
        }) {
            Text(text = "클릭")
        }
        TextField(value = text, onValueChange = setText)
    }
}

class MainViewModel : ViewModel() {
    private val _data = mutableStateOf("hello")
    val data = _data

    private val _liveData = MutableLiveData<String>()
    val liveData:LiveData<String> =_liveData

    fun changeValue() {
        _data.value = "world"
    }
}
