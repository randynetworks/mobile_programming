package com.krisantus.p9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WResmi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wresmi);

        WebView kemenkes = (WebView) findViewById(R.id.website_resmi);

        kemenkes.getSettings().setLoadsImagesAutomatically(true);
        kemenkes.getSettings().setJavaScriptEnabled(true);
        kemenkes.getSettings().setDomStorageEnabled(true);
        kemenkes.getSettings().setSupportZoom(true);
        kemenkes.getSettings().setBuiltInZoomControls(true);
        kemenkes.getSettings().setDisplayZoomControls(false);
        kemenkes.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        kemenkes.setWebViewClient(new WebViewClient());

        kemenkes.loadUrl("https://kemkes.go.id/");
    }
}