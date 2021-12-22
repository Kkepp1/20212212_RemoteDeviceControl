package com.example.a11_9_2021_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class webactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webactivity);
        String url = "https://www.google.com/";
        WebView web = (WebView) findViewById(R.id.webview);
        web.loadUrl(url);
    }
}