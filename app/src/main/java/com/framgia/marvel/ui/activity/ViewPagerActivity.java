package com.framgia.marvel.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.framgia.marvel.R;
import com.framgia.marvel.data.model.Thumbnail;
import com.framgia.marvel.data.value.Const;
import com.framgia.marvel.ui.adapter.ImagePagerAdapter;
import com.framgia.marvel.ui.fragment.ImageFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private ImagePagerAdapter mAdapter;
    private List<ImageFragment> mFragments;

    public static Intent getInstance(Context context, List<Thumbnail> thumbnails, int position) {
        Intent intent = new Intent(context, ViewPagerActivity.class);
        intent.putParcelableArrayListExtra(Const.Extra.EXTRA_LIST_IMAGE,
            (ArrayList<? extends Parcelable>) thumbnails);
        intent.putExtra(Const.Extra.EXTRA_POSITION, position);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        initToolbar();
        initViewPager();
    }

    public void initViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager_image);
        mFragments = new ArrayList<>();
        Intent intent = getIntent();
        List<Thumbnail> thumbnails =
            intent.getParcelableArrayListExtra(Const.Extra.EXTRA_LIST_IMAGE);
        for (int i = 0; i < thumbnails.size(); i++)
            mFragments.add(ImageFragment.newInstance
                (thumbnails.get(i)));
        mAdapter = new ImagePagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mAdapter);
        int position = intent.getIntExtra(Const.Extra.EXTRA_POSITION, 0);
        mViewPager.setCurrentItem(position);
    }

    public void initToolbar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ColorDrawable colorDrawable = new ColorDrawable(Color.RED);
        actionBar.setBackgroundDrawable(colorDrawable);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
