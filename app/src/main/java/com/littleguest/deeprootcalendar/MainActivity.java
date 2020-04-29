package com.littleguest.deeprootcalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent a = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(a);
                case R.id.navigation_dashboard:
                    Intent a2 = new Intent(MainActivity.this, CalendarActivity.class);
                    startActivity(a2);
                case R.id.navigation_shop:
                    Intent a3 = new Intent(MainActivity.this, ShopActivity.class);
                    startActivity(a3);
                case R.id.navigation_news:
                    Intent a4 = new Intent(MainActivity.this, NewsActivity.class);
                    startActivity(a4);
                case R.id.navigation_setting:
                    Intent a5 = new Intent(MainActivity.this, SettingActivity.class);
                    startActivity(a5);
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView yangliTxt=(TextView)findViewById(R.id.YangliTxt);
        TextView lunarTxt=(TextView)findViewById(R.id.LunarCalendarTxt);
        TextView solarLongTxt=(TextView)findViewById(R.id.SolarLongitudeTxt);
        TextView jieqiTxt=(TextView)findViewById(R.id.SeasonTxt);
        TextView canTxt=(TextView)findViewById(R.id.CanTxt);
        TextView chiTxt=(TextView)findViewById(R.id.ChiTxt);
        TextView huangdaoriTxt=(TextView)findViewById(R.id.huangdaoriTxt);
        TextView yiTxt=(TextView)findViewById(R.id.YiTxt);
        TextView jiTxt=(TextView)findViewById(R.id.JiTxt);

        Integer year=Integer.parseInt((String) DateFormat.format("yyyy",Calendar.getInstance().getTime()));
        Integer month=Integer.parseInt((String) DateFormat.format("MM",Calendar.getInstance().getTime()));
        Integer day=Integer.parseInt((String) DateFormat.format("dd",Calendar.getInstance().getTime()));
        Integer hour=Integer.parseInt((String) DateFormat.format("hh",Calendar.getInstance().getTime()));
        Integer mm=Integer.parseInt((String) DateFormat.format("mm",Calendar.getInstance().getTime()));
        Integer day_chi_num=LunarCalendar.getDayChiNum(year, month, day);
        Integer lunar_mon=LunarCalendar.getLunarMonth(year, month, day);
        String huangdaori=LunarCalendar.getHuangDaoRi(day_chi_num, lunar_mon);
        String xiaohuangdaori=LunarCalendar.getXiaoHuangDaoRi(day_chi_num, lunar_mon);
        String daycan=LunarCalendar.getDayCan(year, month, day);
        String daychi=LunarCalendar.getDayChi(year, month, day);
        String yi=LunarCalendar.getYi(day_chi_num, lunar_mon);
        String ji=LunarCalendar.getJi(day_chi_num, lunar_mon);

        Double SolarLongitude=LunarCalendar.showSolarLongitude(day,month,year,hour,mm);

        solarLongTxt.setText("地球位置："+Math.round(SolarLongitude)+"度");

        yangliTxt.setText("西曆\n"+ DateFormat.format("yyyy-MM-dd",Calendar.getInstance().getTime()));
        lunarTxt.setText("農曆\n"+ LunarCalendar.getLunarYear(year,month,day,false)+"\n"+LunarCalendar.getLunarMonthDay(year,month,day));
        jieqiTxt.setText("節氣:"+LunarCalendar.getJieQi(SolarLongitude));
        canTxt.setText("日天干:"+daycan);
        chiTxt.setText("日地支:"+daychi);
        yiTxt.setText("宜\n"+yi);
        jiTxt.setText("忌\n"+ji);
        huangdaoriTxt.setText(huangdaori+" "+xiaohuangdaori);

        Button compassBtn=(Button)findViewById(R.id.compass_btn);
        compassBtn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, CompassActivity.class);
                startActivity(a);

            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_home);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
