package com.antifacebookapp01.base_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;

public interface IFragmentActivity {

	/**
	 * Init all views of layout
	 */
	public void initViews();

	/**
	 * Add {@link HeaderActionBar} to layout
	 * 
	 * @param View
	 */
	public void initHeader();

	/**
	 * onICreate
	 */
	public void onICreate(Bundle savedInstanceState);

	/**
	 * onIAttachFragment
	 * 
	 * @param fragment
	 *            the fragment
	 */
	public void onIAttachFragment(Fragment fragment);

	/**
	 * onIStart
	 */
	public void onIStart();

	/**
	 * onIPause
	 */
	public void onIPause();

	/**
	 * onIResume
	 */
	public void onIResume();

	/**
	 * onIStop
	 */
	public void onIStop();

	/**
	 * onIDestroy
	 */
	public void onIDestroy();

	/**
	 * onIActivityResult
	 * 
	 * @param requestCode
	 *            the request code
	 * @param resultCode
	 *            the result code
	 * @param data
	 *            the data
	 */
	public void onIActivityResult(int requestCode, int resultCode, Intent data);

	/**
	 * onIKeyDown
	 * 
	 * @param keyCode
	 *            the key code
	 * @param event
	 *            the event
	 * @return true, if successful
	 */
	public boolean onIKeyDown(int keyCode, KeyEvent event);
}
