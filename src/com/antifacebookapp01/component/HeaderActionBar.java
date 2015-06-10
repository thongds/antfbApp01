package com.antifacebookapp01.component;

import java.util.LinkedList;
import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.antfbapp01.R;

/**
 * The Header component
 * 
 * @author tran.anh
 * 
 */
public class HeaderActionBar extends RelativeLayout implements OnClickListener {

	private LayoutInflater mInflater;

	/** The whole Action bar view */
	private RelativeLayout mBarView;

	/** Logo */
	private ImageView mLogoView;

	/** Title in center */
	private TextView mTitleView;

	/** Contain many views of action */
	private LinearLayout mActionsListView;

	/** Home or Back button */
	private ImageButton mMenuButton;

	public HeaderActionBar(Context context, AttributeSet attrs) {
		super(context, attrs);

		createView(context, attrs);
	}

	@Override
	public void onClick(View view) {
		final Object tag = view.getTag();
		if (tag instanceof Action) {
			final Action action = (Action) tag;
			action.performAction(view);
		}
	}

	private void createView(Context context, AttributeSet attrs) {
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		mBarView = (RelativeLayout) mInflater.inflate(R.layout.view_header, null);
		addView(mBarView);

		// menu / hamburger / back button
		mMenuButton = (ImageButton) mBarView.findViewById(R.id.actionbar_home_btn);
		mMenuButton.setVisibility(View.VISIBLE);

		// logo view
		mLogoView = (ImageView) mBarView.findViewById(R.id.actionbar_home_logo);
		mLogoView.setVisibility(View.GONE);

		// header title
		mTitleView = (TextView) mBarView.findViewById(R.id.actionbar_title);
		mTitleView.setVisibility(View.GONE);

		mActionsListView = (LinearLayout) mBarView.findViewById(R.id.actionbar_actions);
		mActionsListView.setVisibility(View.VISIBLE);
	}

	/**
	 * Set color for action bar
	 */
	public void setColorBacground(int color) {
		// sample color = R.color.color_official
		if (mBarView != null) {
			mBarView.findViewById(R.id.actionbar_background).setBackgroundColor(this.getResources().getColor(color));
		}
	}

	/**
	 * Set action listener for Menu button
	 * 
	 * @param action
	 */
	public void setMenuAction(Action action) {
		mMenuButton.setOnClickListener(this);
		mMenuButton.setTag(action);
		mMenuButton.setImageResource(action.getDrawable());

	}

	public void setMenuButtonResource(int resID) {
		mMenuButton.setImageResource(resID);
	}

	public void setMenuButtonVisibility(int visibility) {
		mMenuButton.setVisibility(visibility);
	}

	/**
	 * Logo in the center of action bar
	 * 
	 * @param resID
	 */
	public void setLogoReourse(int resID) {
		mLogoView.setImageResource(resID);
		mLogoView.setVisibility(View.VISIBLE);
		mTitleView.setVisibility(View.VISIBLE);
	}

	/**
	 * Set visibility of DreamJob logo
	 */
	public void setLogoVisibility(boolean visible) {
		mLogoView.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
		mTitleView.setVisibility(!visible ? View.VISIBLE : View.INVISIBLE);
	}

	/**
	 * Change the title of header and show
	 * 
	 * @param title
	 */
	public void setTextTitle(CharSequence title) {
		mTitleView.setText(title);
		mTitleView.setVisibility(View.VISIBLE);
		mLogoView.setVisibility(View.INVISIBLE);
	}

	/**
	 * Change the the title of header and show
	 * 
	 * @param title
	 *            id of resource (R.string)
	 */
	public void setTextTitle(int resID) {
		mTitleView.setText(resID);
		mTitleView.setVisibility(View.VISIBLE);
		mLogoView.setVisibility(View.INVISIBLE);
	}

	public void setTextTitleVisibility(boolean visible) {
		mTitleView.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
		mLogoView.setVisibility(!visible ? View.VISIBLE : View.INVISIBLE);
	}

	/**
	 * Adds a list of {@link Action}s to left of header
	 * 
	 * @param actionList
	 *            the actions to add
	 */
	public void addActions(ActionList actionList) {
		int actions = actionList.size();
		for (int i = 0; i < actions; i++) {
			addAction(actionList.get(i));
		}
	}

	/**
	 * Adds a new {@link Action}.
	 * 
	 * @param action
	 *            the action to add
	 */
	public void addAction(Action action) {
		// add another the 1 in the last
		addAction(action, mActionsListView.getChildCount());
	}

	/**
	 * Adds a new {@link Action} at the specified index.
	 * 
	 * @param action
	 *            the action to add
	 * @param index
	 *            the position at which to add the action
	 */
	public void addAction(Action action, int index) {
		mActionsListView.addView(inflateAction(action), index);
	}

