package com.antifacebookapp01.adapter;

import com.google.gson.annotations.SerializedName;

public class ListDayObject extends Object {

	@SerializedName("userId")
	private int mUserId;
	@SerializedName("status")
	private int mStatus;
	@SerializedName("dayString")
	private String mDayString;
	@SerializedName("todoTaskLeft")
	private int mTodoTaskLeft;

	public ListDayObject(int status, String dayString, int todoTaskLeft) {
		setStatus(status);
		setDayString(dayString);
		setTodoTaskLeft(todoTaskLeft);
	}

	public int getUserId() {
		return mUserId;
	}

	public void setUserId(int mUserId) {
		this.mUserId = mUserId;
	}

	public int getStatus() {
		return mStatus;
	}

	public void setStatus(int mStatus) {
		this.mStatus = mStatus;
	}

	public String getDayString() {
		return mDayString;
	}

	public void setDayString(String mDayString) {
		this.mDayString = mDayString;
	}

	public int getTodoTaskLeft() {
		return mTodoTaskLeft;
	}

	public void setTodoTaskLeft(int mTodoTaskLeft) {
		this.mTodoTaskLeft = mTodoTaskLeft;
	}
}
