package com.antifacebookapp01.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefs {

	private static final String FILE_NAME = "antifacebookApp01";
	private static final String BLANK = "";
	private static SharedPrefs mSingleton;
	private String mUserIDKey = "userID";
	private SharedPreferences mDataStore;

	/**
	 * Constructor
	 */
	private SharedPrefs(Context context) {
		mDataStore = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
	}

	public static SharedPrefs getInstance(Context context) {
		if (mSingleton == null) {
			mSingleton = new SharedPrefs(context);
		}
		return mSingleton;
	}

	/**
	 * Method set preference value Save String value
	 */
	private void setPreferenceValue(String preferenceKey, String value) {
		try {
			SharedPreferences.Editor editor = mDataStore.edit();
			editor.putString(preferenceKey, value.trim());
			editor.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 * @param preferenceKey
	 * @return
	 */
	private String getPreferenceValue(String preferenceKey) {
		String prefVal = BLANK;
		try {
			prefVal = mDataStore.getString(preferenceKey, BLANK);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return prefVal;
	}

	public void setCurrentUserIdSharedPref(String idValue) {
		setPreferenceValue(mUserIDKey, idValue);
	}

	public String getUserIdSharedPref() {
		return getPreferenceValue(mUserIDKey);
	}
}
