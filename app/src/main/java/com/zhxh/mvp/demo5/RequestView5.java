package com.zhxh.mvp.demo5;

import com.zhxh.mvp.request.WeatherBean;
import com.zhxh.mvpframework.view.BaseMvpView;

/**
 * @author zhuxh
 * @date 2017/11/17
 * @description
 */
public interface RequestView5 extends BaseMvpView{
    void requestLoading();
    void resultSuccess(WeatherBean result);
    void resultFailure(String result);
}
