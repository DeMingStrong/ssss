package com.bawei.rdm0709.di.presenter;

import java.lang.ref.WeakReference;

/**
 * Time:2019/7/9 0009
 * <p>
 * Author:任德明
 * <p>
 * Description:
 */
public class BasePresenter<V>{

    private WeakReference<V> weakReference;

    public void attachView(V v){
        weakReference = new WeakReference<>(v);
    }

    public V getView(){
        return weakReference.get();
    }

    public void datachView(){
        weakReference.clear();
    }
}
