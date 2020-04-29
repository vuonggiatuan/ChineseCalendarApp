package com.littleguest.deeprootcalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class ShopActivity extends AppCompatActivity {

    private TextView mTextMessage;
    WebView myWebView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent a = new Intent(ShopActivity.this, MainActivity.class);
                    startActivity(a);
                case R.id.navigation_dashboard:
                    Intent a2 = new Intent(ShopActivity.this, CalendarActivity.class);
                    startActivity(a2);
                case R.id.navigation_shop:

                    return true;
                case R.id.navigation_news:
                    Intent a4 = new Intent(ShopActivity.this, NewsActivity.class);
                    startActivity(a4);
                case R.id.navigation_setting:
                    Intent a5 = new Intent(ShopActivity.this, SettingActivity.class);
                    startActivity(a5);
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        myWebView = (WebView) findViewById(R.id.ShopWeb);
        String url="<yoururl>";

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setGeolocationEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        //setContentView(myWebView);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.setWebChromeClient(new WebChromeClient());
        myWebView.loadUrl(url);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_shop);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            myWebView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

}
