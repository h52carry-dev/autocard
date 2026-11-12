package net.classcard.autocard

import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.content.Intent
import android.provider.Settings
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.graphics.Color

class MainActivity : Activity() {
    private lateinit var webView: WebView
    private lateinit var status: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = Color.rgb(17, 19, 29)
        window.navigationBarColor = Color.rgb(17, 19, 29)

        val page = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.rgb(17, 19, 29))
            setPadding(16, 14, 16, 0)
        }
        val title = TextView(this).apply {
            text = "AutoCard Mobile"
            textSize = 23f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER_VERTICAL
        }
        status = TextView(this).apply {
            text = "클래스카드에 로그인한 뒤 학습할 세트를 선택하세요."
            textSize = 13f
            setTextColor(Color.LTGRAY)
            setPadding(0, 8, 0, 12)
        }
        val controls = LinearLayout(this).apply { orientation = LinearLayout.HORIZONTAL }
        val home = Button(this).apply {
            text = "클래스카드"
            setOnClickListener { webView.loadUrl("https://www.classcard.net/Main") }
        }
        val accessibility = Button(this).apply {
            text = "접근성 설정"
            setOnClickListener { startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)) }
        }
        controls.addView(home, LinearLayout.LayoutParams(0, -2, 1f))
        controls.addView(accessibility, LinearLayout.LayoutParams(0, -2, 1f))
        webView = WebView(this).apply {
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            settings.loadsImagesAutomatically = true
            settings.userAgentString = settings.userAgentString
            webChromeClient = WebChromeClient()
            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    status.text = "페이지: ${url ?: ""}"
                }
            }
        }
        page.addView(title)
        page.addView(status)
        page.addView(controls)
        page.addView(webView, LinearLayout.LayoutParams(-1, 0, 1f))
        setContentView(page)
        if (savedInstanceState == null) webView.loadUrl("https://www.classcard.net/Main")
        else webView.restoreState(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        webView.saveState(outState)
        super.onSaveInstanceState(outState)
    }

    @Deprecated("Deprecated in Android")
    override fun onBackPressed() {
        if (::webView.isInitialized && webView.canGoBack()) webView.goBack()
        else super.onBackPressed()
    }

    override fun onDestroy() {
        if (::webView.isInitialized) webView.destroy()
        super.onDestroy()
    }
}
