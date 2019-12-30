package com.vbridgelal.zmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import java.io.InputStream;

public class Licences extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_licences);

        WebView webview1= findViewById(R.id.webview1);
        webview1.loadUrl("file:///android_asset/gpl.html");


    }
}
