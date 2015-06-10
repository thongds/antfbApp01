package com.antifacebookapp01.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.antifacebookapp01.base_activity.BaseActivity;
import com.antifacebookapp01.fragment_activity.LoginFragmentActivity;
import com.antifacebookapp01.fragment_activity.MainFragmentActivity;

public class MainActivity extends BaseActivity {

	public void openMainFragmentActivity() {
		startActivity(new Intent(this, MainFragmentActivity.class));
	}

	public void openLoginFragmentActivity() {
		startActivity(new Intent(this, LoginFragmentActivity.class));
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addHeader(View v) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onICreate(Bundle savedInstanceState) {
		if (mSharedPrefs.getUserIdSharedPref().equals("")) {
			openLoginFragmentActivity();
		} else {
			openMainFragmentActivity();
		}
	}

	@Override
	public void onIRestart() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onIStart() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onIResume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onIPause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onIStop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onIDestroy() {
		// TODO Auto-generated method stub

	}
}
