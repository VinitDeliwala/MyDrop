package com.example.vinit.flowlayout.FirstScreen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.vinit.flowlayout.R;

public class register extends Fragment {

    EditText e1;
    Button b1;
    public static String q1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_register, container, false);
        e1 = (EditText) rootView.findViewById(R.id.editText);
        b1 = (Button) rootView.findViewById(R.id.button2);
        b1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                q1 = e1.getText().toString().trim();
                return false;
            }
        });


		return rootView;
	}
    public String getString2(String x){
        x = this.q1;
        return x;
    }
}
