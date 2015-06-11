package com.antifacebookapp01.fragment_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import com.antifacebookapp01.base_activity.BaseFragmentActivity;
import com.antifacebookapp01.component.HeaderActionBar;
import com.antifacebookapp01.component.HeaderActionBar.Action;
import com.antifacebookapp01.component.menu.OnMenuListener;
import com.example.antfbapp01.R;

public class MainFragmentActivity extends BaseFragmentActivity implements OnMenuListener {

	/** Layout which contains the menu */
	private DrawerLayout mDrawerMenuLayout;
	/** Listview will show the data from mMenuDataList */
	private ListView mMenuListView;
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

		// listview contains menu items
		mMenuListView = (ListView) findViewById(R.id.left_drawer);
		// TODO Auto-generated method stub

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
