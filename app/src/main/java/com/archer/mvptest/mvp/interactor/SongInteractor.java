package com.archer.mvptest.mvp.interactor;

import com.archer.mvptest.domain.Song;
import com.archer.mvptest.mvp.presenter.MainActivityPresenter;
import com.archer.mvptest.view.adapter.SongAdapter;

public class SongInteractor {

    MainActivityPresenter mPresenter;
    SongAdapter songAdapter;

    public SongInteractor(MainActivityPresenter presenter, SongAdapter adapter){
        this.mPresenter  = presenter;
        this.songAdapter = adapter;
    }

    public void insertSong(Song song){
        songAdapter.addItem(song);
        mPresenter.onSongInserted(song);
    }
    public void removeSong(Song song){
        songAdapter.removeSong(song);
        mPresenter.onSongDeleted(song);
    }
    public void onDestroy(){
        // destroying actions
    }
}
