package com.ansh.picArts.adapter;

import android.os.Bundle;
import android.transition.TransitionSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.ansh.PicsArtsApps;
import com.ansh.picArts.R;
import com.ansh.picArts.activity.MainActivity;
import com.ansh.picArts.adapter.FlickerImageAdapter.ImageViewHolder;
import com.ansh.picArts.fragment.FlickerImagePagerFragment;
import com.ansh.picArts.imageCache.ImageLoader;
import com.ansh.picArts.resource.response.FlickerImageResponse;
import com.ansh.picArts.utils.AppConstant;
import com.ansh.picArts.utils.FlickerUtils;
import com.ansh.picArts.utils.PreferencesUtils;
import com.ansh.picArts.utils.ScreenUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class FlickerImageAdapter extends RecyclerView.Adapter<ImageViewHolder> {

    private Fragment fragment;
    private static int columnCount = 2;
    public static ArrayList<FlickerImageResponse.PhotosBean.PhotoBean> mData = new ArrayList<>();

    public void setColumnCount(int i) {
        columnCount = i;
    }

    public void setData(ArrayList<FlickerImageResponse.PhotosBean.PhotoBean> photo, boolean isNewSearch) {
        if (isNewSearch) {
            mData.clear();
            mData.addAll(photo);
        } else {
            mData.addAll(photo);
        }
        notifyDataSetChanged();
    }


    private interface ViewHolderListener {

        void onLoadCompleted(ImageView view, int adapterPosition);

        void onItemClicked(View view, int adapterPosition);
    }

    private final RequestManager requestManager;
    private final ViewHolderListener viewHolderListener;


    public FlickerImageAdapter(Fragment fragment) {
        this.requestManager = Glide.with(fragment);
        this.fragment = fragment;
        this.viewHolderListener = new ViewHolderListenerImpl(fragment);
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_card, parent, false);
        return new ImageViewHolder(view, requestManager, viewHolderListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        int width = getWidth(columnCount);
        int height = getHeight(columnCount);

        ViewGroup.LayoutParams layoutParams = holder.cvCard.getLayoutParams();
        layoutParams.height = height;
        layoutParams.width = width;
        holder.cvCard.setLayoutParams(layoutParams);
        holder.onBind();
    }


    public static int getHeight(int columnCount) {
        int width = getWidth(columnCount);
        return width - width / 3;
    }

    public static int getWidth(int columnCount) {
        float v = PicsArtsApps.getContext().getResources().getDimension(R.dimen._10sdp) * columnCount + 10;
        int screenWidth = (int) (ScreenUtils.getScreenWidth(PicsArtsApps.getContext()) - v);
        return screenWidth / columnCount;

    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }


    private static class ViewHolderListenerImpl implements ViewHolderListener {

        private Fragment fragment;
        private AtomicBoolean enterTransitionStarted;

        ViewHolderListenerImpl(Fragment fragment) {
            this.fragment = fragment;
            this.enterTransitionStarted = new AtomicBoolean();
        }

        @Override
        public void onLoadCompleted(ImageView view, int position) {
            if (MainActivity.currentPosition != position) {
                return;
            }
            if (enterTransitionStarted.getAndSet(true)) {
                return;
            }
            fragment.startPostponedEnterTransition();
        }


        @Override
        public void onItemClicked(View view, int position) {
            MainActivity.currentPosition = position;
            ((TransitionSet) Objects.requireNonNull(fragment.getExitTransition())).excludeTarget(view, true);

            ImageView transitioningView = view.findViewById(R.id.card_image);
            FlickerImagePagerFragment imagePagerFragment = new FlickerImagePagerFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("DATA", mData);
            imagePagerFragment.setArguments(bundle);
            if (fragment.getFragmentManager() != null) {
                fragment.getFragmentManager()
                        .beginTransaction()
                        .setReorderingAllowed(true)
                        .addSharedElement(transitioningView, transitioningView.getTransitionName())
                        .replace(R.id.fragment_container, imagePagerFragment, FlickerImagePagerFragment.class
                                .getSimpleName())
                        .addToBackStack(null)
                        .commit();
            }
        }
    }


    static class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView image;
        private RequestManager requestManager;
        private ViewHolderListener viewHolderListener;
        private CardView cvCard;

        ImageViewHolder(View itemView, RequestManager requestManager, ViewHolderListener viewHolderListener) {
            super(itemView);
            cvCard = itemView.findViewById(R.id.card_view);
            this.image = itemView.findViewById(R.id.card_image);
            this.requestManager = requestManager;
            this.viewHolderListener = viewHolderListener;
            itemView.findViewById(R.id.card_view).setOnClickListener(this);
        }


        void onBind() {
            int adapterPosition = getAdapterPosition();
            String url = FlickerUtils.getUrl(mData.get(adapterPosition));
            setImage(adapterPosition, url);
            image.setTransitionName(url);
        }

        void setImage(final int adapterPosition, String url) {
            if (PreferencesUtils.getInteger(AppConstant.CACHE_TYPE) == AppConstant.CACHE_CUSTOM) {
                ImageLoader imageLoader = new ImageLoader(image.getContext(), ".picArts");
                imageLoader.DisplayImage(url, image);
                viewHolderListener.onLoadCompleted(image, adapterPosition);
            } else {
                Picasso.get()
                        .load(url)
                        .placeholder(R.drawable.ani_loader)
                        .error(R.drawable.no_image)
                        .centerCrop()
                        .resize(getWidth(columnCount), getHeight(columnCount))
                        .into(image, new Callback() {
                            @Override
                            public void onSuccess() {
                                viewHolderListener.onLoadCompleted(image, adapterPosition);
                            }

                            @Override
                            public void onError(Exception e) {
                                viewHolderListener.onLoadCompleted(image, adapterPosition);
                            }
                        });
            }
        }

        @Override
        public void onClick(View view) {
            viewHolderListener.onItemClicked(view, getAdapterPosition());
        }
    }

}