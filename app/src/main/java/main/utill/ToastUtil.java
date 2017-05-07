package main.utill;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.phd91.m_nurse.R;

import main.application.AppProfile;


/**
 * Created by ht-template
 **/
public class ToastUtil {
    private static Toast sToast;
    private static Handler sMainThreadHandler;
    private final static int shortDuration = 1500;
    private final static int longDuration = 3000;

    private static Handler getMainThreadHandler() {
        if (sMainThreadHandler == null) {
            synchronized (ToastUtil.class) {
                if (sMainThreadHandler == null) {
                    sMainThreadHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
        return sMainThreadHandler;
    }

    // 显示短提示
    public static void makeShortToast(String content) {
        showToast(AppProfile.getContext(), content, shortDuration);
    }

    // 显示短提示
    public static void makeShortToast(int stringId) {
        showToast(AppProfile.getContext(), stringId, shortDuration);
    }

    // 显示短提示
    public static void makeShortToast(int stringId, Object... objects) {
        String content = ResourcesUtil.stringFormat(stringId, objects);
        showToast(AppProfile.getContext(), content, longDuration);
    }

    // 显示长提示
    public static void makeLongToast(String content) {
        showToast(AppProfile.getContext(), content, longDuration);
    }

    // 显示长提示
    public static void makeLongToast(int stringId) {
        showToast(AppProfile.getContext(), stringId, longDuration);
    }

    // 显示长提示
    public static void makeLongToast(int stringId, Object... objects) {
        String content = ResourcesUtil.stringFormat(stringId, objects);
        showToast(AppProfile.getContext(), content, longDuration);
    }

    private static void showToast(final Context context, final int stringId, final int duration) {
        showToast(context, ResourcesUtil.getString(stringId), duration);
    }

    private static void showToast(final Context context, final String message, final int duration) {
        getMainThreadHandler().post(new Runnable() {
            @Override
            public void run() {
                if (sToast != null) {
                    sToast.cancel();
                }
                Toast lastToast = sToast;
                sToast = Toast.makeText(context, message, duration);
                if (lastToast == null) {
                    View layout = LayoutInflater.from(context).inflate(R.layout.view_toast, null);// 自定义布局
                    sToast.setView(layout);
                } else {
                    sToast.setView(lastToast.getView());
                }
                ((TextView) sToast.getView().findViewById(R.id.toast_text)).setText(message);
                sToast.setGravity(Gravity.CENTER, 0, 0);// 屏幕居中
                sToast.show();
            }
        });
    }
}

