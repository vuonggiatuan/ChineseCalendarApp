package com.littleguest.deeprootcalendar;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONException;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {

    private TextView mTextMessage;
    ListView newsList;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent a = new Intent(NewsActivity.this, MainActivity.class);
                    startActivity(a);
                case R.id.navigation_dashboard:
                    Intent a2 = new Intent(NewsActivity.this, CalendarActivity.class);
                    startActivity(a2);
                case R.id.navigation_shop:
                    Intent a3 = new Intent(NewsActivity.this, ShopActivity.class);
                    startActivity(a3);
                case R.id.navigation_news:
                    return true;
                case R.id.navigation_setting:
                    Intent a5 = new Intent(NewsActivity.this, SettingActivity.class);
                    startActivity(a5);
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        newsList= (ListView)findViewById(R.id.newsList);
        ArrayList<News> articleList = null;
        try {
            articleList = News.getRecipesFromFile("recipes.json", this);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        NewsAdapter adapter = new NewsAdapter(this, articleList);
        newsList.setAdapter( adapter);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_news);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
