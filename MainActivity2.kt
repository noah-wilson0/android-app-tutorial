package com.noah.viewbindingtest1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.noah.viewbindingtest1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding? =null
    private  val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        mBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.btnGetbutton.setOnClickListener{
            var resultText = binding.etId.text.toString()
            binding.tvResult.setText(resultText)
        }

    }
    override fun onDestroy(){
        mBinding=null
        super.onDestroy()

    }
}
