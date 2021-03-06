package main.base.baseFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.phd91.m_nurse.R;

import main.base.baseFragmentPresenter.BaseFragmentPresenter;
import main.base.navigationbar.NavigationBar;
import main.utill.ResourcesUtil;


/**
 * Created by hzdengliuyitai on 2016/8/22.
 */
abstract public class BaseActionbarFragment<T extends BaseFragmentPresenter>
        extends BaseFragment<T> {
    protected ViewGroup navigationBarContainer;
    protected NavigationBar navigationBar;
    protected View navigationBackground;
    protected Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        rootView = (FrameLayout) inflater.inflate(R.layout.activity_with_navigation, null);
        context = getActivity();

        initNavigationBar();
        initContentView();

        return rootView;
    }

    private void initNavigationBar() {
        navigationBarContainer = (FrameLayout) rootView.findViewById(R.id.navigation_bar_container);
        navigationBar = new NavigationBar(context);
        navigationBarContainer.addView(navigationBar);
        navigationBackground = rootView.findViewById(R.id.nav_background);
    }

    private void initContentView() {
        contentView = (FrameLayout) rootView.findViewById(R.id.content_view);
//        contentView.setOnSlidingFinishListener(this);
        touchView = rootView.findViewById(R.id.touch_view);
//        contentView.setTouchView(touchView);
        // 默认红色
       // setNavigationBarBackgroundColor(R.color.navigation_bar_color);
        //setTitleTextStyle(Typeface.BOLD);
        setTitleTextColorRes(R.color.navigation_bar_title_color);
        //默认字号18
        setTitleTextSize(getResources().getDimensionPixelSize(R.dimen.text_size_xl));
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

    public void setTitleTextColorRes(@ColorRes int resId) {
        navigationBar.setTitleTextColorRes(resId);
    }

    public void setTitleTextColor(int color) {
        navigationBar.setTitleTextColor(color);
    }

    public void setTitleTextStyle(int typefaceStyle) {
        navigationBar.setTitleTextStyle(typefaceStyle);
    }

    public void setTitleTextSize(float size) {
        navigationBar.setTitleTextSize(size);
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

    /**
     * Set navigation back btn click listener
     *
     * @param listener click listener of navigation back btn
     */
    public void setLeftOnClickListener(View.OnClickListener listener) {
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

    public void setLeftView(@DrawableRes int resId) {
        navigationBar.setLeftBackImage(resId);
    }

    /**
     * Set right view for the navigation bar
     *
     * @param v view of right
     */
    public void setRightView(View v) {
        navigationBar.setRightView(v);
    }

    public void setTitleView(View v) {
        navigationBar.setTitleView(v);
    }

    public void setLeftView(View v) {
        navigationBar.setLeftView(v);
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
     * Set right text for the navigation bar instand of an icon
     *
     * @param resId the string resource id of the text to be show at right
     */
    public void setRightText(@StringRes int resId) {
        navigationBar.setRightText(resId);
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
        navigationBackground.setBackgroundDrawable(ResourcesUtil.getDrawable(resId));
    }

    /**
     * Set background of the navigation bar using color resource id
     *
     * @param resId color resource for the navigation bar background
     */
//    public void setNavigationBarBackgroundColor(@ColorRes int resId) {
//        navigationBackground.setBackgroundColor(ResourcesUtil.getColor(resId));
//    }

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

    //没有动画效果
    public void hideToolbar() {
        navigationBarContainer.setVisibility(View.GONE);
        contentView.setPadding(0, 0, 0, 0);
    }

    //没有动画效果
    public void showToolbar() {
        navigationBarContainer.setVisibility(View.VISIBLE);
        int dimens = ResourcesUtil.getDimenPxSize(R.dimen.action_bar_height);
        contentView.setPadding(0, dimens, 0, 0);
    }

    public void setNavigationBarWhite() {
        setNavigationBarBackground(R.drawable.navigation_bar_white_with_divider);
        setTitleTextColorRes(R.color.white_navigation_bar_title_color);
    }
}