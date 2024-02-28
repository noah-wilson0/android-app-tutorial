package com.example.inflern_app_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.example.inflern_app_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mBinding:ActivityMainBinding?=null
    private val binding get() = mBinding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //1. 이미지가 클릭된것을 알아야한다.  //findViewById 사용
        val image1 = findViewById<ImageView>(R.id.bts_image_1)
        image1.setOnClickListener{
            Toast.makeText(this,"1번 클릭 완료",Toast.LENGTH_LONG).show()
            val intent = Intent(this,bts1Activity::class.java)
            startActivity(intent)
        }

        val image2=findViewById<ImageView>(R.id.bts_image_2)
        val image3=findViewById<ImageView>(R.id.bts_image_3)
        val image4=findViewById<ImageView>(R.id.bts_image_4)
        val image5=findViewById<ImageView>(R.id.bts_image_5)
        val image6=findViewById<ImageView>(R.id.bts_image_6)
        val image7=findViewById<ImageView>(R.id.bts_image_7)
        image2.setOnClickListener {
            val intent = Intent(this,bts2Activity::class.java)
            startActivity(intent)
        }
        image3.setOnClickListener {
            val intent = Intent(this,bts3Activity::class.java)
            startActivity(intent)
        }
        image4.setOnClickListener {
            val intent = Intent(this,bts4Activity::class.java)
            startActivity(intent)
        }
        image5.setOnClickListener {
            val intent = Intent(this,bts5Activity::class.java)
            startActivity(intent)
        }
        image6.setOnClickListener {
            val intent = Intent(this,bts6Activity::class.java)
            startActivity(intent)
        }
        image7.setOnClickListener {
            val intent = Intent(this,bts7Activity::class.java)
            startActivity(intent)
        }


    }
}