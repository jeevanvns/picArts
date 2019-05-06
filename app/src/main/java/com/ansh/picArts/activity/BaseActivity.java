package com.ansh.picArts.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;


import com.ansh.picArts.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = BaseActivity.class.getSimpleName();
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        init();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }

    protected void initToolbar(boolean status) {
        if (status && getSupportActionBar() != null) {
            ActionBar actionBar = getSupportActionBar();
            View actionView = getCustomActionBar();
            if (actionView == null) {
                actionBar.setDisplayHomeAsUpEnabled(showNavigationIcon());
                actionBar.setTitle(setToolbarName());
            } else {
                ActionBar.LayoutParams layout = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,
                        ActionBar.LayoutParams.MATCH_PARENT);
                actionBar.setDisplayHomeAsUpEnabled(false);
                actionBar.setDisplayShowCustomEnabled(true);
                actionBar.setDisplayShowTitleEnabled(false);
                actionBar.setCustomView(actionView, layout);
            }
        }
    }

    protected View getCustomActionBar() {
        return null;
    }

    public boolean showToolbar() {
        return false;
    }

    public void init() {
        initToolbar(showToolbar());
        initView();
        initListener();
        bindDataWithUi();
    }

    protected abstract
    @LayoutRes
    int getLayoutId();

    protected abstract void initView();

    protected abstract void initListener();

    protected abstract void bindDataWithUi();

 /*   public void initCustomToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setTitle(setToolbarName());
            toolbar.setTitleTextColor(Color.WHITE);
            if (showNavigationIcon()) {
                toolbar.setNavigationIcon(ContextCompat.getDrawable(this, setBackIcon()));
            } else {
                toolbar.setNavigationIcon(null);
            }
        }
    }*/

    public boolean showNavigationIcon() {
        return true;
    }

    public int setBackIcon() {
        return R.drawable.ic_back;
    }

    /**
     * show Progress Dialog
     */
    public void showLoadingDialog() {

        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this, R.style.DialogTheme);
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
            mProgressDialog.setContentView(R.layout.dialog_progress);
        }
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    /**
     * @return boolean value
     * return true if Progress Dialog show else return false
     */
    public boolean isShowingProgressDialog() {
        return !(mProgressDialog == null) && mProgressDialog.isShowing();
    }

    /***
     * hide the Progress Dialog
     */
    public void hideLoadingDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    public boolean isDestroyingActivity() {
        return isFinishing() || isDestroyed();
    }


    public void hideSoftInputKeyboard() {
        View view = this.getCurrentFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (view != null && imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) BaseActivity.this.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return false;
    }

    public void addFragment(Fragment fragment, int containerId) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(containerId, fragment)
                .commitAllowingStateLoss();
    }

    public void replaceFragment(Fragment fragment, int containerId, boolean addToBackStack) {
        FragmentTransaction replace = getSupportFragmentManager().beginTransaction()
                .replace(containerId, fragment);
        if (addToBackStack) {
            replace.addToBackStack(fragment.getClass().getName());
        }
        replace.commitAllowingStateLoss();
    }

    public String setToolbarName() {
        return "";
    }

  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    public SpannableStringBuilder changeTitleColor(String title) {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.BLACK);
        SpannableStringBuilder ssBuilder = new SpannableStringBuilder(title);
        ssBuilder.setSpan(foregroundColorSpan, 0, title.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssBuilder;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        onBaseActivityResult(requestCode, resultCode, data);
    }

    protected void onImageResult(File file, String type) {

    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public void onBaseActivityResult(int requestCode, int resultCode, Intent data) {
    }

    public void onBasePermissionResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

    }



    public boolean checkPermission(String[] permission, int permissionCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permission, permissionCode);
            return hasPermission(permission);
        }
        return true;
    }

    public void selfPermission(String[] permission, int permissionCode) {
        if (!hasPermission(permission)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(permission, permissionCode);
            }
        }
    }

    public boolean hasPermission(String[] permission) {
        for (String s : permission) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!hasPermission(s)) return false;
            }
        }
        return true;
    }

    public boolean hasPermission(@NonNull String permission) {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && PackageManager.PERMISSION_GRANTED == checkSelfPermission(permission);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        onBasePermissionResult(requestCode, permissions, grantResults);
    }

    protected void storagePermissionGrant() {
    }


    private boolean checkPermission(String[] permission) {
        for (String s : permission) {
            if (!(ContextCompat.checkSelfPermission(getApplicationContext(), s) == 0)) {
                return false;
            }
        }
        return true;
    }

    public String compressImage(String filePath) {
        Bitmap scaledBitmap = null;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap bmp = BitmapFactory.decodeFile(filePath, options);
        int actualHeight = options.outHeight;
        int actualWidth = options.outWidth;
        float maxHeight = 816.0F;
        float maxWidth = 612.0F;
        float imgRatio = (float) (actualWidth / actualHeight);
        float maxRatio = maxWidth / maxHeight;
        if ((float) actualHeight > maxHeight || (float) actualWidth > maxWidth) {
            if (imgRatio < maxRatio) {
                imgRatio = maxHeight / (float) actualHeight;
                actualWidth = (int) (imgRatio * (float) actualWidth);
                actualHeight = (int) maxHeight;
            } else if (imgRatio > maxRatio) {
                imgRatio = maxWidth / (float) actualWidth;
                actualHeight = (int) (imgRatio * (float) actualHeight);
                actualWidth = (int) maxWidth;
            } else {
                actualHeight = (int) maxHeight;
                actualWidth = (int) maxWidth;
            }
        }

        options.inSampleSize = this.calculateInSampleSize(options, actualWidth, actualHeight);
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inTempStorage = new byte[16384];

        try {
            bmp = BitmapFactory.decodeFile(filePath, options);
        } catch (OutOfMemoryError var23) {
            var23.printStackTrace();
        }

        try {
            scaledBitmap = Bitmap.createBitmap(actualWidth, actualHeight, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError var22) {
            var22.printStackTrace();
        }

        float ratioX = (float) actualWidth / (float) options.outWidth;
        float ratioY = (float) actualHeight / (float) options.outHeight;
        float middleX = (float) actualWidth / 2.0F;
        float middleY = (float) actualHeight / 2.0F;
        Matrix scaleMatrix = new Matrix();
        scaleMatrix.setScale(ratioX, ratioY, middleX, middleY);
        Canvas canvas = new Canvas(scaledBitmap);
        canvas.setMatrix(scaleMatrix);
        canvas.drawBitmap(bmp, middleX - (float) (bmp.getWidth() / 2), middleY - (float) (bmp.getHeight() / 2), new Paint(2));

        try {
            ExifInterface exif = new ExifInterface(filePath);
            int orientation = exif.getAttributeInt("Orientation", 0);
            Log.d("EXIF", "Exif: " + orientation);
            Matrix matrix = new Matrix();
            if (orientation == 6) {
                matrix.postRotate(90.0F);
                Log.d("EXIF", "Exif: " + orientation);
            } else if (orientation == 3) {
                matrix.postRotate(180.0F);
                Log.d("EXIF", "Exif: " + orientation);
            } else if (orientation == 8) {
                matrix.postRotate(270.0F);
                Log.d("EXIF", "Exif: " + orientation);
            }

            scaledBitmap = Bitmap.createBitmap(scaledBitmap, 0, 0, scaledBitmap.getWidth(), scaledBitmap.getHeight(), matrix, true);
        } catch (IOException var21) {
            var21.printStackTrace();
        }

        FileOutputStream out = null;

        try {
            out = new FileOutputStream(filePath);
            scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 40, out);
        } catch (FileNotFoundException var20) {
            var20.printStackTrace();
        }

        return filePath;
    }

    public int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int height = options.outHeight;
        int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            int heightRatio = Math.round((float) height / (float) reqHeight);
            int widthRatio = Math.round((float) width / (float) reqWidth);
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }

        float totalPixels = (float) (width * height);

        for (float totalReqPixelsCap = (float) (reqWidth * reqHeight * 2); totalPixels / (float) (inSampleSize * inSampleSize) > totalReqPixelsCap; ++inSampleSize) {
        }

        return inSampleSize;
    }




    public SpannableString setSpan(String text, String boldText) {
        SpannableString ss1 = new SpannableString(text);
        ss1.setSpan(new RelativeSizeSpan(1f), 0, boldText.length(), 0); // set size
        ss1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorPrimary)), 0, boldText.length(), 0);
        return ss1;
    }
}