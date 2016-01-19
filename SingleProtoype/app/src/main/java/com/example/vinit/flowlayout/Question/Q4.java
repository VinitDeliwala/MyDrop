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

public class Q4 extends Fragment {
    EditText e4;
    Button b4;
    public static String q4;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_question4, container, false);
        e4 = (EditText) rootView.findViewById(R.id.q2);
        b4 = (Button) rootView.findViewById(R.id.button2);
        b4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                q4 = e4.getText().toString().trim();
                return false;
            }
        });

//
		return rootView;
	}
    public String getString4(String x){
        x = this.q4;
        return x;
    }
}
