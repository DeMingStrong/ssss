package com.bawei.rdm0709.ui.activity;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bawei.rdm0709.R;
import com.bawei.rdm0709.data.bean.UserBean;
import com.bawei.rdm0709.di.contrant.IHomeContrant;
import com.bawei.rdm0709.di.presenter.IHomePresenter;
import com.bawei.rdm0709.ui.adapter.UserAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity<IHomeContrant.HomeView, IHomePresenter<IHomeContrant.HomeView>> implements IHomeContrant.HomeView {

    @BindView(R.id.rv_view)
    RecyclerView rvView;
    @BindView(R.id.srl_layout)
    SmartRefreshLayout srlLayout;
    private String image="http://172.17.8.100/small/commodity/v1/findCommodityListByLabel?labelId=1004&count=10";
    private int page=1;


    @Override
    public void showData(UserBean userBean) {
        List<UserBean.ResultBean> beanResult = userBean.getResult();
        //管理者
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        rvView.setLayoutManager(layoutManager);

        //适配器
        UserAdapter adapter = new UserAdapter(R.layout.useradapter, beanResult);
        rvView.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        pullData();
     mPresenter.contentData(image+page);
    }

    @Override
    protected IHomePresenter<IHomeContrant.HomeView> contrantPresenter() {
        return new IHomePresenter<>();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    public void pullData(){
        srlLayout.setEnableLoadMore(true);
        srlLayout.setEnableRefresh(true);

        srlLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page=1;
                mPresenter.contentData(image);
                srlLayout.finishRefresh();
            }
        });
        srlLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                mPresenter.contentData(image+page);
                srlLayout.finishLoadMore();
            }
        });
    }

}
