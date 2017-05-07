package com.phd91.m_nurse.module.mainPage.presenter;

import android.view.View;


import com.phd91.m_nurse.module.mainPage.activity.MainPageActivity;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.RawResponseHandler;

import java.util.HashMap;
import java.util.Map;

import main.base.basePresenter.BaseActivityPresenter;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/5/7.
 */

public class MainPagePresenter extends BaseActivityPresenter<MainPageActivity> implements View.OnClickListener {
    RawResponseHandler rawResponseHandler = new RawResponseHandler() {
        @Override
        public void onSuccess(Response response, Request request) {
        }

        @Override
        public void onFailure(int statusCode, String error_msg) {

        }
    };

    public MainPagePresenter(MainPageActivity target) {

        super(target);
    }

    private void test() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", "tsy");

        MyOkHttp.get().get(target, "http://www.baidu.com", params, rawResponseHandler);
    }

    private void test2() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", "tsy");

        MyOkHttp.get().get(target, "http://www.sina.com", params, rawResponseHandler);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {


        }
    }
}
