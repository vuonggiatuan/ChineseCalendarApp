package com.littleguest.deeprootcalendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AboutusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        getSupportActionBar().hide();

        ImageButton detail_btn=(ImageButton)findViewById(R.id.detail_btn);

        detail_btn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(AboutusActivity.this, ArticleDetailActivity.class);
                startActivity(intent);

            }
        });
    }
}
