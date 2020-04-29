package com.littleguest.deeprootcalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent a = new Intent(SettingActivity.this, MainActivity.class);
                    startActivity(a);
                case R.id.navigation_dashboard:
                    Intent a2 = new Intent(SettingActivity.this, CalendarActivity.class);
                    startActivity(a2);
                case R.id.navigation_shop:
                    Intent a3 = new Intent(SettingActivity.this, ShopActivity.class);
                    startActivity(a3);
                case R.id.navigation_news:
                    Intent a4 = new Intent(SettingActivity.this, NewsActivity.class);
                    startActivity(a4);
                case R.id.navigation_setting:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_setting);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
