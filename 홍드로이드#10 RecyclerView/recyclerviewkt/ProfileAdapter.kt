package com.noah.recyclerviewkt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class ProfileAdapter (val profileList:ArrayList<Profiles>): RecyclerView.Adapter<ProfileAdapter.CustomViewHolder>() {

    //Activity에 oncreate와 비슷하다. 연결될 화면이 뭔가? => list_item을 만들어놧음
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter.CustomViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false) //context란 Activity가 담고있는 모든 정보 //여기서는 MainActivity가 가지고 있는 모든 정보이다.
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener {   //CustomViewHolder.itemView.setOnClickListener{}의 의미이다.
                val curPos :Int = adapterPosition //현재 클릭된 위치
                val profile:Profiles=profileList.get(curPos) //클릭된 위치를 객체로 가져오는 방법
                Toast.makeText(parent.context,"이름:${profile.name} \n나이: ${profile.age} \n직업: ${profile.job}",Toast.LENGTH_LONG).show()
            }

        }
    }
    override fun getItemCount(): Int {
        return profileList.size //11호출
    }

    override fun onBindViewHolder(holder: ProfileAdapter.CustomViewHolder, position: Int) {
        holder.gender.setImageResource(profileList.get(position).gender)
        holder.name.text = profileList.get(position).name
        holder.age.text=profileList.get(position).age.toString()
        holder.job.text=profileList.get(position).job
    }
    class CustomViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){ //내부클래스
        val gender=itemView.findViewById<ImageView>(R.id.iv_profile) //성별
        val name = itemView.findViewById<TextView>(R.id.tv_name)   //이름
        val age = itemView.findViewById<TextView>(R.id.tv_age)  //나이
        val job = itemView.findViewById<TextView>(R.id.tv_job)  //직업
    }


}

