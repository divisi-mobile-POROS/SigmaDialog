package com.arsldev.lutluthfi.sigmadialog;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static OnItemClickListener sListener;
    private List<String> mItems;

    public FeedAdapter() {
        mItems = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return FeedViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((FeedViewHolder) holder).mItem = mItems.get(position);
        ((FeedViewHolder) holder).onBind();
    }

    @Override
    public int getItemCount() {
        return this.mItems.size();
    }

    public void setOnClickListener(OnItemClickListener listener) {
        sListener = listener;
    }

    public void setItems(List<String> mItems) {
        if (mItems != null) this.mItems = mItems;
        notifyDataSetChanged();
    }

    public String getItem(int position) {
        if (this.mItems != null && this.mItems.size() > position) return this.mItems.get(position);
        else return null;
    }

    public void removeItem(int index) {
        if (this.mItems != null && this.mItems.size() > index) {
            this.mItems.remove(index);
            notifyItemRemoved(index);
            notifyItemChanged(index, this.mItems.size());
        }
    }

    public void clear() {
        if (this.mItems != null) {
            this.mItems.clear();
            notifyDataSetChanged();
        }
    }

    public interface OnItemClickListener<T> {
        void onItemClickListener(View view, T item, int position);
    }

    private static class FeedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mFeedTextView;
        private String mItem;

        private FeedViewHolder(View itemView) {
            super(itemView);
            mFeedTextView = itemView.findViewById(R.id.text_item_feed);
            itemView.setOnClickListener(this);
        }

        @SuppressWarnings("unchecked") @Override
        public void onClick(View view) {
            if (sListener != null) {
                sListener.onItemClickListener(view, mItem, getAdapterPosition());
            }
        }

        private static FeedViewHolder create(ViewGroup parent) {
            return new FeedViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_feed, parent, false));
        }

        private void onBind() {
            mFeedTextView.setText(mItem);
        }
    }
}
