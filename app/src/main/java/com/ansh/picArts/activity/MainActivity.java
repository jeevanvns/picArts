package com.ansh.picArts.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import com.ansh.picArts.R;
import com.ansh.picArts.fragment.HomeGridFragment;
import com.ansh.picArts.utils.AppConstant;

public class MainActivity extends BaseActivity {
    public static int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            currentPosition = savedInstanceState.getInt(AppConstant.KEY_CURRENT_POSITION, 0);
            return;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, new HomeGridFragment(), HomeGridFragment.class.getSimpleName())
                .commit();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void initView() {

    }

    @Override
    public boolean showToolbar() {
        return true;
    }

    @Override
    public boolean showNavigationIcon() {
        return false;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void bindDataWithUi() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.home_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(AppConstant.KEY_CURRENT_POSITION, currentPosition);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
