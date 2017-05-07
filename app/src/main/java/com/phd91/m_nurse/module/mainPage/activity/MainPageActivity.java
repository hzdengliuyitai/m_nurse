package com.phd91.m_nurse.module.mainPage.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.phd91.m_nurse.R;
import com.phd91.m_nurse.module.mainPage.presenter.MainPagePresenter;

import main.base.baseActivity.BaseBlankActivity;

public class MainPageActivity extends BaseBlankActivity<MainPagePresenter> {
    public static void start(Context context) {
        Intent intent = new Intent(context, MainPageActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRealContentView(R.layout.activity_main_page);
    }

    @Override
    protected void initPresenter() {
        presenter = new MainPagePresenter(this);
    }
}
