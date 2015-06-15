package com.antifacebookapp01.adapter;

import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.antfbapp01.R;

public class ListDayTodoAdapter extends ArrayAdapter<ListDayObject> {

	private static final int mMenuLayoutId = R.layout.menu_item;
	private Context mContext;
	private List<ListDayObject> mListDay;

	public ListDayTodoAdapter(Context context, List<ListDayObject> objects) {
		super(context, mMenuLayoutId, objects);
		mContext = context;
		mListDay = objects;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		MenuItemHolder itemViewHolder;
		View view = convertView;

		LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
		itemViewHolder = new MenuItemHolder();
		view = inflater.inflate(mMenuLayoutId, parent, false);
		itemViewHolder.textDay = (TextView) view.findViewById(R.id.dayText);
		itemViewHolder.textCount = (TextView) view.findViewById(R.id.textCount);
		itemViewHolder.countCover = (LinearLayout) view.findViewById(R.id.countCover);
		view.setTag(itemViewHolder);

		ListDayObject item = (ListDayObject) mListDay.get(position);
		if (item.getTodoTaskLeft() <= 0) {
			itemViewHolder.countCover.setVisibility(View.GONE);
		} else {
			itemViewHolder.textCount.setText(Integer.toString(item.getTodoTaskLeft()));
		}
		return view;
	}

	private static class MenuItemHolder {

		TextView textDay;
		TextView textCount;
		LinearLayout countCover;
	}

}
