package com.phd91.m_nurse.module.mainPage.activity;

import android.os.Bundle;
import android.widget.Button;

import com.phd91.m_nurse.R;
import com.phd91.m_nurse.module.mainPage.presenter.MainPagePresenter;

import main.base.baseActivity.BaseBlankActivity;

public class MainPageActivity extends BaseBlankActivity<MainPagePresenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRealContentView(R.layout.activity_main_page);
        Button button = (Button)findViewById(R.id.btn_web_test);
        button.setOnClickListener(presenter);
        Button button2 = (Button)findViewById(R.id.btn_web_test2);
        button2.setOnClickListener(presenter);
    }

    @Override
    protected void initPresenter() {
        presenter = new MainPagePresenter(this);
    }
}
