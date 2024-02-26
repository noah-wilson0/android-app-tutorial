package com.noah.intentkt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.noah.intentkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  var mBinding:ActivityMainBinding?=null
    private  val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setContentView(R.layout.activity_main)

        mBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.btnA.setOnClickListener {
            val intent = Intent(this,SubActivity2::class.java)  //다음 화면으로 이동하기 위한 인텐트 객체 생성
            intent.putExtra("msg",binding.tvSendMsg.text.toString()) //넘길 객체의 (넘길 객체의 키값, 실제로 넘길 객체)
            startActivity(intent) // intent에 저장되어 있는 액티비티 쪽으로 이동한다.
            finish() //자기 자신 액티비티를 파괴한다. => 만약 앱이 초기 실행되어 로그인을 하면 로그인 화면은 필요없으므로 로그인 액티비티를 종료시킨다.

        }

    }
}