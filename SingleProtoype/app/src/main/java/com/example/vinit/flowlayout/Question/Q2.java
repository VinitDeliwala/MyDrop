package com.example.vinit.flowlayout.Question;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.vinit.flowlayout.R;


public class Q2 extends Fragment {
    EditText e2;
    Button b2;
    public static String q2;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_question2, container, false);
        e2 = (EditText) rootView.findViewById(R.id.q2);
        b2 = (Button) rootView.findViewById(R.id.button2);
//        b2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                q2 = e2.getText().toString().trim();
//            }
//        });
        b2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                q2 = e2.getText().toString().trim();
                return false;
            }
        });


        return rootView;
	}
    public String getString2(String x){
        x = this.q2;
        return x;
    }
}
