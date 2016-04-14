package com.archer.mvptest.presenter;

import com.archer.mvptest.domain.Song;
import com.archer.mvptest.viewmodel.MainActivityViewModel;

public interface MvpPresenter {
    /**
     * Configuration change and Activity life cycle
     */

    void onConfigurationChanged(MainActivityViewModel view);
    void onDestroy(boolean isChangingConfig);


}
