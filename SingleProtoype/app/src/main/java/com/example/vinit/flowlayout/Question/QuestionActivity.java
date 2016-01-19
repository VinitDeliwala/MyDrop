package com.example.vinit.flowlayout.Question;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.vinit.flowlayout.R;
import com.example.vinit.flowlayout.VerifyActivity;
import com.example.vinit.flowlayout.adapter.QTabsPagerAdapter;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class QuestionActivity extends FragmentActivity {

    private ViewPager vviewPager;
    private QTabsPagerAdapter mmAdapter;

    // JSON Node names


    // Tab titles

    String a1,a2,a3,a4;
    public static ArrayList<String> mylist = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        // Initilization
        vviewPager = (ViewPager) findViewById(R.id.pager);
        mmAdapter = new QTabsPagerAdapter(getSupportFragmentManager());

        vviewPager.setAdapter(mmAdapter);
        /**
         * on swiping the viewpager make respective tab selected
         * */

        vviewPager.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View arg0, MotionEvent arg1) {
                return true;
            }
        });
        vviewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
//                if (arg0 == MANDATORY_PAGE_LOCATION && positionOffset > 0.5) {
//                    viewPager.setCurrentItem(arg0, true);
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
//                switch (arg0) {
//                    case ViewPager.SCROLL_STATE_SETTLING: viewPager.setPagingEnabled(false); break;
//                    case ViewPager.SCROLL_STATE_IDLE: viewPager.setPagingEnabled(true); break;
//                }
            }
        });


    }

     public void q1(View v) {
         Q1 q11 = new Q1();
         a1 = q11.getString1(a1);
         mylist.add(a1);
        vviewPager.setCurrentItem(1, true);
//        Q1 q1 = new Q1();
//        String a = q1.getString1();
//        Toast.makeText(getApplicationContext(), a, Toast.LENGTH_SHORT).show();
    }
    public void q2(View v) {
        Q2 q12 = new Q2();
        a2 = q12.getString2(a2);
        mylist.add(a2);
        vviewPager.setCurrentItem(2, true);
//        Q1 q1 = new Q1();
//        String a = q1.getString1();
//        Toast.makeText(getApplicationContext(), a, Toast.LENGTH_SHORT).show();
    }
    public void q3(View v) {
        Q3 q13 = new Q3();
        a3 = q13.getString3(a3);
        mylist.add(a3);
        vviewPager.setCurrentItem(3, true);
//        Q1 q1 = new Q1();
//        String a = q1.getString1();
//        Toast.makeText(getApplicationContext(), a, Toast.LENGTH_SHORT).show();
    }
    public void q4(View v) {
        Q4 q14 = new Q4();
        a4 = q14.getString4(a4);
        mylist.add(a4);
        Intent newActivity = new Intent(QuestionActivity.this, Q5.class);
        newActivity.putExtra("mylist", mylist);
        startActivity(newActivity);
        finish();
//        vviewPager.setCurrentItem(4, true);
//        Q1 q1 = new Q1();
//        String a = q1.getString1();
//        Toast.makeText(getApplicationContext(), a, Toast.LENGTH_SHORT).show();
    }

    public void security(View v) {
//        Toast.makeText(getApplicationContext(), "Button ispressed!!! =)",
//                Toast.LENGTH_LONG).show();

        Q1 q1 = new Q1();
        a1 = q1.getString1(a1);
//        Toast.makeText(getApplicationContext(), a, Toast.LENGTH_SHORT).show();

        Q2 q2 = new Q2();
        a2 = q2.getString2(a2);

        Q3 q3 = new Q3();
        a3 = q3.getString3(a3);

        Q4 q4 = new Q4();
        a4 = q4.getString4(a4);
        Toast.makeText(getApplicationContext(), a4, Toast.LENGTH_SHORT).show();
//        Toast.makeText(getApplicationContext(), a2, Toast.LENGTH_SHORT).show();
//        Toast.makeText(getApplicationContext(), a3, Toast.LENGTH_SHORT).show();
//        Toast.makeText(getApplicationContext(), a4, Toast.LENGTH_SHORT).show();
//        insertToDatabase("Vinit","Manan");
        Intent newActivity = new Intent(QuestionActivity.this, VerifyActivity.class);
        startActivity(newActivity);
        finish();
    }
    public ArrayList getArray(ArrayList y){
        y = this.mylist;
        return y;
    }

    private void insertToDatabase(String name, String add){
        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {
                String paramUsername = params[0];
                String paramAddress = params[1];

                //InputStream is = null;

                String id = "1705151515054_1515126611618515";
                String q1 = a1;
                String q2 = a2;
                String q3 = a3;
                String q4 = a4;


                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("id", id));
                nameValuePairs.add(new BasicNameValuePair("q1", q1));
                nameValuePairs.add(new BasicNameValuePair("q2", q2));
                nameValuePairs.add(new BasicNameValuePair("q3", q3));
                nameValuePairs.add(new BasicNameValuePair("q4", q4));

                try {
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost(
                            "http://android1992.comyr.com/try.php");
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    HttpEntity entity = response.getEntity();

                    //is = entity.getContent();


                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }
                return "success";
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();

            }
        }
        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
        sendPostReqAsyncTask.execute(name, add);
    }



}