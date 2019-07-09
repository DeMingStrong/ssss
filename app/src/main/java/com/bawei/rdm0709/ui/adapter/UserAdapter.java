package com.bawei.rdm0709.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bawei.rdm0709.R;
import com.bawei.rdm0709.data.bean.UserBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Time:2019/7/9 0009
 * <p>
 * Author:任德明
 * <p>
 * Description:
 */
public class UserAdapter extends BaseQuickAdapter<UserBean.ResultBean,BaseViewHolder> {
    public UserAdapter(int layoutResId, @Nullable List<UserBean.ResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, UserBean.ResultBean item) {
            helper.setText(R.id.tv_view,item.getCommodityName());
            helper.setText(R.id.tv_tetx,item.getPrice()+"");
        ImageView iv_image = helper.getView(R.id.iv_image);
        Glide.with(mContext).load(item.getMasterPic()).into(iv_image);
    }
}
