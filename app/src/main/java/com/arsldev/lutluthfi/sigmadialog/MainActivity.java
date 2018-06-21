package com.arsldev.lutluthfi.sigmadialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FeedAdapter.OnItemClickListener<String>,
        SigmaDialog.InformationDialogListener {

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
        Toast.makeText(this, "OnItemClick: " + item, Toast.LENGTH_SHORT).show();
        Bundle bundle = new Bundle();
        bundle.putString("BUNDLE_FEED", item);
        InformationDialog.newInstance(this)
                .setTitle("Title of information dialog")
                .setSubTitle("Subtitle of information dialog")
                .setBundle(bundle)
                .build()
                .show(getSupportFragmentManager(), InformationDialog.TAG);
    }

    @Override
    public void onConfirmed(Bundle bundle) {
        String feed = bundle.getString("BUNDLE_FEED");
        Toast.makeText(this, "onConfirmed: " + feed, Toast.LENGTH_SHORT).show();
    }
}
