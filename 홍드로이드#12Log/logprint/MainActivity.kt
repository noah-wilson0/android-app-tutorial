package com.noah.logprint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    var a: Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        a = 2
        if (a == 2) {
            Log.e("if문", "ENTER")
        } else if (a == 1) {
            Log.e("elseif문", "ENTER")
        }
//        Log.d("로그테스트", a.toString())  //d(로그설명,)
    }
}
