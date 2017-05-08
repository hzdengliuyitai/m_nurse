package com.phd91.m_nurse.module.mainPage.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.widget.ImageView;

import com.phd91.m_nurse.R;
import com.phd91.m_nurse.module.mainPage.presenter.MainPagePresenter;

import main.base.baseActivity.BaseBlankActivity;

public class MainPageActivity extends BaseBlankActivity<MainPagePresenter> {
    private DrawerLayout mDrawerLayout;

    private ImageView mImgDrawerOpen;

    public static void start(Context context) {
        Intent intent = new Intent(context, MainPageActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRealContentView(R.layout.activity_main_page);
    }

    private void initContentView(){
        mDrawerLayout = (DrawerLayout)rootView.findViewById(R.id.drawer_layout);
        mImgDrawerOpen = (ImageView)findViewById(R.id.img_main_drawer);
    }

    private void initListener(){
        mImgDrawerOpen.setOnClickListener(presenter);
    }

    public void openDrawer() {
        mDrawerLayout.openDrawer(GravityCompat.START);
    }

    private void closeDrawer() {
        mDrawerLayout.closeDrawer(GravityCompat.START, true);//不带动画关闭抽屉
    }

    @Override
    protected void initPresenter() {
        presenter = new MainPagePresenter(this);
    }
}
