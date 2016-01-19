package com.example.vinit.flowlayout.FirstScreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.example.vinit.flowlayout.MainActivity;
import com.example.vinit.flowlayout.R;

public class terms extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);

        TextView t1 = (TextView) findViewById(R.id.termView);
        t1.setMovementMethod(new ScrollingMovementMethod());
        // Initilization

    }
    public void manyclickable(View v){
        Intent i=new Intent(terms.this,MainActivity.class);
        startActivity(i);
        finish();
    }

}
