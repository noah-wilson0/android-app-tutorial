package com.example.listviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.listviewkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mBinding:ActivityMainBinding?=null
    private  val binding get() = mBinding!!

    var UserList = arrayListOf<User>(
        User(R.drawable.android,"홍드로이드","100",",안녕하세요"),
        User(R.drawable.android,"코틀린","11",",HelloWrold"),
        User(R.drawable.android,"안드로이드","50","반가워"),
        User(R.drawable.android,"웹뷰","40",",해야지"),
    )
    override fun onCreate(savedInstanceState: Bundle?) { //액티비티의 실행 시작시점
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        mBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //listView 연습
//        val item= arrayListOf("사과","배","키위","홍드")
//        binding.listView.adapter = ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,item)

        val Adapter=UserAdapter(this,UserList)
        binding.listView.adapter = Adapter

        binding.listView.onItemClickListener=AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectItem = parent.getItemAtPosition(position) as User  //as User했기때문에 user에 있는 친구들이 검색된다.
            Toast.makeText(this,selectItem.name,Toast.LENGTH_SHORT).show()

        }


    }
}