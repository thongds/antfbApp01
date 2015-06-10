package com.antifacebookapp01.base_activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import com.antifacebookapp01.component.HeaderActionBar;
import com.antifacebookapp01.utils.DevLog;
import com.antifacebookapp01.utils.SharedPrefs;

public abstract class BaseFragmentActivity extends FragmentActivity implements IFragmentActivity {

	protected final String TAG_BASE = DevLog.makeLogTag(BaseFragmentActivity.class);
	private Context mContext = BaseFragmentActivity.this;
	protected HeaderActionBar mHeader;
	protected SharedPrefs mSharedPrefs;

	// protected HeaderActionBar mHeader;
	//
	// protected TableUpdateMamangementAdapter mTableUpdateMamangementHelper;
	//
	// protected TableDataListAdapter mTableDataListHelper;

	/** Resource to get string, color */
	protected Resources mResources;

	/** Common loading dialog while User waiting for something */
	protected Dialog mLoadingDialog;

	/**
	 * @see android.support.v4.app.FragmentActivity#onAttachFragment(android.support
	 *      .v4.app.Fragment)
	 */
	@Override
	public void onAttachFragment(Fragment fragment) {
		DevLog.i(TAG_BASE, "onAttachFragment");

		super.onAttachFragment(fragment);
		/*
		 * add more common code before calling subclass.setIFragmentArguments()
		 */
		this.onIAttachFragment(fragment);
	}

	/**
	 * @see android.support.v4.app.FragmentActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		DevLog.i(TAG_BASE, "onCreate");

		super.onCreate(savedInstanceState);
		/*
		 * add more common code before calling subclass.setIFragmentArguments()
		 */
		mResources = getResources();
		mSharedPrefs = SharedPrefs.getInstance(mContext);
		// mTableUpdateMamangementHelper = new TableUpdateMamangementAdapter(mContext);
		// mTableDataListHelper = new TableDataListAdapter(mContext);
		// mLoadingDialog = LoadingDialogBuilder.getNewInstance(mContext).getDialog();

		this.onICreate(savedInstanceState);
	}

	/**
	 * @see android.support.v4.app.FragmentActivity#onStart()
	 */
	@Override
	protected void onStart() {
		DevLog.i(TAG_BASE, "onStart");

		super.onStart();
		/*
		 * add more common code before calling subclass.setIFragmentArguments()
		 */
		this.onIStart();
	}

	/**
	 * @see android.support.v4.app.FragmentActivity#onResume()
	 */
	@Override
	protected void onResume() {
		DevLog.i(TAG_BASE, "onResume");

		super.onResume();
		/*
		 * add more common code before calling subclass.setIFragmentArguments()
		 */
		this.onIResume();
	}

	/**
	 * @see android.support.v4.app.FragmentActivity#onPause()
	 */
	@Override
	protected void onPause() {
		DevLog.i(TAG_BASE, "onPause");

		super.onPause();
		/*
		 * add more common code before calling subclass.setIFragmentArguments()
		 */
		this.onIPause();
	}

	/**
	 * @see android.support.v4.app.FragmentActivity#onStop()
	 */
	@Override
	protected void onStop() {
		DevLog.i(TAG_BASE, "onStop");

		super.onStop();
		/*
		 * add more common code before calling subclass.setIFragmentArguments()
		 */
		this.onIStop();
	}

	/**
	 * @see android.support.v4.app.FragmentActivity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		DevLog.i(TAG_BASE, "onDestroy");

		super.onDestroy();
		/*
		 * add more common code before calling subclass.setIFragmentArguments()
		 */
		this.onIDestroy();
	}

	/**
	 * @see android.support.v4.app.FragmentActivity#onActivityResult(int, int,
	 *      android.content.Intent)
	 */
	@Override
	protected void onActivityResult(int arg0, int arg1, Intent arg2) {
		DevLog.i(TAG_BASE, "onActivityResult");

		super.onActivityResult(arg0, arg1, arg2);
		/*
		 * add more common code before calling subclass.setIFragmentArguments()
		 */
		this.onIActivityResult(arg0, arg1, arg2);
	}

	/**
	 * If there is exception code for subclass, and return true. If let
	 * superclass handles, return false.
	 * 
	 * @see android.support.v4.app.FragmentActivity#onKeyDown(int, android.view.KeyEvent)
	 */
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		DevLog.i(TAG_BASE, "onKeyDown");

		if (!this.onIKeyDown(keyCode, event)) {
			if (keyCode == KeyEvent.KEYCODE_BACK) {
				onBackPressed();
			}
		}

		return true;
	}

	/**
	 * Pop back stack. (not tested)
	 * 
	 * @param name
	 *            the name
	 */
	protected void popBackStackByName(String tagName) {
		if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
			getSupportFragmentManager().popBackStack(tagName, FragmentManager.POP_BACK_STACK_INCLUSIVE);
		}
	}

	/**
	 * Add the fragment.
	 * 
	 * @param id
	 *            the id
	 * @param fragment
	 *            the fragment
	 * @param bundle
	 *            the bundle
	 */
	protected void addFragment(int layoutResourceId, Fragment fragment, Bundle bundle) {
		fragment.setArguments(bundle);
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.add(layoutResourceId, fragment);
		transaction.addToBackStack(null);
		transaction.commit();
	}

	/**
	 * Add the fragment with Tag name for later recognize
	 * 
	 * @param layoutResourceId
	 * @param fragment
	 * @param bundle
	 * @param tagName
	 */
	protected void addFragment(int layoutResourceId, Fragment fragment, Bundle bundle, String tagName) {
		fragment.setArguments(bundle);
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.add(layoutResourceId, fragment);
		transaction.addToBackStack(tagName);
		transaction.commit();
	}

	/**
	 * Keep only Main fragment, check the number of fragment in backstack This fix the bug that
	 * add many DetailFragment to backstack
	 */
	protected void popLastFragmentOutOfBackStack() {
		android.support.v4.app.FragmentManager fragManager = this.getSupportFragmentManager();

		if (fragManager.getBackStackEntryCount() > 0) {
			// consider only 1 extra fragment
			// this only pops off 1 fragment from stack
			fragManager.popBackStack();
		}
	}

	protected void popAllFragmentsFromBackStack() {
		FragmentManager fm = this.getSupportFragmentManager();
		for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
			fm.popBackStack();
		}
	}

	/**
	 * Change file for include layout case
	 * 
	 * @param idField
	 *            parent's id field need change
	 * @param fieldIncludeChange
	 *            : id of include field need change
	 * @param text
	 * @return
	 */
	// public TextViewRoboto setTextFieldTitle(int idField, int fieldIncludeChange, String text) {
	// View titleView = findViewById(idField);
	// if (text == null || titleView == null) { return null; }
	// TextViewRoboto textview = (TextViewRoboto) titleView.findViewById(fieldIncludeChange);
	// if (textview == null) { return null; }
	// textview.setText(text);
	//
	// return textview;
	// }
}
