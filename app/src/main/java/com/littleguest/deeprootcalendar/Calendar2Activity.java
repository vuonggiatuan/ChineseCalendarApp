package com.littleguest.deeprootcalendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Calendar2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar2);

        getSupportActionBar().hide();

        TextView ngayTxt=(TextView)findViewById(R.id.ngayTxt);
        TextView thuTxt=(TextView)findViewById(R.id.thuTxt);
        TextView thangTxt=(TextView)findViewById(R.id.thangTxt);
        TextView jieqiTxt=(TextView)findViewById(R.id.jieqiTxt);
        TextView sunTxt=(TextView)findViewById(R.id.sunTxt);
        TextView adviceTxt=(TextView)findViewById(R.id.adviceTxt);
        TextView healthTxt=(TextView)findViewById(R.id.healthTxt);
        TextView farmTxt=(TextView)findViewById(R.id.farmTxt);
        ImageButton scrollBtn=(ImageButton)findViewById(R.id.scrollBtn);

        ngayTxt.setText("23");
        thuTxt.setText("禮\n拜\n六");
        thangTxt.setText("六\n\n月");
        jieqiTxt.setText("夏至");
        sunTxt.setText("日出:\t5:03AM\n日落:\t6:42PM");
        adviceTxt.setText("天氣乾燥，注意某某蟲出沒");
        healthTxt.setText("保健強身");
        farmTxt.setText("今日農事");

        scrollBtn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(Calendar2Activity.this, MenuActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

            }
        });
    }
}
