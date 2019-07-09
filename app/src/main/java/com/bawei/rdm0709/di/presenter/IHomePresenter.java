package com.bawei.rdm0709.di.presenter;

import com.bawei.rdm0709.data.bean.UserBean;
import com.bawei.rdm0709.di.contrant.IHomeContrant;
import com.bawei.rdm0709.di.model.IHomeModel;

/**
 * Time:2019/7/9 0009
 * <p>
 * Author:任德明
 * <p>
 * Description:
 */
public class IHomePresenter<V extends IHomeContrant.HomeView> extends BasePresenter<V> {


    private  IHomeModel model;

    public IHomePresenter() {
        model = new IHomeModel();
    }

    public void contentData(String url){
        model.requesetData(url, new IHomeContrant.HomeModel.CallBack() {
            @Override
            public void getData(UserBean userBean) {
                getView().showData(userBean);
            }
        });
    }
}
