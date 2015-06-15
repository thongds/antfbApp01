package com.antifacebookapp01.fragment_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.View;
import com.antifacebookapp01.base_activity.BaseFragmentActivity;
import com.antifacebookapp01.component.HeaderActionBar;
import com.antifacebookapp01.component.HeaderActionBar.Action;
import com.example.antfbapp01.R;

public class SettingFragmentActivity extends BaseFragmentActivity {

	private HeaderActionBar mHeader;

	@Override
	public void initViews() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initHeader() {
		mHeader = (HeaderActionBar) findViewById(R.id.headerInSetting);
		mHeader.setTextTitle(mResources.getString(R.string.setting_header));
		mHeader.setMenuAction(new Action() {

			@Override
			public int getDrawable() {
				return R.drawable.btn_back;
			}

			@Override
			public void performAction(View view) {
				setResult(RESULT_CANCELED);
				finish();
			}

		});

	}

	@Override
	public void onICreate(Bundle savedInstanceState) {
		setContentView(R.layout.setting_activity);
		initViews();
		initHeader();

	}

	@Override
	public void onIAttachFragment(Fragment fragment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onIStart() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onIPause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onIResume() {
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

	@Override
	public void onIActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onIKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

}
