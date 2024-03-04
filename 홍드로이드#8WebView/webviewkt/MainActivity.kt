package com.noah.webviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import com.noah.webviewkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mBinding:ActivityMainBinding?=null
    private  val binding get() = mBinding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        mBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.webView.settings.javaScriptEnabled=true
        //웹뷰에서 새창이 뜨지않도록 방지하는 구문
        binding.webView.webViewClient = WebViewClient()
        binding.webView.webChromeClient = WebChromeClient()

        binding.webView.loadUrl("https://www.naver.com")


    }

    override fun onBackPressed() { //back버튼 기본 로직
        if(binding.webView.canGoBack()){
            binding.webView.goBack()  //웹 버튼 뒤로가기
        }
        else {
            super.onBackPressed()  //본래의 백버튼 기능 수행(앱 종료)ㄹ
        }
    }
}