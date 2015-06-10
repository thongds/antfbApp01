package com.antifacebookapp01.base_activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.antifacebookapp01.utils.DevLog;
import com.antifacebookapp01.utils.SharedPrefs;

public abstract class BaseActivity extends Activity implements IActivity {

	protected final String TAG_BASE = DevLog.makeLogTag(BaseActivity.class);
	private Context mContext = BaseActivity.this;

	protected SharedPrefs mSharedPrefs;

	/** Resource to get string, color */
	protected Resources mResources;

	/** Common loading dialog while User waiting for something */
	protected Dialog mLoadingDialog;

	/**
	 * @see android.app.Activity#onIOnCreate()
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		DevLog.i(TAG_BASE, "onIOnCreate");

		super.onCreate(savedInstanceState);

		// some code for base activity settings
		mResources = getResources();
		mSharedPrefs = SharedPrefs.getInstance(mContext);
		// mLoadingDialog = LoadingDialogBuilder.getNewInstance(mContext).getDialog();

		this.onICreate(savedInstanceState);
	}

	/**
	 * @see android.app.Activity#onRestart()
	 */
	@Override
	public void onRestart() {
		DevLog.i(TAG_BASE, "onIRestart");
		super.onRestart();
		/*
		 * add more common code before calling subclass.onIRestart()
		 */
		this.onIRestart();
	}

	/**
	 * @see android.app.Activity#onRestart()
	 */
	@Override
	public void onStart() {
		DevLog.i(TAG_BASE, "onIStart");
		super.onStart();
		/*
		 * add more common code before calling subclass.onIStart()
		 */

		this.onIStart();
	}

	/**
	 * @see android.app.Activity#onIResume()
	 */
	@Override
	public void onResume() {
		DevLog.i(TAG_BASE, "onIResume");
		super.onResume();
		/*
		 * add more common code before calling subclass.onIResume()
		 */
		this.onIResume();
	}

	/**
	 * @see android.app.Activity#onRestart()
	 */
	@Override
	public void onPause() {
		DevLog.i(TAG_BASE, "onIPause");
		super.onPause();
		/*
		 * add more common code before calling subclass.onIPause()
		 */

		if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
			mLoadingDialog.dismiss();
		}

		this.onIPause();
	}

	/**
	 * @see android.app.Activity#onIStop()
	 */
	@Override
	public void onStop() {
		DevLog.i(TAG_BASE, "onIStop");
		super.onStop();
		/*
		 * add more common code before calling subclass.onIStop()
		 */
		this.onIStop();
	}

	/**
	 * @see android.app.Activity#onIDestroy()
	 */
	@Override
	public void onDestroy() {
		DevLog.i(TAG_BASE, "onIDestroy");
		super.onDestroy();
		/*
		 * add more common code before calling subclass.onIDestroy()
		 */
		this.onIDestroy();
	}
}
