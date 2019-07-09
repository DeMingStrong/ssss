package com.bawei.rdm0709.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bawei.rdm0709.R;
import com.bawei.rdm0709.di.presenter.BasePresenter;

import butterknife.ButterKnife;

/**
 * Time:2019/7/9 0009
 * <p>
 * Author:任德明
 * <p>
 * Description:
 */
public abstract class BaseActivity<V,P extends BasePresenter<V>> extends AppCompatActivity {

    public P mPresenter;
    public Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        mPresenter = contrantPresenter();
        mPresenter.attachView((V) this);
        mContext = this;
        initData();
    }

    protected abstract void initData();

    protected abstract P contrantPresenter();

    public abstract int getLayout();
}
