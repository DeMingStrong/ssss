package com.bawei.rdm0709.di.model;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.rdm0709.data.bean.UserBean;
import com.bawei.rdm0709.data.utils.IContrant;
import com.bawei.rdm0709.di.contrant.IHomeContrant;
import com.bawei.rdm0709.ui.App;
import com.google.gson.Gson;

/**
 * Time:2019/7/9 0009
 * <p>
 * Author:任德明
 * <p>
 * Description:
 */
public class IHomeModel implements IHomeContrant.HomeModel {
    @Override
    public void requesetData(String url, final CallBack callBack) {
        RequestQueue requestQueue = Volley.newRequestQueue(App.context);
        StringRequest request = new StringRequest(IContrant.DATA_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson =new Gson();
                UserBean userBean = gson.fromJson(response, UserBean.class);
                callBack.getData(userBean);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(request);
    }
}
