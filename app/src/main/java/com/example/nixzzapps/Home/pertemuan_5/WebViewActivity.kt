package com.example.nixzzapps.Home.pertemuan_5

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.nixzzapps.R
import com.example.nixzzapps.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ==========================================
        // MULAI IMPROVISASI: TOOLBAR & VECTOR ASSET
        // ==========================================
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Nixzz Browser"
            setDisplayHomeAsUpEnabled(true)
            // Menggunakan Vector Asset ic_arrow_back yang sudah ada
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }
        // ==========================================
        // AKHIR IMPROVISASI TOOLBAR
        // ==========================================

        setupWebView()
    }

    private fun setupWebView() {
        // ==========================================
        // MULAI IMPROVISASI: WEBVIEW & PROGRESS BAR
        // ==========================================
        binding.webView.apply {
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true // Penting untuk web modern

            webViewClient = object : WebViewClient() {
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    binding.progressBar.visibility = View.VISIBLE
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    binding.progressBar.visibility = View.GONE
                }
            }

            webChromeClient = object : WebChromeClient() {
                override fun onProgressChanged(view: WebView?, newProgress: Int) {
                    binding.progressBar.progress = newProgress
                }
            }

            loadUrl("https://merdeka.com")
        }
        // ==========================================
        // AKHIR IMPROVISASI WEBVIEW
        // ==========================================
    }

    override fun onSupportNavigateUp(): Boolean {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack()
        } else {
            finish()
        }
        return true
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
