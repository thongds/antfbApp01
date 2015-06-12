package com.antifacebookapp01.adapter;

import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.antifacebookapp01.utils.Constance;
import com.example.antfbapp01.R;

public class ListTodoAdapter extends ArrayAdapter<ListTodoObject> {

	private static final int mListViewLayoutId = R.layout.list_todo_item;
	private Context mContext;
	private List<ListTodoObject> mListTodoObject;

	public ListTodoAdapter(Context context, List<ListTodoObject> objects) {
		super(context, mListViewLayoutId, objects);
		mContext = context;
		mListTodoObject = objects;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		final TodoListHolder todoListHolder;
		View view = convertView;
		if (view == null) {
			todoListHolder = new TodoListHolder();
			LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
			view = inflater.inflate(mListViewLayoutId, parent, false);
			todoListHolder.description = (TextView) view.findViewById(R.id.descriptionText);
			todoListHolder.checkBox = (CheckBox) view.findViewById(R.id.checkboxId);
			view.setTag(todoListHolder);
		} else {
			todoListHolder = (TodoListHolder) view.getTag();
		}
		ListTodoObject item = (ListTodoObject) mListTodoObject.get(position);
		todoListHolder.checkBox.setChecked(item.getChecked());
		if (item.isChecked()) {
			todoListHolder.description.setTextColor(view.getResources().getColor(R.color.low));
		} else {
			switch (item.getProp()) {
				case Constance.HEIGH:
					todoListHolder.description.setTextColor(view.getResources().getColor(R.color.heigh));
					break;
				case Constance.NORMAL:
					todoListHolder.description.setTextColor(view.getResources().getColor(R.color.normal));
					break;
				case Constance.LOW:
					todoListHolder.description.setTextColor(view.getResources().getColor(R.color.low));
					break;

				default:
					break;
			}
		}
		if (item.getDes() != null) {
			todoListHolder.description.setText(item.getDes());
		}

		return view;
	}

	public static class TodoListHolder {

		TextView description;
		CheckBox checkBox;
	}

}
