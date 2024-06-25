package com.noah.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

/**
 *     implementation("androidx.navigation:navigation-compose:2.7.7") 추가해야됨
 *
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController=rememberNavController()
           NavHost(navController = navController,
               startDestination = "first"){
               composable("first"){
                   FirstScreen(navController)
               }
               composable("second"){
                   SecondScreen(navController)
               }
               composable("third/{value}"){backStackEntry->
                   ThirdScreen(navController = navController,
                       value = backStackEntry.arguments?.getString("value")?:"")
               }
           }
        }
    }
}

@Composable
fun FirstScreen(navController: NavController){
    Column (
        Modifier.fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally
    ){
        val (value,setValue)= remember {
            mutableStateOf("")

        }
        Text(text = "첫 화면")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {navController.navigate("second")}) {
            Text(text = "두 번쨰")
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextField(value = value, onValueChange = setValue)
        Button(onClick = {
            if(value.isNotEmpty()){
                navController.navigate("third/$value")
            }
        }) {
            Text(text = "세 번쨰")
        }

    }
}

@Composable
fun SecondScreen(navController: NavHostController) {
    Column (
        Modifier.fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally
    ){
        val (value,setValue)= remember {
            mutableStateOf("")

        }
        Text(text = "두 번째 화면")
//                Button(onClick = {navController.navigateUp()}) {
                Button(onClick = {navController.popBackStack()}) {
                    Text(text = "뒤로가기")
                }

    }
}

@Composable
fun ThirdScreen(navController: NavController,value:String){
    Column (
        Modifier.fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally
    ){
        Text(text = "세 번째 화면")
        Spacer(modifier = Modifier.height(16.dp))
        Text(value)
        Button(onClick = {
            navController.navigateUp()
        }) {
            Text(text = "뒤로 가기")
        }

    }
}