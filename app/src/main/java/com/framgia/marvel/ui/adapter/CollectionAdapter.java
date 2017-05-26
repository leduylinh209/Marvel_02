package com.framgia.marvel.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.framgia.marvel.R;
import com.framgia.marvel.data.model.Result;
import com.framgia.marvel.data.value.Const;
import com.framgia.marvel.ui.activity.ComicActivity;
import com.framgia.marvel.ui.activity.DisplayImageActivity;
import com.framgia.marvel.ui.activity.InformationActivity;

import java.util.List;

/**
 * Created by Bruce Wayne on 5/22/2017.
 */
public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.ViewHolder> {
    private Context mContext;
    private List<Result> mResults;

    public CollectionAdapter(Context context,
                             List<Result> results) {
        this.mContext = context;
        this.mResults = results;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater
            .from(parent.getContext()).inflate(R.layout.book_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Result item = mResults.get(position);
        holder.bindData(item);
    }

    @Override
    public int getItemCount() {
        return mResults != null ? mResults.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageBookAvatar;
        private TextView mTextBookTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageBookAvatar = (ImageView) itemView.findViewById(R.id.image_book_avatar);
            mTextBookTitle = (TextView) itemView.findViewById(R.id.text_book_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Result hero = mResults.get(getAdapterPosition());
                    hero.setAvatar(hero.getThumbnail().getPath() + Const.Size.SIZE_DETAIL +
                        hero.getThumbnail().getExtension());
                    mContext.startActivity(ComicActivity.getInstance(mContext, hero));
                }
            });
        }

        public void bindData(Result item) {
            if (item == null) return;
            String avatarUrl = item.getThumbnail() != null ? item.getThumbnail().getPath() +
                Const.Size.SIZE_MEDIUM +
                item.getThumbnail().getExtension() : null;
            Glide.with(mContext).load(avatarUrl).error(R.drawable.no_image).into(mImageBookAvatar);
            mTextBookTitle.setText(item.getTitle());
        }
    }
}
