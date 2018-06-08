package com.zhxh.mvpframework.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.zhxh.mvpframework.factory.PresenterMvpFactory;
import com.zhxh.mvpframework.factory.PresenterMvpFactoryImpl;
import com.zhxh.mvpframework.presenter.BaseMvpPresenter;
import com.zhxh.mvpframework.proxy.BaseMvpProxy;
import com.zhxh.mvpframework.proxy.PresenterProxyInterface;

/**
 * @author zhuxh
 * @date 2017/11/20
 * @description
 */
public class AbstractMvpAppCompatActivity<V extends BaseMvpView, P extends BaseMvpPresenter<V>> extends AppCompatActivity implements PresenterProxyInterface<V,P> {
    private static final String PRESENTER_SAVE_KEY = "presenter_save_key";
    /**
     * 创建被代理对象,传入默认Presenter的工厂
     */
    private BaseMvpProxy<V,P> mProxy = new BaseMvpProxy<>(PresenterMvpFactoryImpl.<V,P>createFactory(getClass()));

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("matrix-mvp","V onCreate");
        Log.e("matrix-mvp","V onCreate mProxy = " + mProxy);
        Log.e("matrix-mvp","V onCreate this = " + this.hashCode());
        if(savedInstanceState != null){
            mProxy.onRestoreInstanceState(savedInstanceState.getBundle(PRESENTER_SAVE_KEY));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("matrix-mvp","V onResume");
        mProxy.onResume((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("matrix-mvp","V onDestroy = " + isChangingConfigurations());
        mProxy.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("matrix-mvp","V onSaveInstanceState");
        outState.putBundle(PRESENTER_SAVE_KEY,mProxy.onSaveInstanceState());
    }

    @Override
    public void setPresenterFactory(PresenterMvpFactory<V, P> presenterFactory) {
        Log.e("matrix-mvp","V setPresenterFactory");
        mProxy.setPresenterFactory(presenterFactory);
    }

    @Override
    public PresenterMvpFactory<V, P> getPresenterFactory() {
        Log.e("matrix-mvp","V getPresenterFactory");
        return mProxy.getPresenterFactory();
    }

    @Override
    public P getMvpPresenter() {
        Log.e("matrix-mvp","V getMvpPresenter");
        return mProxy.getMvpPresenter();
    }
}
