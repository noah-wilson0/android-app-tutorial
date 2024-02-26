package com.noah.intentkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.noah.intentkt.databinding.ActivitySub2Binding

class SubActivity2 : AppCompatActivity() {
    private var mBinding:ActivitySub2Binding?=null
    private val binding get() = mBinding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_sub2)
        mBinding =ActivitySub2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra("msg")){
            binding.tvGetMsg.text= intent.getStringExtra("msg") //문자열로 보냇으니 문자열로 받아야된다.
            // 서브 액티비티에 존재하는 택스트 뷰에다가 Hello World가 넘겨져 옴
        }


    }
}