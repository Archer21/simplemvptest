package com.archer.mvptest.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.archer.mvptest.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SongViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.song_title)
    TextView mSongTitle;

    public SongViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setSongTitle(String title){
        mSongTitle.setText(title);
    }
}
