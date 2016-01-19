package com.example.vinit.flowlayout.FirstScreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.vinit.flowlayout.R;

public class Login extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Initilization

    }
    public void login(View v){
        Intent i=new Intent(Login.this,terms.class);
        startActivity(i);
        finish();
    }


}
