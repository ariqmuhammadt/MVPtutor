package xyz.ariq.mvptutor.Interface;

import xyz.ariq.mvptutor.Model.ResponsModel;

/**
 * Created by AriqMT on 20/12/2017.
 */

public interface BiodataViewInterface {
    void showLoading();
    void hideLoading();
    void onFinishinsert(ResponsModel res);
    void onFailureinsert();

    void log(String t);
}
