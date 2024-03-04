package com.example.navigationkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.example.navigationkt.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private var mBinding:ActivityMainBinding?=null
    private val binding get() = mBinding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNavi.setOnClickListener {
            binding.layoutDrawer.openDrawer(GravityCompat.START)  //Start=left ,  End=right
        }
        binding.naviView.setNavigationItemSelectedListener(this) //네비게이션 메뉴 아이템 클릭 속성 부여
        //즉 위 구문이 setOnClickListener역할을 하므로 아래 onNavigationItemSelected이 작동함

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean { //네비게이션 아이템 클릭시 실행
        when (item.itemId){
            R.id.access->Toast.makeText(applicationContext,"접근성",Toast.LENGTH_SHORT).show()
            R.id.email->Toast.makeText(applicationContext,"이메일",Toast.LENGTH_SHORT).show()
            R.id.message->Toast.makeText(applicationContext,"메시지",Toast.LENGTH_SHORT).show()
        }
        binding.layoutDrawer.closeDrawers() //네비게이션 뷰 닫기
        return false
    }

    override fun onBackPressed() {
        if(binding.layoutDrawer.isDrawerOpen(GravityCompat.START)){
            binding.layoutDrawer.closeDrawers()  //백 버튼을 누르면 네이게이션 바가 꺼지게 분기 처리하기
        }
        else{
            super.onBackPressed()
        }

    }
}