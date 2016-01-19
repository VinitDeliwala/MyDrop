package com.example.vinit.flowlayout;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EmailActivity extends Activity {
    EditText e1,e2,e3,e4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
         e1 = (EditText) findViewById(R.id.editto);
         e2 = (EditText) findViewById(R.id.editcc);
         e3 = (EditText) findViewById(R.id.editsub);
         e4 = (EditText) findViewById(R.id.content);
        TextView startBtn = (TextView) findViewById(R.id.sendtext);
        startBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String s1= e1.getText().toString();
                String s2= e2.getText().toString();
                String s3= e3.getText().toString();
                String s4= e4.getText().toString();
                String animals = "dog@nyu.edu,cat@nyu.edu";

                String[] animalsArray = s2.split(",");

                sendEmail(s1,animalsArray,s3,s4);

            }
        });
    }


    private void sendEmail(String s1,String[] s2,String s3,String s4) {

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:" + s1));
        emailIntent.putExtra(Intent.EXTRA_CC, s2);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, s3);
        emailIntent.putExtra(Intent.EXTRA_TEXT, s4);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send email using..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(EmailActivity.this, "No email clients installed.", Toast.LENGTH_SHORT).show();
        }

    }
}