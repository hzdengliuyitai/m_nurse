package main.base.baseActivity;

import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.phd91.m_nurse.R;

import main.base.basePresenter.BasePresenter;
import main.base.navigationbar.NavigationBar;


/**
 * Created by ht-template
 **/
abstract public class BaseActionBarActivity<T extends BasePresenter>
        extends BaseActivity<T> {
    protected FrameLayout navigationBarContainer;
    protected NavigationBar navigationBar;
    protected View navigationBackground;
    protected boolean isFromScreenTop = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_navigation);
        initNavigationBar();
        initContentView();
    }

    private void initNavigationBar() {
        navigationBarContainer = (FrameLayout) findViewById(R.id.navigation_bar_container);
        navigationBar = new NavigationBar(this);
        navigationBarContainer.addView(navigationBar);
        navigationBackground = findViewById(R.id.nav_background);

        // 默认点击后退
        setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // 默认设置后退的按钮
        setNavigationBackIcon(R.drawable.selector_back_btn_navigationbar);
        // 默认红色
        setNavigationBarBackgroundColor(R.color.navigation_bar_color);
        // 默认title为粗体
        //setTitleTextStyle(Typeface.BOLD);
        // 默认title颜色
        //setTitleTextColorRes(R.color.navigation_bar_title_color);
    }

    private void initContentView() {
        rootView = (ViewGroup) findViewById(R.id.root_view);
        contentView = (FrameLayout) findViewById(R.id.content_view);
//        contentView.setOnSlidingFinishListener(this);
        touchView = findViewById(R.id.touch_view);
//        contentView.setTouchView(touchView);
    }



    /**
     * Set title for navigation bar using a string
     *
     * @param title string for title
     */
    public void setTitle(String title) {
        navigationBar.setTitle(title);
    }

    /**
     * Set title for navigation bar using a String resource
     *
     * @param resId String resource for title
     */
    public void setTitle(@StringRes int resId) {
        navigationBar.setTitle(resId);
    }

    /**
     * Set title for navigation bar using a view inflate by user
     *
     * @param v view of the title
     */
    public void setTitle(View v) {
        navigationBar.setTitleView(v);
    }

    /**
     * Set title text color for navigation bar using a Color resource
     *
     * @param resId Color resource for title
     */
    public void setTitleTextColorRes(@ColorRes int resId) {
        navigationBar.setTitleTextColorRes(resId);
    }

    /**
     * Set title text color for navigation bar using a Color
     *
     * @param color Color for title
     */
    public void setTitleTextColor(@ColorInt int color) {
        navigationBar.setTitleTextColor(color);
    }

    public void setTitleTextStyle(int typefaceStyle) {
        navigationBar.setTitleTextStyle(typefaceStyle);
    }

    /**
     * Set back btn icon for navigation bar using a drawble resource
     *
     * @param resId drawble resource for the back btn
     */
    public void setNavigationBackIcon(@DrawableRes int resId) {
        navigationBar.setLeftBackImage(resId);
    }

    public void setShowBackIcon(boolean bShow) {
        navigationBar.setShowBackButton(bShow);
    }

    public void setShowLeftView(boolean bShow) {
        navigationBar.showLeftView(bShow);
    }

    /**
     * Set navigation back btn click listener
     *
     * @param listener click listener of navigation back btn
     */
    public void setNavigationOnClickListener(View.OnClickListener listener) {
        navigationBar.setBackButtonClick(listener);
    }

    /**
     * Set right view for the navigation bar
     *
     * @param resId drawble resource for right view
     */
    public void setRightView(@DrawableRes int resId) {
        navigationBar.setRightImageResource(resId);
    }

    /**
     * Set right view for the navigation bar
     *
     * @param v view of right
     */
    public void setRightView(View v) {
        navigationBar.setRightView(v);
    }

    /**
     * Set right text for the navigation bar instand of an icon
     *
     * @param rightText the text to be show at right
     */
    public void setRightText(String rightText) {
        navigationBar.setRightText(rightText);
    }

    /**
     * Set right text color for the navigation bar instand of an icon
     *
     * @param resId the text color of right
     */
    public void setRightTextColor(@ColorRes int resId) {
        navigationBar.setRightTextColor(getResources().getColor(resId));
    }


    /**
     * Set right text for the navigation bar instand of an icon
     *
     * @param resId the string resource id of the text to be show at right
     */
    public void setRightText(@StringRes int resId) {
        navigationBar.setRightText(resId);
    }

    /**
     * Set right view click listener for the navigation bar
     *
     * @param listener click listener of right view
     */
    public void setRightClickListener(View.OnClickListener listener) {
        navigationBar.setRightButtonClick(listener);
    }

    /**
     * Set background of the navigation bar using drawable resource id
     *
     * @param resId drawable resource for the navigation bar background
     */
    public void setNavigationBarBackground(@DrawableRes int resId) {
        navigationBackground.setBackgroundDrawable(getResources().getDrawable(resId));
    }

    /**
     * Set background of the navigation bar using color resource id
     *
     * @param resId color resource for the navigation bar background
     */
    public void setNavigationBarBackgroundColor(@ColorRes int resId) {
        navigationBackground.setBackgroundColor(getResources().getColor(resId));
    }

    /**
     * Set background alpha of the navigation bar background
     *
     * @param alpha the alpha of navigation bar background
     */
    public void setNavigationBarBackgroundAlpha(float alpha) {
        navigationBackground.setAlpha(alpha);
    }

    /**
     * Provide navigation bar container for user
     *
     * @return view of the whole navigation bar
     */
    public View getNavigationBarView() {
        return navigationBarContainer;
    }

  /*  //严选相关代码
    public void setNavigationBarWhite() {
        setNavigationBarBackground(R.drawable.navigation_bar_white_with_divider);
        setTitleTextColorRes(R.color.white_navigation_bar_title_color);
        setNavigationBackIcon(R.drawable.selector_back_btn_navigationbar_white);
    }*/
    //严选相关代码
}
