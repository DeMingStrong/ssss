package com.bawei.rdm0709.di.contrant;

import com.bawei.rdm0709.data.bean.UserBean;

/**
 * Time:2019/7/9 0009
 * <p>
 * Author:任德明
 * <p>
 * Description:
 */
public interface IHomeContrant {

    /**
     * V 层
     */
    public interface HomeView{
        public void showData(UserBean userBean);
    }

    /**
     * P 层
     */
    public interface HomePresenter<HomeView>{
        public void attachView(IHomeContrant.HomeView homeView);

        public void datachView();
    }

    /**
     * M 层
     */
    public interface HomeModel{
        public void requesetData(String url,CallBack callBack);

      public interface CallBack{
          public void getData(UserBean userBean);
      }
    }
}
