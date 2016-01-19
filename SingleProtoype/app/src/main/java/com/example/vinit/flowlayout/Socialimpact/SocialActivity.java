package com.example.vinit.flowlayout.Socialimpact;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import com.example.vinit.flowlayout.R;
import com.example.vinit.flowlayout.adapter.SocialPagerAdapter;
import com.example.vinit.flowlayout.helper.SQLiteHandler;
import com.example.vinit.flowlayout.helper.SessionManager;

//import java.lang.reflect.Method;

public class SocialActivity extends FragmentActivity {

    private ViewPager viewPager;
    private SocialPagerAdapter mAdapter;

    // Tab titles


    private static final String TAG = SocialActivity.class.getSimpleName();
    private ProgressDialog pDialog;
    private SessionManager session;
    private SQLiteHandler db;
    private String id = "vinit";
    private String number = "1111";
    String email1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        // Initilization
        viewPager = (ViewPager) findViewById(R.id.pager);
        mAdapter = new SocialPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(mAdapter);
        /**
         * on swiping the viewpager make respective tab selected
         * */

        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        session = new SessionManager(getApplicationContext());

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });

    }
    public void sis(View v) {
        Toast.makeText(getApplicationContext(), "Application2",
                Toast.LENGTH_LONG).show();
//        Q1 q1 = new Q1();
//        String a = q1.getString1();
//        Toast.makeText(getApplicationContext(), a, Toast.LENGTH_SHORT).show();
    }


}
