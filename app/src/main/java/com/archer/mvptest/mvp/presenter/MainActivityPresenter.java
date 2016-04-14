package com.archer.mvptest.mvp.presenter;

import android.widget.Toast;

import com.archer.mvptest.domain.Song;
import com.archer.mvptest.mvp.interactor.SongInteractor;
import com.archer.mvptest.mvp.viewmodel.MainActivityViewModel;

import java.lang.ref.WeakReference;

public class MainActivityPresenter implements MvpPresenter, MainActivityViewModel {


    private WeakReference<MainActivityViewModel> mView;
    private SongInteractor mInteractor;
    private boolean mIsChangingConfig;

    public MainActivityPresenter(MainActivityViewModel view){
        this.mView = new WeakReference<MainActivityViewModel>(view);
        this.mInteractor = new SongInteractor(this);
    }

    /**
     * Operations offered from Presenter to View
     *      View -> Presenter
     */

    public void newSong(String songTitle){
        Song song = new Song();
        song.setTitle(songTitle);
        mInteractor.insertSong(song);
    }
    public void deleteSong(Song song){
        mInteractor.removeSong(song);
    }

    /**
     * Operations offered from Presenter to Model
     *      Model -> Presenter
     */

    public void onSongInserted(Song newSong){
        mView.get().showToast(newSong.getTitle() + " successfull inserted in the list");
    }

    public void onSongDeleted(Song deletedSong){
        mView.get().showToast(deletedSong.getTitle() + " deleted from the list");
    }

    public void onError(String errorMsg){
        mView.get().showAlert(errorMsg);
    }


    /**
     * MvpPresenter Override methods
     */

    @Override
    public void onConfigurationChanged(MainActivityViewModel view) {
        mView = new WeakReference<MainActivityViewModel>(view);
    }

    @Override
    public void onDestroy(boolean isChangingConfig) {
        mView = null;
        mIsChangingConfig = isChangingConfig;
        if (!isChangingConfig){
            mInteractor.onDestroy();
        }
    }

    /**
     * MainActivityViewModel Override methods
     */

    // Show AlertDialog
    @Override
    public void showAlert(String msg) {
        // show alert Box
    }

    // Show Toast
    @Override
    public void showToast(String msg) {
        Toast.makeText();
    }
}
