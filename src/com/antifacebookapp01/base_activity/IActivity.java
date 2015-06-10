package com.antifacebookapp01.base_activity;

import android.os.Bundle;
import android.view.View;

/**
 * Interface of Activity
 * 
 * @author thongds
 *
 */
public interface IActivity {

	/**
	 * Init view for layout
	 */
	public void initView();

	/**
	 * Add header for activity
	 */
	public void addHeader(View v);

	/**
	 * onIOnCreate
	 * 
	 * @param savedInstanceState
	 *            the saved instance state
	 */
	public void onICreate(Bundle savedInstanceState);

	/**
	 * onIRestart
	 */
	public void onIRestart();

	/**
	 * onIStart
	 */
	public void onIStart();

	/**
	 * onIResume
	 */
	public void onIResume();

	/**
	 * onIPause
	 */
	public void onIPause();

	/**
	 * onIStop
	 */
	public void onIStop();

	/**
	 * onIDestroy
	 */
	public void onIDestroy();

}
