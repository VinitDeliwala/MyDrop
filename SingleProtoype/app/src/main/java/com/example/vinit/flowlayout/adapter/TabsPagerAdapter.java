package com.example.vinit.flowlayout.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.vinit.flowlayout.FirstScreen.Logo;
import com.example.vinit.flowlayout.FirstScreen.SocialScore;
import com.example.vinit.flowlayout.FirstScreen.WhoWeAre;
import com.example.vinit.flowlayout.FirstScreen.YourGoal;
import com.example.vinit.flowlayout.FirstScreen.register;

public class TabsPagerAdapter extends FragmentPagerAdapter {

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			// Top Rated fragment activity
			return new Logo();
		case 1:
			// Games fragment activity
			return new WhoWeAre();
		case 2:
			// Movies fragment activity
			return new YourGoal();
         case 3:
                // Movies fragment activity
            return new SocialScore();

            case 4:
                // Movies fragment activity
                return new register();
     		}

		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 5;
	}

}
