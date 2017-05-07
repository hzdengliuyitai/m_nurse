package main.application;

import android.content.Context;
import android.os.Process;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/3/12.
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static CrashHandler sInstance = new CrashHandler();
    private Thread.UncaughtExceptionHandler mDefaultCrashHandler;
    private Context mContext;

    private CrashHandler() {
    }

    public static CrashHandler getInstance() {
        return sInstance;
    }

    public void init(Context context) {
        mDefaultCrashHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        mContext = context.getApplicationContext();
    }


    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        Toast.makeText(mContext, "出现异常，系统即将退出", Toast.LENGTH_SHORT).show();
        throwable.printStackTrace();
        if (mDefaultCrashHandler != null) {
            mDefaultCrashHandler.uncaughtException(thread, throwable);
        } else {
            Process.killProcess(Process.myPid());
        }
    }
}
