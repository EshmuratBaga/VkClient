package project.baga.vk.com.vkclient.ui.news;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import project.baga.vk.com.vkclient.CurrentUser;
import project.baga.vk.com.vkclient.MyApplication;
import project.baga.vk.com.vkclient.R;
import project.baga.vk.com.vkclient.common.BaseAdapter;
import project.baga.vk.com.vkclient.model.WallItem;
import project.baga.vk.com.vkclient.model.view.NewsFeedItemBodyViewModel;
import project.baga.vk.com.vkclient.rest.api.WallApi;
import project.baga.vk.com.vkclient.rest.model.request.WallGetRequestModel;
import project.baga.vk.com.vkclient.rest.model.response.BaseItemResponse;
import project.baga.vk.com.vkclient.rest.model.response.Full;
import project.baga.vk.com.vkclient.rest.model.response.WallGetResponse;
import project.baga.vk.com.vkclient.ui.BaseFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFeedFragment extends BaseFragment {

    @Inject
    WallApi wallApi;

    RecyclerView recyclerView;

    BaseAdapter baseAdapter;

    public NewsFeedFragment() {
        // Required empty public constructor
    }

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getApplicationComponent().inject(this);
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpRecyclerView(view);
        setUpAdapter(recyclerView);
    }

    @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        wallApi.get(new WallGetRequestModel(-86529522).toMap()).enqueue(new Callback<WallGetResponse>() {
            @Override
            public void onResponse(Call<WallGetResponse> call, Response<WallGetResponse> response) {

                List<NewsFeedItemBodyViewModel> list = new ArrayList<NewsFeedItemBodyViewModel>();
                for (WallItem item : response.body().response.getItems()) {
                    list.add(new NewsFeedItemBodyViewModel(item));
                }

                baseAdapter.addItems(list);
                Toast.makeText(getActivity(), "Likes: " + response.body().response.getItems().get(0).getLikes().getCount(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<WallGetResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override protected int getMainContentLayout() {
        return R.layout.fragment_news_feed;
    }

    @Override public int onCreateToolbarTitle() {
        return R.string.title_news;
    }

    private void setUpRecyclerView(View view){
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setUpAdapter(RecyclerView recyclerView){
        baseAdapter = new BaseAdapter();

        recyclerView.setAdapter(baseAdapter);
    }

}
