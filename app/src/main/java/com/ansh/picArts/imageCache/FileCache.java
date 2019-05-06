package com.ansh.picArts.imageCache;


import android.content.Context;
import android.util.Log;

import java.io.File;
import java.net.URLEncoder;

/**
 * @author Jeevan Gupta
 */
public class FileCache {

    private File cacheDir;
    private File root;

    public FileCache(Context context, String folder) {
        if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) {
            root = new File(android.os.Environment.getExternalStorageDirectory(), "picArts");
            cacheDir = new File(root, folder);
        } else
            cacheDir = context.getCacheDir();
        if (!cacheDir.exists()) {
            root.mkdirs();
            cacheDir.mkdirs();
        }
    }

    public File getFile(String url) {
        String filename = URLEncoder.encode(url);
        Log.d("URL", filename);
        File f = new File(cacheDir, filename);
        return f;
    }

    private long dirSize() {
        long result = 0;
        File[] fileList = cacheDir.listFiles();
        for (File file : fileList) {
            result += file.length();
        }
        return result; // return the file size
    }

    public void clear() {
        File[] files = cacheDir.listFiles();
        if (files == null)
            return;
        for (File f : files)
            f.delete();
    }
}