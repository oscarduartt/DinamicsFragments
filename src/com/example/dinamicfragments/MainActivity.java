package com.example.dinamicfragments;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.Surface;
import android.view.WindowManager;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		FragmentManager FM = getFragmentManager();
		FragmentTransaction FT = FM.beginTransaction();

		WindowManager WM = getWindowManager();
		Display d = WM.getDefaultDisplay();

		if (d.getRotation() == Surface.ROTATION_90) {
			Fragment2 f2 = new Fragment2();
			FT.add(android.R.id.content, f2).commit();
		} else if (d.getRotation() == Surface.ROTATION_270) {
			Fragment3 f3 = new Fragment3();
			FT.add(android.R.id.content, f3).commit();
		} else {
			Fragment1 f1 = new Fragment1();
			FT.add(android.R.id.content, f1).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
