package com.littleguest.deeprootcalendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getSupportActionBar().hide();

        Button typhoon_btn=(Button)findViewById(R.id.typhoon_btn);
        Button aboutus_btn=(Button)findViewById(R.id.aboutus_btn);

        typhoon_btn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, WeatherActivity.class);
                startActivity(intent);

            }
        });

        aboutus_btn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, AboutusActivity.class);
                startActivity(intent);

            }
        });
    }
}
