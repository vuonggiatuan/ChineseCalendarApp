package com.littleguest.deeprootcalendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class PreloadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preload);

        //to remove the action bar (title bar)
        getSupportActionBar().hide();

        ImageButton chineseBtn=(ImageButton)findViewById(R.id.chinese_btn);
        chineseBtn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                Intent a = new Intent(PreloadActivity.this, Calendar2Activity.class);
                startActivity(a);

            }
        });
    }
}
