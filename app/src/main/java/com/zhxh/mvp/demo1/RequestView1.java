package com.zhxh.mvp.demo1;

import com.zhxh.mvp.request.WeatherBean;

/**
 * @author zhuxh
 * @date 2017/11/16
 * @description V层接口，定义P层和V层的方法
 */
public interface RequestView1 {
    void requestLoading();
    void resultSuccess(WeatherBean result);
    void resultFailure(String result);
}
