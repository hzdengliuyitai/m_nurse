package main.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by hzdengliuyitai on 2016/9/7.
 */
public class HelperApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Context context = getApplicationContext();
        AppProfile.setContext(context);
//        CrashHandler.getInstance().init(context);
        CrashHandlerL.getInstance().init(context);
    }


}
