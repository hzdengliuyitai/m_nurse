package com.phd91.m_nurse.module.splash.presenter;

import android.os.Handler;

import com.phd91.m_nurse.module.splash.activity.SplashActivity;

import main.base.basePresenter.BaseActivityPresenter;

/**
 * Created by Administrator on 2017/5/6.
 */

public class SplashPresenter extends BaseActivityPresenter<SplashActivity> {
    private static final int WAIT_TIME = 3000;
    private volatile boolean isFinished = false;

    private long mStartTime;

    public SplashPresenter(SplashActivity target) {
        super(target);
    }

    public void doNext() {
        mStartTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        long initTime = endTime - mStartTime;
        long delayMillis;

        if (initTime < 0) {
            delayMillis = WAIT_TIME;
        } else if (initTime >= WAIT_TIME) {
            delayMillis = 0;
        } else {
            delayMillis = WAIT_TIME - initTime;
        }

        // x秒后强行关闭
        doDelay(new Runnable() {
            @Override
            public void run() {
                if (!isFinished) {
                    isFinished = !isFinished;

//                    if (SharedpreferenceUtil.getLoginState(target, AppProfile.LOGIN_STATE)) {
////                        MainActivity.start(target);
//                    } else LoginMainActivity.start(target);
////                    LoginMainActivity.start(target);
                    target.finish();
                    //stop的时候默认会取消掉的
//                    cancelRequests();
                }
            }
        }, delayMillis);
    }

    public static void doDelay(Runnable runable, long delayMillis) {
        Handler handler = new Handler();
        handler.postDelayed(runable, delayMillis);
    }
}