	/**
	 * Button which does not use drawable but Text to show its display
	 * 
	 * @param action
	 * @param text
	 */
	public void addTextButton(Action action, String text) {
		mActionsListView.addView(inflateTextButton(action, text), mActionsListView.getChildCount());
	}

	/**
	 * Inflates a {@link View} with the given {@link Action}.
	 * 
	 * @param action
	 *            the action to inflate
	 * @return a view
	 */
	private View inflateAction(Action action) {
		View view = mInflater.inflate(R.layout.view_header_item, mActionsListView, false);

		ImageButton labelView = (ImageButton) view.findViewById(R.id.actionbar_item);
		labelView.setImageResource(action.getDrawable());

		view.setTag(action);
		view.setOnClickListener(this);
		return view;
	}

	@SuppressLint("NewApi")
	private View inflateTextButton(Action action, String text) {
		View view = mInflater.inflate(R.layout.view_header_button, mActionsListView, false);

		if (text != null && !text.isEmpty()) {
			TextView labelView = (TextView) view.findViewById(R.id.actionbar_button);
			labelView.setText(text);
		}

		view.setTag(action);
		view.setOnClickListener(this);
		return view;
	}

	/**
	 * Removes all action views from this action bar
	 */
	public void removeAllActions() {
		mActionsListView.removeAllViews();
	}

	/**
	 * Remove a action from the action bar.
	 * 
	 * @param index
	 *            position of action to remove
	 */
	public void removeActionAt(int index) {
		mActionsListView.removeViewAt(index);
	}

	/**
	 * Remove a action from the action bar.
	 * 
	 * @param action
	 *            The action to remove
	 */
	public void removeAction(Action action) {
		int childCount = mActionsListView.getChildCount();
		for (int i = 0; i < childCount; i++) {
			View view = mActionsListView.getChildAt(i);
			if (view != null) {
				final Object tag = view.getTag();
				if (tag instanceof Action && tag.equals(action)) {
					mActionsListView.removeView(view);
				}
			}
		}
	}

	/**
	 * Show or hide the action by Action
	 * 
	 * @param action
	 * @param visibility
	 */
	public void setActionVisibillity(Action action, int visibility) {
		int id = findAction(action);
		if (id >= 0) {
			mActionsListView.getChildAt(id).setVisibility(visibility);
		}
	}

	/**
	 * Show or hide the action by id
	 * 
	 * @param actionId
	 * @param visibility
	 */
	public void setActionVisibillity(int actionId, int visibility) {
		if (actionId >= 0 && actionId < mActionsListView.getChildCount() - 1) {
			mActionsListView.getChildAt(actionId).setVisibility(visibility);
		}
	}

	public void setActionDrawable(int id, int resource) {
		if (id >= 0) {
			((ImageButton) mActionsListView.getChildAt(id)).setImageResource(resource);
		}
	}

	public void setActionDrawable(Action action, int resource) {
		int id = findAction(action);
		if (id >= 0) {
			((ImageButton) mActionsListView.getChildAt(id)).setImageResource(resource);
		}
	}

	/**
	 * Find the id of action bar
	 * 
	 * @param action
	 * @return -1 not found the action >=0 if found the action
	 */
	public int findAction(Action action) {
		int childCount = mActionsListView.getChildCount();
		for (int i = 0; i < childCount; i++) {
			View view = mActionsListView.getChildAt(i);
			if (view != null) {
				final Object tag = view.getTag();
				if (tag instanceof Action && tag.equals(action)) { return i; }
			}
		}

		return -1;
	}

	@SuppressWarnings("serial")
	public static class ActionList extends LinkedList<Action> {}

	/**
	 * Action of button on left of action bar
	 */
	public interface Action {

		/** get resource */
		int getDrawable();

		/** action perform on button click */
		void performAction(View view);
	}

	/**
	 * AbstractAction
	 */
	public static abstract class AbstractAction implements Action {

		final private int mDrawable;

		public AbstractAction(int drawable) {
			mDrawable = drawable;
		}

		@Override
		public int getDrawable() {
			return mDrawable;
		}
	}

	/**
	 * IntentAction
	 */
	public static class IntentAction extends AbstractAction {

		private Context mContext;
		private Intent mIntent;

		public IntentAction(Context context, Intent intent, int drawable) {
			super(drawable);
			mContext = context;
			mIntent = intent;
		}

		@Override
		public void performAction(View view) {
			try {
				mContext.startActivity(mIntent);
			} catch (ActivityNotFoundException e) {
				Toast.makeText(mContext, "ActionBar ActivityNotFoundException", Toast.LENGTH_SHORT).show();
			}
		}
	}
}
