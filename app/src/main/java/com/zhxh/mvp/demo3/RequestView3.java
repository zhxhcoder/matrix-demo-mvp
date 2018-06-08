package com.zhxh.mvp.demo3;

import com.zhxh.mvp.demo3.base.MvpView3;
import com.zhxh.mvp.request.WeatherBean;

/**
 * @author zhuxh
 * @date 2017/11/16
 * @description V层接口
 */
public interface RequestView3 extends MvpView3 {
    void requestLoading();
    void resultSuccess(WeatherBean result);
    void resultFailure(String result);
}
