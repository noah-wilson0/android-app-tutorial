package com.noah.fragmentkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.noah.fragmentkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mBinding:ActivityMainBinding?=null
    private val binding get() = mBinding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        mBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setFrag(0)
        binding.fragment1.setOnClickListener {
            setFrag(0)
        }
        binding.fragment2.setOnClickListener {
            setFrag(1)
        }
        binding.fragment3.setOnClickListener {
            setFrag(2)
        }

    }

    private fun setFrag(fragNum:Int) {
        val ft=supportFragmentManager.beginTransaction()
        when(fragNum)
        {
            0 ->{
                ft.replace(R.id.main_frame,Fragment1()).commit()
            }
            1->{
                ft.replace(R.id.main_frame,Fragment2()).commit()
            }
            2->{
                ft.replace(R.id.main_frame,Fragment3()).commit()
            }
        }
    }
}