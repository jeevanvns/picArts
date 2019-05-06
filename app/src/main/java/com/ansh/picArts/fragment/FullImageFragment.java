
package com.ansh.picArts.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ansh.picArts.R;
import com.ansh.picArts.imageCache.ImageLoader;
import com.ansh.picArts.utils.AppConstant;
import com.ansh.picArts.utils.PreferencesUtils;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class FullImageFragment extends Fragment {


    public static FullImageFragment newInstance(String bean) {
        FullImageFragment fragment = new FullImageFragment();
        Bundle argument = new Bundle();
        argument.putString(AppConstant.KEY_IMAGE_RES, bean);
        fragment.setArguments(argument);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        Bundle arguments = getArguments();
        String url = Objects.requireNonNull(arguments).getString(AppConstant.KEY_IMAGE_RES, null);
        view.findViewById(R.id.image).setTransitionName(url);
        ImageView image = (ImageView) view.findViewById(R.id.image);
        if (PreferencesUtils.getInteger(AppConstant.CACHE_TYPE) == AppConstant.CACHE_CUSTOM) {
            ImageLoader imageLoader = new ImageLoader(image.getContext(), ".picArts");
            imageLoader.DisplayImage(url, image);
            if (getParentFragment() != null)
                getParentFragment().startPostponedEnterTransition();
        } else {
            Picasso.get()
                    .load(url)
                    .placeholder(R.drawable.no_image)
                    .error(R.drawable.no_image)
                    .into(image, new Callback() {
                        @Override
                        public void onSuccess() {
                            if (getParentFragment() != null)
                                getParentFragment().startPostponedEnterTransition();
                        }

                        @Override
                        public void onError(Exception e) {
                            if (getParentFragment() != null)
                                getParentFragment().startPostponedEnterTransition();
                        }
                    });
        }
        return view;
    }


}
