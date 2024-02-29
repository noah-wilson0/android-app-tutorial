package com.example.listviewkt

import android.content.Context
import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class UserAdapter (val context:Context,val UserList:ArrayList<User>): BaseAdapter() {
    override fun getCount(): Int {  //ListView에 요소가 5개면 getCount는 5가 호출된다.
        return UserList.size
    }

    override fun getItem(position: Int): Any {
        return  UserList[position]  //위치들 만큼 getItem한다
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View= LayoutInflater.from(context).inflate(R.layout.list_item_user,null) //view를 붙일때 LayoutInflater을 쓴다.
        val profile = view.findViewById<ImageView>(R.id.id_profile)
        val name = view.findViewById<TextView>(R.id.tv_name)
        val age = view.findViewById<TextView>(R.id.tv_age)
        val greet = view.findViewById<TextView>(R.id.tv_greet)

        val user=UserList[position] //position은 listview의 0번지 부터 센다.

        profile.setImageResource(user.profile)
        name.text=user.name
        age.text=user.age
        greet.text=user.greet

        return view
    }
}