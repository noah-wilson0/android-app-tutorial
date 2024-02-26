package com.noah.imageviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.noah.imageviewkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mBinding:ActivityMainBinding?=null
    private  val binding get() = mBinding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding=ActivityMainBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_main)
        setContentView(binding.root)
        binding.btnToast.setOnClickListener {
            binding.ivProfile.setImageResource(R.drawable.roboot) //이미지 뷰에 새로운 이미지 등록
            Toast.makeText(this@MainActivity,"버튼이 클릭되었습니다.",Toast.LENGTH_SHORT).show()



        }

    }
}