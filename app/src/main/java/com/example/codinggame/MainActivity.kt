package com.example.codinggame

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        webSetup()
    }

    private fun webSetup() {
        if(we_view!=null){
            val webSettings=we_view.settings
            we_view.webViewClient= WebViewClient()
            we_view.loadUrl("https://cssgridgarden.com/")
            webSettings.javaScriptEnabled=true
            we_view.webViewClient=object :WebViewClient(){
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    myProgressBar.visibility= View.VISIBLE
                    super.onPageStarted(view, url, favicon)
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    myProgressBar.visibility=View.GONE
                    super.onPageFinished(view, url)
                }
            }

        }

        }

    override fun onBackPressed() {
        if(we_view.canGoBack()){
            we_view.goBack()
        }
        else {
            super.onBackPressed()
        }
    }

}