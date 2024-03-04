package com.example.sharedkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mBinding:ActivityMainBinding?=null
    private val binding get() = mBinding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)  //해당 액티비티가 처음 실행될때 한번 수행되는곳
//        setContentView(R.layout.activity_main)
        mBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO: 저장된 데이터 로드
        loadData()//edit text 저장되어 있던 값을 setText




    }

    private fun loadData() {
        val pref=getSharedPreferences("pref",0)
        binding.etHello.setText(pref.getString("name","")) //name으로 저장했으니 name으로 불러온다
    }                               //(저장한 데이터의 키값, 해당 키에 값이 없을경우반활할 값)

    override fun onDestroy() { //액티비티가 종료되는 시점이 다가올때 호출됨.
        super.onDestroy()
        saveData() //edit text 값을 저장

    }

    private fun saveData() {
        val pref=getSharedPreferences("pref",0) //앱 내부 폴더에 pref라는 이름으로 저장
        val edit=pref.edit() //수정모드
        edit.putString("name",binding.etHello.text.toString())//(키값,실제 담을 값) et_hello의 text값을 name이란 이름으로 edit에 담는다
        edit.apply() //값을 저장 완료
    }
}