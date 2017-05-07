package main.base.navigationbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.phd91.m_nurse.R;

import main.utill.ResourcesUtil;


/**
 * Created by ht-template
 **/
public class NavigationBar extends FrameLayout {
    private FrameLayout
            mLeftViewContainer;
    private FrameLayout mRightViewContainer;
    private TextView mTitleTextView;

    private ImageView mLeftBackView;
    private TextView mLeftTextView;

    private FrameLayout mCenterViewContainer;

    private TextView mRightTextView;
    private ImageView mRightImageView;

    private View mSepLine;

    public NavigationBar(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View root = inflater.inflate(R.layout.view_navigation_bar, null);
        mTitleTextView = (TextView) root.findViewById(R.id.nav_title);

        mRightViewContainer = (FrameLayout) root.findViewById(R.id.nav_right_container);
        mRightTextView = (TextView) root.findViewById(R.id.nav_right_text);
        mRightImageView = (ImageView) root.findViewById(R.id.nav_right_img);

        mLeftViewContainer = (FrameLayout) root.findViewById(R.id.nav_left_container);
        mCenterViewContainer = (FrameLayout) root.findViewById(R.id.nav_titleView_container);
        mLeftBackView = (ImageView) root.findViewById(R.id.nav_left_img);
        mLeftTextView = (TextView) root.findViewById(R.id.nav_left_text);
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        mSepLine = root.findViewById(R.id.nav_sep_line);
        this.addView(root, lp);
    }

    public void setShowBackButton(boolean bShow) {
        mLeftBackView.setVisibility(bShow ? View.VISIBLE : View.GONE);
    }

    public void setLeftBackImage(@DrawableRes int imageId) {
        mLeftBackView.setImageResource(imageId);
    }

    public void setLeftBackImage(Drawable drawable) {
        if (mLeftBackView.getParent() == null) {
            mLeftViewContainer.removeAllViews();
            int size= ResourcesUtil.getDimenPxSize(R.dimen.default_tool_bar_icon_size);
            LayoutParams lp =
                    new LayoutParams(size, size);
            mLeftViewContainer.addView(mLeftBackView, lp);
        }
        mLeftTextView.setVisibility(View.GONE);
        mLeftBackView.setImageDrawable(drawable);
    }

    public void setBackButtonClick(OnClickListener onclick) {
        mLeftViewContainer.setOnClickListener(onclick);
    }

    public void setRightButtonClick(OnClickListener onclick) {
        mRightViewContainer.setOnClickListener(onclick);
    }

    public void setTitleClick(OnClickListener onclick) {
        mTitleTextView.setOnClickListener(onclick);
    }

    public void setLeftView(View view) {
        if (mLeftViewContainer.getChildCount() > 0) {
            mLeftViewContainer.removeAllViews();
        }
        if (view != null) {
            LayoutParams lp =
                    new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
            mLeftViewContainer.addView(view, lp);
        }
    }

    public void setLeftImageView(int drawableId) {
        if (mLeftBackView.getParent() == null) {
            mLeftViewContainer.removeAllViews();
            int size= ResourcesUtil.getDimenPxSize(R.dimen.default_tool_bar_icon_size);
            LayoutParams lp =
                    new LayoutParams(size, size);
            mLeftViewContainer.addView(mLeftBackView, lp);
        }
        mLeftTextView.setVisibility(View.GONE);
        mLeftBackView.setImageResource(drawableId);
    }

    public void setLeftTextString(String str) {
        if (mLeftTextView.getParent() == null) {
            mLeftViewContainer.removeAllViews();
            LayoutParams lp =
                    new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
            mLeftViewContainer.addView(mLeftTextView, lp);
        }
        mLeftBackView.setVisibility(View.GONE);
        mLeftTextView.setText(str);
    }

    public void setLeftTextString(int stringId) {
        String str = ResourcesUtil.getString(stringId);
        setLeftTextString(str);
    }

    public void setRightView(View view) {
        if (mRightViewContainer.getChildCount() > 0) {
            mRightViewContainer.removeAllViews();
        }
        if (view != null) {
            LayoutParams lp =
                    new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
            mRightViewContainer.addView(view, lp);
        }
    }

    public void setRightImageResource(int drawableId) {
        if (mRightImageView.getParent() == null) {
            mRightViewContainer.removeAllViews();
            int size=ResourcesUtil.getDimenPxSize(R.dimen.default_tool_bar_icon_size);
            LayoutParams lp =
                    new LayoutParams(size, size);
            mRightViewContainer.addView(mRightImageView, lp);
        }
        mRightTextView.setVisibility(View.GONE);
        mRightImageView.setImageResource(drawableId);
    }

    public void setLeftImageResource(int drawableId) {
        if (mLeftViewContainer.getParent() == null) {
            mLeftViewContainer.removeAllViews();
            int size=ResourcesUtil.getDimenPxSize(R.dimen.default_tool_bar_icon_size);
            LayoutParams lp =
                    new LayoutParams(size, size);
            mLeftViewContainer.addView(mLeftBackView, lp);
        }
        mLeftBackView.setVisibility(View.GONE);
        mLeftBackView.setImageResource(drawableId);
    }

    public void setRightText(int stringId) {
        String str = ResourcesUtil.getString(stringId);
        setRightText(str);
    }

    public void setRightText(String str) {
        if (mRightTextView.getParent() == null) {
            mRightViewContainer.removeAllViews();
            LayoutParams lp =
                    new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
            mRightViewContainer.addView(mRightTextView, lp);
        }
        mRightImageView.setVisibility(View.GONE);
        mRightTextView.setText(str);
    }

    public void setRightTextColor(int color) {
        mRightTextView.setTextColor(color);
    }

    public void setTitleView(View view) {
        mTitleTextView.setVisibility(View.INVISIBLE);
        mCenterViewContainer.setVisibility(View.VISIBLE);
        mCenterViewContainer.removeAllViews();
        if (view != null) {
            LayoutParams lp =
                    new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
            lp.gravity = Gravity.CENTER;
            mCenterViewContainer.addView(view, lp);
        }
    }

    public void setTitle(int stringId) {
        String title = ResourcesUtil.getString(stringId);
        setTitle(title);
    }

    public void setTitle(String title) {
        mTitleTextView.setVisibility(View.VISIBLE);
        mCenterViewContainer.setVisibility(View.INVISIBLE);

        mTitleTextView.setText(title);
    }

    public void setTitleTextColor(int color) {
        mTitleTextView.setTextColor(color);
    }

    public void setTitleTextColorRes(@ColorRes int resId) {
        mTitleTextView.setTextColor(getResources().getColor(resId));
    }

    public void setTitleTextStyle(int typefaceStyle) {
        mTitleTextView.setTypeface(null, typefaceStyle);
    }

    /**
     * @param size 接收一个px值
     */
    public void setTitleTextSize(float size) {
        mTitleTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }

    public void setBgColor(int color) {
        setBackgroundColor(color);
    }

    public void setSepLineVisiable(boolean isVisiable) {
        if (isVisiable) {
            mSepLine.setVisibility(VISIBLE);
        } else {
            mSepLine.setVisibility(INVISIBLE);
        }
    }

    public void setNavigationBarBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void showLeftView(boolean isShow) {
        mLeftViewContainer.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }

    public void showRightView(boolean isShow) {
        mRightViewContainer.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }
}
