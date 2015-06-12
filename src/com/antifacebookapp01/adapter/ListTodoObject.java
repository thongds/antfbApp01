package com.antifacebookapp01.adapter;

import com.google.gson.annotations.SerializedName;

public class ListTodoObject extends Object {

	@SerializedName("id")
	private int mId = -1;
	@SerializedName("prop")
	private int mProp = -1;
	@SerializedName("todoListDayId")
	// need create todoListDay table include, day, user, status(remove or not)
	private int mTodoListDayId = -1;
	@SerializedName("des")
	private String mDes = "";
	@SerializedName("checked")
	private boolean mchecked;

	public ListTodoObject(String des, int prop, boolean checked) {
		setDes(des);
		setChecked(checked);
		setProp(prop);
	}

	public int getId() {
		return mId;
	}

	public void setId(int mId) {
		this.mId = mId;
	}

	public int getProp() {
		return mProp;
	}

	public void setProp(int mProp) {
		this.mProp = mProp;
	}

	public String getDes() {
		return mDes;
	}

	public void setDes(String mDes) {
		this.mDes = mDes;
	}

	public boolean isChecked() {
		return mchecked;
	}

	public void setChecked(boolean mchecked) {
		this.mchecked = mchecked;
	}

	public int getTodoListDayId() {
		return mTodoListDayId;
	}

	public void setTodoListDayId(int mTodoListDayId) {
		this.mTodoListDayId = mTodoListDayId;
	}

	public boolean getChecked() {
		return this.mchecked;
	}
}
