package com.noah.textviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {  //앱이 최초 실행됬을 때 수행
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)   //xml 화면 뷰를 연결한다.

        var tv1 : TextView

        tv1=findViewById(R.id.tv_title)
        tv1.setText("Hello World..!");

    }
}