package com.example.vinit.flowlayout.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.vinit.flowlayout.Socialimpact.S1;
import com.example.vinit.flowlayout.Socialimpact.S2;
import com.example.vinit.flowlayout.Socialimpact.S3;
import com.example.vinit.flowlayout.Socialimpact.S4;
import com.example.vinit.flowlayout.Socialimpact.S5;
import com.example.vinit.flowlayout.Socialimpact.S6;

public class SocialPagerAdapter extends FragmentPagerAdapter {

	public SocialPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			// Top Rated fragment activity
			return new S1();
		case 1:
			// Games fragment activity
			return new S2();
		case 2:
			// Movies fragment activity
			return new S3();
         case 3:
                // Movies fragment activity
            return new S6();
			case 4:
				// Movies fragment activity
				return new S5();
			case 5:
				// Movies fragment activity
				return new S4();

     		}

		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 6;
	}

}
