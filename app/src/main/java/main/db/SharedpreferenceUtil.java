package main.db;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by hzdengliuyitai on 2016/8/23.
 */
public class SharedpreferenceUtil {
    public static String appName="ClothesHelper";

    private static SharedPreferences getSharedpreference(Context context){
        SharedPreferences sp = null;
        sp = context.getSharedPreferences(appName,0);
        return sp;
    }

    public static void putString(Context context, String key, String value){
        SharedPreferences.Editor editor = getSharedpreference(context).edit();
        editor.putString(key,value);
        editor.commit();
    }

    public static String getString(Context context, String key){
        String value = getSharedpreference(context).getString(key,null);
        return  value;
    }

    public static void putInt(Context context, String key, int value){
        SharedPreferences.Editor editor = getSharedpreference(context).edit();
        editor.putInt(key,value);
        editor.commit();
    }

    public static int getInt(Context context, String key){
        int value = getSharedpreference(context).getInt(key,0000);
        return value;
    }

    public static void setLoginState(Context context, String key, boolean value){
        SharedPreferences.Editor editor = getSharedpreference(context).edit();
        editor.putBoolean(key,value);
        editor.commit();
    }

    public static boolean getLoginState(Context context, String key){
        boolean state = getSharedpreference(context).getBoolean(key,false);
        return state;
    }

}
