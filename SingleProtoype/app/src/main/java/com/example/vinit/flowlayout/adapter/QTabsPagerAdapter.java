package com.example.vinit.flowlayout.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.Toast;

import com.example.vinit.flowlayout.Question.Q1;
import com.example.vinit.flowlayout.Question.Q2;
import com.example.vinit.flowlayout.Question.Q3;
import com.example.vinit.flowlayout.Question.Q4;
import com.example.vinit.flowlayout.Question.Q5;

public class QTabsPagerAdapter extends FragmentPagerAdapter {

	public QTabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
			case 0:return new Q1();
			case 1:return new Q2();
			case 2:return new Q3();
			case 3:return new Q4();
//         	case 4:return new Q5();
     		}
		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 4;
	}

}
