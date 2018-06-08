package com.zhxh.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zhxh.mvp.demo5.RequestPresenter5;
import com.zhxh.mvp.demo5.RequestView5;
import com.zhxh.mvp.request.WeatherBean;
import com.zhxh.mvpframework.factory.CreatePresenter;
import com.zhxh.mvpframework.view.AbstractMvpActivitiy;
import com.squareup.leakcanary.RefWatcher;

/**
 * @author zhuxh
 * @date 2017/11/23
 * @description
 */
@CreatePresenter(RequestPresenter5.class)
public class SecondActivity extends AbstractMvpActivitiy<RequestView5, RequestPresenter5> implements RequestView5{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void requestLoading() {

    }

    @Override
    public void resultSuccess(WeatherBean result) {

    }

    @Override
    public void resultFailure(String result) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = MyApp.getRefWatcher(this);//1
        refWatcher.watch(this);
    }
}
