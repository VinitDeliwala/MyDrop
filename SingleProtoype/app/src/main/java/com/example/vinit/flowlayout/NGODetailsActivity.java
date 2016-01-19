package com.example.vinit.flowlayout;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.vinit.flowlayout.Question.QuestionActivity;

/**
 * Created by Vinit on 11/22/2015.
 */
public class NGODetailsActivity extends Activity{

    final Context context = this;

    Boolean dia=true;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngodetails);

        TextView t1 = (TextView) findViewById(R.id.detailView);
        t1.setMovementMethod(new ScrollingMovementMethod());

        // Initilization
        Button connect =(Button) findViewById(R.id.connect);
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generate(R.string.dialog1);
            }
        });

    }
    public void generate(int displayText){
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog);

        // set the custom dialog components - text, image and button

        TextView text1 = (TextView) dialog.findViewById(R.id.text1);
        text1.setText("Connect to NPO");
        TextView text = (TextView) dialog.findViewById(R.id.text);
        text.setText(displayText);

        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                if(dia) {
                    generate(R.string.dialog2);
                    dia=false;
                }else{
                    Intent i=new Intent(NGODetailsActivity.this,QuestionActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        });
        dialog.show();
    }
    }
