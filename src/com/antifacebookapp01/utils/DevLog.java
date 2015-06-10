package com.antifacebookapp01.utils;

import android.util.Log;

public class DevLog {

	private static final String LOG_PREFIX = "drj_";
	private static final int LOG_PREFIX_LENGTH = LOG_PREFIX.length();
	private static final int MAX_LOG_TAG_LENGTH = 23;

	private static String makeLogTag(String str) {
		if (str.length() > MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH) { return LOG_PREFIX
				+ str.substring(0, MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH - 1); }
		return LOG_PREFIX + str;
	}

	/**
	 * Don't use this when obfuscating class names!
	 */
	public static String makeLogTag(Class cls) {
		return makeLogTag(cls.getSimpleName());
	}

	private static boolean isValid(String str) {
		if (str == null)
			return false;
		return true;
	}

	public static void d(final String tag, String message) {
		if (Configs.DEBUG && isValid(tag) && isValid(message)) {
			Log.d(tag, message);
		}
	}

	public static void d(final String tag, String message, Throwable cause) {
		if (Configs.DEBUG && isValid(tag) && isValid(message)) {
			Log.d(tag, message, cause);
		}
	}

	public static void v(final String tag, String message) {
		if (Configs.DEBUG && isValid(tag) && isValid(message)) {
			Log.v(tag, message);
		}
	}

	public static void v(final String tag, String message, Throwable cause) {
		if (Configs.DEBUG && isValid(tag) && isValid(message)) {
			Log.v(tag, message, cause);
		}
	}

	public static void i(final String tag, String message) {
		if (Configs.DEBUG && isValid(tag) && isValid(message)) {
			Log.i(tag, message);
		}
	}

	public static void i(final String tag, String message, Throwable cause) {
		if (Configs.DEBUG && isValid(tag) && isValid(message)) {
			Log.i(tag, message, cause);
		}
	}

	public static void w(final String tag, String message) {
		if (Configs.DEBUG && isValid(tag) && isValid(message)) {
			Log.w(tag, message);
		}
	}

	public static void w(final String tag, String message, Throwable cause) {
		if (Configs.DEBUG && isValid(tag) && isValid(message)) {
			Log.w(tag, message, cause);
		}
	}

	public static void e(final String tag, String message) {
		if (Configs.DEBUG && isValid(tag) && isValid(message)) {
			Log.e(tag, message);
		}
	}

	public static void e(final String tag, String message, Throwable cause) {
		if (Configs.DEBUG && isValid(tag) && isValid(message)) {
			Log.e(tag, message, cause);
		}
	}

	private DevLog() {
	}
}
