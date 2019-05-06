
package com.ansh.picArts.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.ansh.picArts.fragment.FullImageFragment;
import com.ansh.picArts.resource.response.FlickerImageResponse;
import com.ansh.picArts.utils.FlickerUtils;

import java.util.ArrayList;


public class FlickerImagePagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<FlickerImageResponse.PhotosBean.PhotoBean> mData;

    public FlickerImagePagerAdapter(Fragment fragment, ArrayList<FlickerImageResponse.PhotosBean.PhotoBean> mData) {
        super(fragment.getChildFragmentManager());
        this.mData = mData;
    }


    @Override
    public int getCount() {
        return mData != null ? mData.size() : 0;
    }

    @Override
    public Fragment getItem(int position) {
        return FullImageFragment.newInstance(FlickerUtils.getUrl(mData.get(position)));
    }
}
