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

public class Q3 extends Fragment {
    EditText e3;
    Button b3;
    public static String q3;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_question3, container, false);
        e3 = (EditText) rootView.findViewById(R.id.q2);
        b3 = (Button) rootView.findViewById(R.id.button2);
//        b3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                q3 = e3.getText().toString().trim();
//            }
//        });
        b3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                q3 = e3.getText().toString().trim();
                return false;
            }
        });

//
		return rootView;
	}
    public String getString3(String x){
        x = this.q3;
        return x;
    }
}
