package com.ansh.picArts.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;


/**
 * @author Jeevan Gupta
 */
public class Utils {


    public static void CopyStream(InputStream is, OutputStream os) {
        final int buffer_size = 1024;
        try {
            byte[] bytes = new byte[buffer_size];
            for (; ; ) {
                int count = is.read(bytes, 0, buffer_size);
                if (count == -1)
                    break;
                os.write(bytes, 0, count);
            }
        } catch (Exception ex) {
            System.out.println(Arrays.toString(ex.getStackTrace()));
        }
    }


    public static final String path = Environment.getExternalStorageDirectory() + File.separator + "Notes" + File.separator;
    public static long value(String string) {
        string = string.trim();
        if (string.contains(".")) {
            final int index = string.lastIndexOf(".");
            //  Log.d("if-->",""+value( string.substring( 0, index )));
            return value(string.substring(0, index)) * 100 + value(string.substring(index + 1));
        } else {
            //   Log.d("else-->",""+Long.valueOf( string ));
            return Long.valueOf(string);
        }
    }

    @SuppressWarnings("deprecation")
    public static void clearCookies(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            CookieManager.getInstance().removeAllCookies(null);
            CookieManager.getInstance().flush();
        } else {
            CookieSyncManager cookieSyncMngr = CookieSyncManager.createInstance(context);
            cookieSyncMngr.startSync();
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.removeAllCookie();
            cookieManager.removeSessionCookie();
            cookieSyncMngr.stopSync();
            cookieSyncMngr.sync();
        }
    }
}