package com.example.inflearn4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.inflearn4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var mbinding: ActivityMainBinding?=null
    val binding get() = mbinding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        mbinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sentenceList= mutableListOf<String>()
        sentenceList.add("삶이 있는 한 희망은 있다.")
        sentenceList.add("산다는것 그것은 치열한 전투이다.")
        sentenceList.add("하루에 3시간을 걸으면 7년 후에 지구를 한바퀴 돌 수 있다.")
        sentenceList.add("언제나 현재에 집중할수 있다면 행복할것이다.")
        sentenceList.add("진정으로 웃으려면 고통을 참아야하며 , 나아가 고통을 즐길 줄 알아야 해.")
        sentenceList.add("직업에서 행복을 찾아라. 아니면 행복이 무엇인지 절대 모를 것이다.")
        sentenceList.add("신은 용기있는자를 결코 버리지 않는다 .")
        sentenceList.add("피할수 없으면 즐겨라")
        sentenceList.add("단순하게 살아라. 현대인은 쓸데없는 절차와 일 때문에 얼마나 복잡한 삶을 살아가는가?")
        sentenceList.add("먼저 자신을 비웃어라. 다른 사람이 당신을 비웃기 전에")
        sentenceList.add(" 먼저핀꽃은 먼저진다 남보다 먼저 공을 세우려고 조급히 서둘것이 아니다")
//        sentenceList.random()
        binding.showAllSentenceBtn.setOnClickListener {

            val intent= Intent(this,SentenceActivity::class.java)
            startActivity(intent)

        }
        binding.goodword.text=sentenceList.random()

    }
}