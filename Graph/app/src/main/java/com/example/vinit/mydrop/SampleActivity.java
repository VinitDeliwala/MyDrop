package com.example.vinit.mydrop;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class SampleActivity extends AppCompatActivity {
    private Cursor cursor;
    //Context context;

    MyDBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        TextView t1,t2,t3,t4,t5,t6;
        t1=(TextView) findViewById(R.id.textView);
        t2=(TextView) findViewById(R.id.textView2);
        t3=(TextView) findViewById(R.id.textView3);
        t4=(TextView) findViewById(R.id.textView4);
        t5=(TextView) findViewById(R.id.textView5);
        t6=(TextView) findViewById(R.id.textView6);
        dbHandler = new MyDBHandler(this, null, null, 2);


        Cursor cursor = dbHandler.fetchFavMovies();
        String countryCode =
                cursor.getString(cursor.getColumnIndexOrThrow("nname"));
        String countryCode1 =
                cursor.getString(cursor.getColumnIndexOrThrow("nlike"));
        String countryCode2 =
                cursor.getString(cursor.getColumnIndexOrThrow("ncomment"));
        String countryCode3 =
                cursor.getString(cursor.getColumnIndexOrThrow("nshare"));
        String countryCode4 =
                cursor.getString(cursor.getColumnIndexOrThrow("nevents"));
        String countryCode5 =
                cursor.getString(cursor.getColumnIndexOrThrow("nalbums"));
        t1.setText(countryCode);
        t2.setText(countryCode1);
        t3.setText(countryCode2);
        t4.setText(countryCode3);
        t5.setText(countryCode4);
        t6.setText(countryCode5);

    }
}
