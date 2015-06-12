package com.antifacebookapp01.fragment_activity;

import java.util.ArrayList;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import com.antifacebookapp01.adapter.ListTodoAdapter;
import com.antifacebookapp01.adapter.ListTodoObject;
import com.antifacebookapp01.base_activity.BaseFragmentActivity;
import com.antifacebookapp01.component.HeaderActionBar;
import com.antifacebookapp01.component.HeaderActionBar.Action;
import com.antifacebookapp01.component.menu.OnMenuListener;
import com.example.antfbapp01.R;

public class MainFragmentActivity extends BaseFragmentActivity implements OnMenuListener {

	private Context mContext = MainFragmentActivity.this;
	/** Layout which contains the menu */
	private DrawerLayout mDrawerMenuLayout;
	/** Listview will show the data from mMenuDataList */
	private ListView mMenuListView;
	/** Hold listview */
	private ListView mListViewTodo;

	private ListTodoAdapter mListTodoAdapter;
	private ArrayList<ListTodoObject> mArrayListTodoObject = new ArrayList<ListTodoObject>();
	/** Action Setting */
	private Action mHeaderActionSort = new Action() {

		@Override
		public void performAction(View view) {
			// changeFragment(A120FragmentsId.A190SortPage);
		}

		@Override
		public int getDrawable() {
			return R.drawable.ic_action_setting;
		}
	};

	@Override
	public void initViews() {
		// layout of all menu
		mDrawerMenuLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerMenuLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
		// List view contain list todo
		mListViewTodo = (ListView) findViewById(R.id.listViewTodo);
		for (int i = 0; i < 5; i++) {
			mArrayListTodoObject
					.add(new ListTodoObject(
							" have a list of records in a listview that I want the user to be able to re-sort using a drag and drop method. I have seen this implemented in other apps, but I have not found a tutorial for it",
							1, false));
		}
		for (int i = 0; i < 5; i++) {
			mArrayListTodoObject
					.add(new ListTodoObject(
							" have a list of records in a listview that I want the user to be able to re-sort using a drag and drop method. I have seen this implemented in other apps, but I have not found a tutorial for it",
							2, true));
		}
		for (int i = 0; i < 5; i++) {
			mArrayListTodoObject
					.add(new ListTodoObject(
							" have a list of records in a listview that I want the user to be able to re-sort using a drag and drop method. I have seen this implemented in other apps, but I have not found a tutorial for it",
							3, true));
		}
		mListTodoAdapter = new ListTodoAdapter(mContext, mArrayListTodoObject);
		mListViewTodo.setAdapter(mListTodoAdapter);
		// listview contains menu items
		mMenuListView = (ListView) findViewById(R.id.left_drawer);

	}

	@Override
	public void initHeader() {
		mHeader = (HeaderActionBar) findViewById(R.id.headerInMenu);
		mHeader.setTextTitle(mResources.getString(R.string.a110_header));
		mHeader.setMenuAction(new Action() {

			@Override
			public void performAction(View view) {
				if (mDrawerMenuLayout != null) {
					onToggleMenu();
				}
			}

			@Override
			public int getDrawable() {
				return 0;
			}
		});

		mHeader.addAction(mHeaderActionSort);
	}

	@Override
	public void onICreate(Bundle savedInstanceState) {
		setContentView(R.layout.main_holder_layout);
		initViews();
		initHeader();
	}

	@Override
	public void onIAttachFragment(Fragment fragment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onIStart() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onIPause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onIResume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onIStop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onIDestroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onIActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onIKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Listener of toggle menu
	 */
	@Override
	public void onToggleMenu() {
		if (mDrawerMenuLayout != null) {
			if (mDrawerMenuLayout.isDrawerOpen(mMenuListView)) {
				mDrawerMenuLayout.closeDrawers();
			} else {
				mDrawerMenuLayout.openDrawer(mMenuListView);
			}
		}
	}

}
