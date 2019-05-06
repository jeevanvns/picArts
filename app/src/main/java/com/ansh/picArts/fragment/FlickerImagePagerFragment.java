
package com.ansh.picArts.fragment;

import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.SharedElementCallback;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.ansh.picArts.R;
import com.ansh.picArts.activity.MainActivity;
import com.ansh.picArts.adapter.FlickerImagePagerAdapter;
import com.ansh.picArts.resource.response.FlickerImageResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class FlickerImagePagerFragment extends Fragment {

    private ViewPager viewPager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ArrayList<FlickerImageResponse.PhotosBean.PhotoBean> mData = Objects.requireNonNull(getArguments()).getParcelableArrayList("DATA");
        viewPager = (ViewPager) inflater.inflate(R.layout.fragment_pager, container, false);
        viewPager.setAdapter(new FlickerImagePagerAdapter(this,mData));
        viewPager.setCurrentItem(MainActivity.currentPosition);
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                MainActivity.currentPosition = position;
            }
        });

        prepareSharedElementTransition();
        if (savedInstanceState == null) {
            postponeEnterTransition();
        }

        return viewPager;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.action_search).setVisible(false);
        menu.findItem(R.id.menu_gird_item_2).setVisible(false);
        menu.findItem(R.id.menu_gird_item_3).setVisible(false);
        menu.findItem(R.id.menu_gird_item_4).setVisible(false);
    }

    private void prepareSharedElementTransition() {
        Transition transition = TransitionInflater.from(getContext())
                        .inflateTransition(R.transition.image_shared_element_transition);
        setSharedElementEnterTransition(transition);

        setEnterSharedElementCallback(
                new SharedElementCallback() {
                    @Override
                    public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
                        Fragment currentFragment = (Fragment) Objects.requireNonNull(viewPager.getAdapter()).instantiateItem(viewPager, MainActivity.currentPosition);
                        View view = currentFragment.getView();
                        if (view == null) {
                            return;
                        }
                        sharedElements.put(names.get(0), view.findViewById(R.id.image));
                    }
                });
    }
}
