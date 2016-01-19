package com.example.vinit.flowlayout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.wefika.flowlayout.FlowLayout;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        FlowLayout f1 = (FlowLayout) findViewById(R.id.f1);
        String[] name = {"NEWS","DESIGN","STYLE","TRAVEL","YOGA","RUNNING","MOBILE","HOME","DEMOGRAPHICS","COFFEE","BACON","PASTA","TRANSIT","EDM","REMIX","TESTO","CATS","DOGS","STYLE"};

        for (int i = 0; i < name.length; i++) {
            final Button myButton = new Button(this);
            myButton.setText(name[i] + "  o");
            myButton.setId(i);
//            myButton.setPadding(5,5,5,5);
//            myButton.setBackgroundResource(R.drawable.back);
             myButton.setBackgroundDrawable(setter(1));
            myButton.setTextColor((Color.parseColor("#FFFFFF")));
            FlowLayout.LayoutParams lp = new FlowLayout.LayoutParams(FlowLayout.LayoutParams.WRAP_CONTENT, FlowLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(10, 10, 10, 10);
            myButton.setLayoutParams(lp);

            f1.addView(myButton, lp);
            myButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myButton.setBackgroundDrawable(setter(2));
//                    myButton.setBackgroundResource(R.drawable.white);
                    myButton.setTextColor((Color.parseColor("#15B2AB")));

                }
            });
        }
    }
        public GradientDrawable setter(int i){
           final GradientDrawable gd = new GradientDrawable();
            if(i==1)
            gd.setColor(0x00000000);
            else
            gd.setColor((Color.parseColor("#FFFFFF")));// Changes this drawbale to use a single color instead of a gradient
            gd.setCornerRadius(20);
            gd.setStroke(1, 0xFFFFFFFF);
            return gd;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void list(View v){
        Intent i=new Intent(MainActivity.this,ListViewActivity.class);
        startActivity(i);
        finish();
    }
}
