package com.arsldev.lutluthfi.sigmadialog.base;

import android.support.annotation.StringRes;

public interface IBaseView {

    void showLoading();

    void hideLoading();

    boolean isLoading();

    boolean isNetworkConnected();

    void hideKeyboard();

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    void printLog(String tag, String message);

    void printLog(String tag, @StringRes int resId);

    void printLog(String tag, String message, Throwable tr);

    void printLog(String tag, @StringRes int resId, Throwable tr);
}
