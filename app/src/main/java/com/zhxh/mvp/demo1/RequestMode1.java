package com.zhxh.mvp.demo1;

import com.zhxh.mvp.request.ApiService;
import com.zhxh.mvp.request.WeatherBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @author zhuxh
 * @date 2017/11/16
 * @description M层 数据层
 */
public class RequestMode1 {

    private static final String BASE_URL = "http://www.weather.com.cn/";

    //http://www.weather.com.cn/data/cityinfo/101010100.html
   public void request(String detailId, Callback<WeatherBean> callback){
       //请求接口
       Retrofit retrofit  = new Retrofit.Builder()
               //代表root地址
               .baseUrl(BASE_URL)
               .addConverterFactory(ScalarsConverterFactory.create())
               .addConverterFactory(GsonConverterFactory.create())
               .build();

       ApiService apiService = retrofit.create(ApiService.class);

       //请求
       Call<WeatherBean> weatherBeanCall = apiService.requestWeather(detailId);

       weatherBeanCall.enqueue(callback);
   }
}
