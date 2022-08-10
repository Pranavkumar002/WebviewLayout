package com.pranavkumar.webviewlayout

import android.app.Activity
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {
    lateinit var Webview: WebView
    lateinit var WebViewClient:WebViewClient
    lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        Webview= findViewById(R.id.Webview)
        WebViewClient= WebViewClient()
        Webview.loadUrl("https://www.google.com")
        Webview.setWebViewClient(object : WebViewClient(){

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return super.shouldOverrideUrlLoading(view, request)
            }



            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressBar.visibility=View.GONE
            }
        })
        Webview.settings.javaScriptEnabled = true


    }
    override fun onBackPressed() {
        if (Webview.canGoBack()) {
            Webview.goBack()
        } else {
            super.onBackPressed()
        }
    }

}