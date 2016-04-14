package com.archer.mvptest.interactor;

import com.archer.mvptest.domain.Song;
import com.archer.mvptest.presenter.MainActivityPresenter;

public class SongInteractor {

    MainActivityPresenter mPresenter;

    public SongInteractor(MainActivityPresenter presenter){
        this.mPresenter = presenter;
    }

    public void insertSong(Song song){
        mPresenter.onSongInserted(song);
    }
    public void removeSong(Song song){
        mPresenter.onSongDeleted(song);
    }
    public void onDestroy(){
        // destroying actions
    }
}
