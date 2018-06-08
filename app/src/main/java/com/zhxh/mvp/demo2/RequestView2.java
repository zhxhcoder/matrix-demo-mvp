package com.zhxh.mvp.demo2;

import com.zhxh.mvp.request.WeatherBean;

/**
 * @author zhuxh
 * @date 2017/11/16
 * @description V层接口
 */
public interface RequestView2 {
    void requestLoading();
    void resultSuccess(WeatherBean result);
    void resultFailure(String result);
}
