package com.littleguest.deeprootcalendar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;

public class CalendarActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent a = new Intent(CalendarActivity.this, MainActivity.class);
                    startActivity(a);
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_shop:
                    Intent a3 = new Intent(CalendarActivity.this, ShopActivity.class);
                    startActivity(a3);
                case R.id.navigation_news:
                    Intent a4 = new Intent(CalendarActivity.this, NewsActivity.class);
                    startActivity(a4);
                case R.id.navigation_setting:
                    Intent a5 = new Intent(CalendarActivity.this, SettingActivity.class);
                    startActivity(a5);
            }
            return false;
        }
    };

    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_dashboard);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        datePicker=(DatePicker)findViewById(R.id.datePicker);
        Button searchBtn=(Button)findViewById(R.id.search_btn);
        searchBtn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                Intent a = new Intent(CalendarActivity.this, DateDetailActivity.class);
                a.putExtra("year", datePicker.getYear());
                a.putExtra("month", datePicker.getMonth());
                a.putExtra("day", datePicker.getDayOfMonth());
                startActivity(a);

            }
        });

    }

}
