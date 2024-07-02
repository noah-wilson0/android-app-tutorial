package com.noah.composerecyclerviewtest

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                recyclerView()
            }

        }
    }

}
@Composable
fun recyclerView() {

    LazyColumn(){
        items(100) {
           recyclerViewItem(it)
        }
    }
}

@Composable
fun recyclerViewItem(item:Int) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .padding(10.dp)) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(width = 1.dp, color = Color.Black),
            contentAlignment = Alignment.Center
        ) {
            Text(text = item.toString())
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterEnd) {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.MailOutline,
                        tint = Color.Black,
                        contentDescription = "메일",
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 10.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Image(imageVector = Icons.Default.AccountCircle, contentDescription = "info")
            }
        }
    }
}

