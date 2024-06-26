package com.noah.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isFavorite by rememberSaveable {
                mutableStateOf(false)
            }

            ImageCard(
                isFavorite = isFavorite,
                modifier =  Modifier.fillMaxWidth(0.4f)
                .padding(16.dp)
            ){ favorite->
                isFavorite =favorite
        }

        }
    }
}

@Composable
fun ImageCard(
    isFavorite:Boolean,
    modifier: Modifier
    ,onnTabFavorite:(Boolean)->Unit,){

    Card (modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ){

        Box(modifier = Modifier.height(200.dp)){
            Image(painter = painterResource(id = R.drawable.image), contentDescription = "영화 이미지")

            Box(modifier=Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopEnd){
                IconButton(onClick={
                    onnTabFavorite(!isFavorite)
                }){
                    Icon(imageVector =  if(isFavorite)Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        tint = Color.White,contentDescription = "좋아요")
                }
            }

        }
    }
}

