package com.appexample.marianosalvetti.com.myappexample.utils;

import android.util.Log;

/**
 * Created by Mariano Salvetti on 12/06/15
 *
 */
public class LoggingUtility {

    public static void e(String tag, String message) {
        if (Constants.DEBUG)
            Log.e(tag, message);
    }

    public static void e(String tag, String message, Throwable throwable) {
        if (Constants.DEBUG)
            Log.e(tag, message, throwable);
    }

    public static void i(String tag, String message) {
        if (Constants.DEBUG)
            Log.i(tag, message);
    }

    public static void d(String tag, String message) {
        if (Constants.DEBUG)
            Log.d(tag, message);
    }

    public static void d(String tag, String message, Throwable throwable) {
        if (Constants.DEBUG)
            Log.d(tag, message, throwable);
    }
}
