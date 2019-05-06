
package com.ansh.picArts.fragment;

import android.Manifest;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.SharedElementCallback;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ansh.picArts.R;
import com.ansh.picArts.activity.BaseActivity;
import com.ansh.picArts.activity.MainActivity;
import com.ansh.picArts.adapter.FlickerImageAdapter;
import com.ansh.picArts.enums.flicker.FApiType;
import com.ansh.picArts.enums.flicker.FContentType;
import com.ansh.picArts.enums.flicker.FEmptyJSON;
import com.ansh.picArts.enums.flicker.FPrivacyFilter;
import com.ansh.picArts.enums.flicker.FResponseFormat;
import com.ansh.picArts.enums.flicker.FSearchTYPE;
import com.ansh.picArts.resource.request.FlickerSearchRequest;
import com.ansh.picArts.resource.response.FlickerImageResponse;
import com.ansh.picArts.resource.service.FlickerImageService;
import com.ansh.picArts.utils.AppConstant;
import com.ansh.picArts.utils.EndlessRecyclerViewScrollListener;
import com.ansh.picArts.utils.PreferencesUtils;
import com.ansh.picArts.web.ApiCallback;
import com.ansh.picArts.web.ApiException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

public class HomeGridFragment extends Fragment {

    private RecyclerView rvImageList;
    private GridLayoutManager gridLayoutManager;
    private FlickerImageAdapter gridAdapter;
    private String keyword = "nature";
    private int counter = 1;
    private boolean isItemClick = false;
    private static int itemCount = 2;
    private static ArrayList<FlickerImageResponse.PhotosBean.PhotoBean> mData = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rvImageList = (RecyclerView) inflater.inflate(R.layout.fragment_grid, container, false);
        gridAdapter = new FlickerImageAdapter(this);
        bindRecyclerView(itemCount);
        prepareTransitions();
        postponeEnterTransition();


        if (!isItemClick) {
            searchImage(keyword, counter, true);
            isItemClick = true;
        }

        return rvImageList;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        scrollToPosition();
    }

    private void scrollToPosition() {
        rvImageList.addOnLayoutChangeListener(new OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v,
                                       int left,
                                       int top,
                                       int right,
                                       int bottom,
                                       int oldLeft,
                                       int oldTop,
                                       int oldRight,
                                       int oldBottom) {
                rvImageList.removeOnLayoutChangeListener(this);
                View viewAtPosition = gridLayoutManager.findViewByPosition(MainActivity.currentPosition);
                if (viewAtPosition == null || gridLayoutManager
                        .isViewPartiallyVisible(viewAtPosition, false, true)) {
                    rvImageList.post(() -> gridLayoutManager.scrollToPosition(MainActivity.currentPosition));
                }
            }
        });
    }

    private void prepareTransitions() {
        setExitTransition(TransitionInflater.from(getContext())
                .inflateTransition(R.transition.grid_exit_transition));
        setExitSharedElementCallback(
                new SharedElementCallback() {
                    @Override
                    public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
                        RecyclerView.ViewHolder selectedViewHolder = rvImageList
                                .findViewHolderForAdapterPosition(MainActivity.currentPosition);
                        if (selectedViewHolder == null) {
                            return;
                        }
                        sharedElements.put(names.get(0), selectedViewHolder.itemView.findViewById(R.id.card_image));
                    }
                });
    }


    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.action_search).setVisible(true);
        menu.findItem(R.id.menu_gird_item_2).setVisible(true);
        menu.findItem(R.id.menu_gird_item_3).setVisible(true);
        menu.findItem(R.id.menu_gird_item_4).setVisible(true);
        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                keyword = query;
                searchImage(keyword, counter, true);
                if (!searchView.isIconified()) {
                    searchView.setIconified(true);
                }
                myActionMenuItem.collapseActionView();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_gird_item_2:
                itemCount = 2;
                bindRecyclerView(itemCount);
                break;
            case R.id.menu_gird_item_3:
                itemCount = 3;
                bindRecyclerView(itemCount);
                break;
            case R.id.menu_gird_item_4:
                itemCount = 4;
                bindRecyclerView(itemCount);
                break;
            case R.id.menu_picasso:
                PreferencesUtils.putInteger(AppConstant.CACHE_TYPE, AppConstant.CACHE_PICASSO);
                Toast.makeText(getContext(), "Reopen the app for check Picasso Cache", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_custom_cache:
                if (((BaseActivity) getActivity()).isWritePermission()) {
                    PreferencesUtils.putInteger(AppConstant.CACHE_TYPE, AppConstant.CACHE_CUSTOM);
                    Toast.makeText(getContext(), "Reopen the app for check Custom Cache", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Write External Storage permission not granted", Toast.LENGTH_SHORT).show();
                    ((BaseActivity) getActivity()).selfPermission(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);

                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * Bind RecyclerView Layout Manger Dynamic based on column count
     * @param i
     * @link bindRecyclerView
     */
    private void bindRecyclerView(int i) {
        gridLayoutManager = new GridLayoutManager(getContext(), i);
        rvImageList.setLayoutManager(gridLayoutManager);
        gridAdapter.setColumnCount(i);
        rvImageList.setAdapter(gridAdapter);
        initListener();
    }

    private void initListener() {
        rvImageList.setOnScrollListener(new EndlessRecyclerViewScrollListener(gridLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                if (!TextUtils.isEmpty(keyword))
                    searchImage(keyword, counter, false);
            }
        });
    }


    private void searchImage(String keyword, int page, boolean isNewSearch) {
        FlickerSearchRequest searchRequest = new FlickerSearchRequest();
        //  searchRequest.setFullUrl("/services/rest/?method=flickr.photos.search&api_key=30a4b55f9bed0446e6c492b5bf88123c&format=json&nojsoncallback=1&safe_search=1&text=" + keyword + "&content_type=1&page=" + page + "&per_page=100&privacy_filter=1");
        searchRequest.setKeyword(keyword);
        searchRequest.setApiType(FApiType.SEARCH);
        searchRequest.setApiKey(AppConstant.FLICKER_API_KEY);
        searchRequest.setPageNo(page);
        searchRequest.setPerPageItem(AppConstant.DEFAULT_SEARCH_ITEM_SIZE);
        searchRequest.setResponseFormat(FResponseFormat.JSON);
        searchRequest.setEmptyJSON(FEmptyJSON.EMPTY_JSON_ALLOW);
        searchRequest.setSearchTYPE(FSearchTYPE.SAFE);
        searchRequest.setContentType(FContentType.PHOTO);
        searchRequest.setPrivacyFilter(FPrivacyFilter.PUBLIC);

        new FlickerImageService(getContext()).execute(searchRequest, new ApiCallback<FlickerImageResponse>() {
            @Override
            public void onSuccess(Call<FlickerImageResponse> call, FlickerImageResponse response) {
                if (response.getStat().equalsIgnoreCase("ok") && response.getPhotos() != null && response.getPhotos().getPhoto() != null) {
                    mData.addAll(response.getPhotos().getPhoto());
                    counter++;
                    gridAdapter.setData(response.getPhotos().getPhoto(), isNewSearch);
                    if (isNewSearch) scrollToPosition();
                } else {
                    Toast.makeText(getActivity(), response.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onComplete() {
            }

            @Override
            public void onFailure(ApiException e) {
                Toast.makeText(getContext(), isNetworkAvailable() ? "Api Error" : "No Internet Available", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private boolean isNetworkAvailable() {
        if (getActivity() == null) return false;
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return false;
    }
}
