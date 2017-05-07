package com.phd91.m_nurse.module.splash.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;

import com.phd91.m_nurse.R;
import com.phd91.m_nurse.module.splash.presenter.SplashPresenter;

import main.base.baseActivity.BaseBlankActivity;

public class SplashActivity extends BaseBlankActivity<SplashPresenter> {
    private Button mBtnUseNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRealContentView(R.layout.activity_splash);
        initContentView();
        initListener();






    }

    private void initContentView() {
        mBtnUseNow = (Button) findViewById(R.id.btn_splash_use_now);
    }

    private void initListener() {
        mBtnUseNow.setOnClickListener(presenter);
    }

    @Override
    protected void initPresenter() {
        presenter = new SplashPresenter(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        PackageManager pm = getPackageManager();
        ResolveInfo homeInfo = pm.resolveActivity(new Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_HOME), 0);
        //点启动页只能回到桌面，不让退出
        ActivityInfo ai = homeInfo.activityInfo;
        Intent startIntent = new Intent(Intent.ACTION_MAIN);
        startIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        startIntent.setComponent(new ComponentName(ai.packageName, ai.name));
        startActivity(startIntent);
    }
}
