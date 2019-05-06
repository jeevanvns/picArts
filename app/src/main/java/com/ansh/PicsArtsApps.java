package com.ansh;

import android.app.Application;
import android.content.Context;

public class PicsArtsApps extends Application {

    private static Context mContext;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        mContext = base;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }


    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
