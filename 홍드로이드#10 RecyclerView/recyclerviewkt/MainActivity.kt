package com.noah.recyclerviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.noah.recyclerviewkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mBinding:ActivityMainBinding?=null
    private  val binding get() = mBinding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        mBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val profileList= arrayListOf(
            Profiles(R.drawable.man,"홍드로이드",27,"안드로이드 개발자"),
            Profiles(R.drawable.girl,"힝드로이드",21,"ios 개발자"),
            Profiles(R.drawable.man,"항드로이드",22,"flutter 개발자"),
            Profiles(R.drawable.girl,"후드로이드",23,"유니티 개발자"),
            Profiles(R.drawable.man,"허드로이드",24,"리액트 개발자"),
            Profiles(R.drawable.man,"하드로이드",25,"리액트 네이티브 개발자"),
            Profiles(R.drawable.girl,"혀드로이드",26,"java 개발자"),
            Profiles(R.drawable.girl,"햐드로이드",28,"백엔드 개발자"),
            Profiles(R.drawable.man,"후드로이드",29,"서버 개발자"),
            Profiles(R.drawable.man,"휴드로이드",30,"임베디드 개발자"),
            Profiles(R.drawable.girl,"효드로이드",31,"리액트 웹 개발자"),

        )
        //this는 Activity나 컴포넌트가 가지고 있는 모든정보로 여기서는 MainActivity가 가지고있는 모든 정보이다.
        binding.rvProfile.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.rvProfile.setHasFixedSize(true) //RecyclerView의 성능 개선 방안

        binding.rvProfile.adapter = ProfileAdapter(profileList)



    }
}