package com.littleguest.deeprootcalendar;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Garfield on 2018/5/15.
 */

public class News {
    public String id;
    public String title;
    public String description;
    public String imageUrl;

    public static ArrayList<News> getRecipesFromFile(String filename, Context context) throws JSONException {
        ArrayList<News> courseList = new ArrayList<>();
        String result=returnJson("<yoururl>");
        Log.e("Info",result);
        JSONObject json = new JSONObject(result);
        JSONArray jArray = json.getJSONArray("course");
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        for(int i=0; i<jArray.length(); i++){
            News a=new News();
            JSONObject json_data = jArray.getJSONObject(i);

            //Log.i("info", json_data.getString("name").toString());
            a.id=json_data.getString("id").toString();
            a.title=json_data.getString("name").toString();
            a.imageUrl="https://cdn3.iconfinder.com/data/icons/seo-concept-modern/512/Seo_Teach_services_flat_icon_tool_web-512.png";
            a.description=json_data.getString("desc").toString();;
            courseList.add(a);
        }
        return courseList;
    }

    public static String loadJsonFromAsset(String filename, Context context) {
        String json = null;
        return json;
    }

    public static News getCourseFromId(String id) throws JSONException {
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        News course=new News();
        String result=returnJson("<yoururl>"+id);
        JSONObject json_data = new JSONObject(result);
        course.id=json_data.getString("id").toString();
        course.title=json_data.getString("name").toString();
        course.imageUrl="https://cdn3.iconfinder.com/data/icons/seo-concept-modern/512/Seo_Teach_services_flat_icon_tool_web-512.png";
        course.description=json_data.getString("desc").toString();;
        return course;
    }

    public static ArrayList<News> getRecipesFromUrl(String url){
        ArrayList<News> newsList = new ArrayList<>();
        String url_select = "<yoururl>";
        return newsList;
    }

    public static String returnJson(String request_url){
        BufferedReader reader=null;
        StringBuilder sb = new StringBuilder();
        String data ="";
        try {
            URL url = new URL(request_url);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write( data );
            wr.flush();

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = null;
            // Read Server Response
            while((line = reader.readLine()) != null)
            {
                // Append server response in string
                sb.append(line + "\n");
            }

        }catch(MalformedURLException error) {
            //Handles an incorrectly entered URL
        }
        catch(SocketTimeoutException error) {
            //Handles URL access timeout.
        }
        catch (IOException error) {
            //Handles input and output errors
        }
        return sb.toString();
    }
}
