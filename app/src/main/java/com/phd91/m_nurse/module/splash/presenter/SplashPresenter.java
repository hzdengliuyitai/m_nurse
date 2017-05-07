package com.phd91.m_nurse.module.splash.presenter;

import android.view.View;

import com.phd91.m_nurse.R;
import com.phd91.m_nurse.module.mainPage.activity.MainPageActivity;
import com.phd91.m_nurse.module.splash.activity.SplashActivity;

import main.base.basePresenter.BaseActivityPresenter;

/**
 * Created by Administrator on 2017/5/6.
 */

public class SplashPresenter extends BaseActivityPresenter<SplashActivity> implements View.OnClickListener {
    private static final int WAIT_TIME = 3000;
    private volatile boolean isFinished = false;

    private long mStartTime;

    public SplashPresenter(SplashActivity target) {
        super(target);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_splash_use_now:
                MainPageActivity.start(target);
                break;
        }
    }
}
