package com.littleguest.deeprootcalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ArticleDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        getSupportActionBar().hide();
    }
}
