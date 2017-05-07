package com.tsy.sdk.myokhttp.response;

import okhttp3.Request;
import okhttp3.Response;

/**
 * raw 字符串结果回调
 * Created by tsy on 16/8/18.
 */
public abstract class RawResponseHandler implements IResponseHandler {

    public abstract void onSuccess(Response response, Request request);

    @Override
    public void onProgress(long currentBytes, long totalBytes) {

    }
}
