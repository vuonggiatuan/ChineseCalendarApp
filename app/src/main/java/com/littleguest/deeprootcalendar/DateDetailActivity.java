package com.littleguest.deeprootcalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Calendar;

public class DateDetailActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent a = new Intent(DateDetailActivity.this, MainActivity.class);
                    startActivity(a);
                case R.id.navigation_dashboard:
                    Intent a2 = new Intent(DateDetailActivity.this, CalendarActivity.class);
                    startActivity(a2);
                case R.id.navigation_shop:
                    Intent a3 = new Intent(DateDetailActivity.this, ShopActivity.class);
                    startActivity(a3);
                case R.id.navigation_news:
                    Intent a4 = new Intent(DateDetailActivity.this, NewsActivity.class);
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
        setContentView(R.layout.activity_date_detail);
        Bundle extras = getIntent().getExtras();
        System.out.println(extras.toString());
        TextView yangliTxt=(TextView)findViewById(R.id.YangliTxt);
        TextView lunarTxt=(TextView)findViewById(R.id.LunarCalendarTxt);
        TextView solarLongTxt=(TextView)findViewById(R.id.SolarLongitudeTxt);
        TextView jieqiTxt=(TextView)findViewById(R.id.SeasonTxt);
        TextView canTxt=(TextView)findViewById(R.id.CanTxt);

        Integer year=extras.getInt("year");
        Integer month=extras.getInt("month")+1;
        Integer day=extras.getInt("day");
        Integer hour=12;
        Integer mm=0;

        Double SolarLongitude=LunarCalendar.showSolarLongitude(day,month,year,hour,mm);

        solarLongTxt.setText("地球位置："+Math.round(SolarLongitude)+"度");

        yangliTxt.setText("西曆\n"+ year.toString()+"/"+month.toString()+"/"+day.toString());
        lunarTxt.setText("農曆\n"+ LunarCalendar.getLunarYear(year,month,day,false)+"\n"+LunarCalendar.getLunarMonthDay(year,month,day));
        jieqiTxt.setText("節氣:"+LunarCalendar.getJieQi(SolarLongitude));
        canTxt.setText("天干:"+LunarCalendar.getCAN(year,month,day));


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_dashboard);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

}
