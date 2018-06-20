package com.arsldev.lutluthfi.sigmadialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FeedAdapter.OnItemClickListener<String> {

    private RecyclerView mRecyclerView;
    private FeedAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler_feed);

        mAdapter = new FeedAdapter();
        mAdapter.setOnClickListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.setSmoothScrollbarEnabled(true);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(layoutManager);
        ((SimpleItemAnimator) mRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        mRecyclerView.setAdapter(mAdapter);

        List<String> feeds = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            feeds.add("Feed " + i);
        }
        mAdapter.setItems(feeds);
    }

    @Override
    public void onItemClickListener(View view, String item, int position) {
        if (position % 2 == 0) {
            InformationDialog.newInstance(this)
                    .setTitle("Title of information dialog")
                    .setSubTitle("Subtitle of information dialog")
                    .build();
        } else {
            ConfirmDialog.newInstance(this)
                    .setTitle("Title of confirm dialog")
                    .setSubTitle("Subtitle of confirm dialog")
                    .build();
        }
    }
}
