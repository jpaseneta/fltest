package test.freelancer.com.fltest.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loopj.android.http.RequestParams;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import test.freelancer.com.fltest.Adapter.CollectionAdapter;
import test.freelancer.com.fltest.Events.EndlessRecyclerViewScrollListener;
import test.freelancer.com.fltest.Model.HandlerFinished;
import test.freelancer.com.fltest.HttpClient.JsonHttpClient;
import test.freelancer.com.fltest.Events.MyTextHttpResponseHandler;
import test.freelancer.com.fltest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollectionViewFragment extends Fragment {

    private RecyclerView recyclerView;
    private CollectionAdapter adapter;
    private ArrayList<test.freelancer.com.fltest.Model.Programs> Programs = new ArrayList<>();
    private MyTextHttpResponseHandler handler;
    public CollectionViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment'
        final View layout = inflater.inflate(R.layout.fragment_collection_view, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.collection_recyclerview);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        Programs.clear();
        adapter = new CollectionAdapter(getActivity(),Programs);
        recyclerView.setAdapter(adapter);

        handler = new MyTextHttpResponseHandler();
        JsonHttpClient.get("", new RequestParams("start", "0"), handler);

        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(llm) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                JsonHttpClient.get("", new RequestParams("start", String.valueOf(page)), handler);
            }
        });

        return layout;
    }

    @Subscribe
    public void getAllPrograms(HandlerFinished handlerFinished) {

        Programs.addAll(handlerFinished.programList);
        adapter.addItemsToList(handlerFinished.programList);

    }



}
