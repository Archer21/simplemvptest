package com.archer.mvptest.mvp.presenter;

import com.archer.mvptest.mvp.viewmodel.MainActivityViewModel;

public interface MvpPresenter {
    /**
     * Configuration change and Activity life cycle
     */

    void onConfigurationChanged(MainActivityViewModel view);
    void onDestroy(boolean isChangingConfig);


}
