package com.framgia.marvel.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.framgia.marvel.R;
import com.framgia.marvel.data.model.Thumbnail;
import com.framgia.marvel.data.value.Const;

/**
 * Created by asus on 5/30/2017.
 */
public class ImageFragment extends Fragment {
    private Thumbnail mImage;
    private ImageView mImageView;

    public ImageFragment() {
    }

    public static ImageFragment newInstance(Thumbnail image) {
        ImageFragment fragment = new ImageFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Const.Bundle.BUNDLE_IMAGE, image);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() == null) return;
        mImage = getArguments().getParcelable(Const.Bundle.BUNDLE_IMAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_fullscreen, container, false);
        mImageView = (ImageView) v.findViewById(R.id.image_full);
        String avatarUrl = mImage.getPath() + Const.Size.SIZE_DETAIL + mImage.getExtension();
        Glide.with(getContext()).load(avatarUrl).into(mImageView);
        return v;
    }
}
