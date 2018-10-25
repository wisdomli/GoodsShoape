package soexample.umeng.com.goodsshoape.presenter;

import android.content.Context;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import soexample.umeng.com.goodsshoape.R;
import soexample.umeng.com.goodsshoape.activity.ShoppingActivity;
import soexample.umeng.com.goodsshoape.adapter.RecyviewLeft;
import soexample.umeng.com.goodsshoape.adapter.RightAdpter;
import soexample.umeng.com.goodsshoape.moudle.LeftBean;
import soexample.umeng.com.goodsshoape.moudle.RightBean;
import soexample.umeng.com.goodsshoape.mvp.view.Appdelegate;
import soexample.umeng.com.goodsshoape.net.HttpUrl;

/**
 * 作者:李自强
 * <p>
 * 2018/10/23
 **/
public class MainActivityPresenter extends Appdelegate implements View.OnClickListener {

    private RecyviewLeft recyviewLeftAdpter;
    private List<LeftBean.DataBean> list = new ArrayList<>();
    private RightAdpter adpter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        super.initData();
        getString(0, HttpUrl.ListLfteUrl);
        getString(1,HttpUrl.ListRightUrl+"?cid="+1);
        // 第二个适配器
         adpter = new RightAdpter(context);
        // 第一个适配器左侧
        recyviewLeftAdpter = new RecyviewLeft(context);
        RecyclerView recyclerView = get(R.id.left_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyviewLeftAdpter);


        RecyclerView recyclerView1 = get(R.id.right_recyclerview);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView1.setLayoutManager(linearLayoutManager1);
        recyclerView1.setAdapter(adpter);

      // 第一个适配器传过来的cid
        recyviewLeftAdpter.setOnItemClickListner(new RecyviewLeft.ItemClickListner() {
            @Override
            public void itemClick(int position) {
                getString(1,HttpUrl.ListRightUrl+"?cid="+list.get(position).getCid());
            }
        });

        getClik(this,R.id.gouwuche);

    }

    @Override
    public void suecssString(int type, String data) {
        super.suecssString(type, data);
        switch (type){
            case 0:
                Gson gson = new Gson();
                LeftBean leftBean = gson.fromJson(data, LeftBean.class);
                list = leftBean.getData();
                recyviewLeftAdpter.setList(list);
                break;

            case 1:
                Gson gson1 = new Gson();
                RightBean rightBean = gson1.fromJson(data, RightBean.class);
                List<RightBean.DataBean> data2 = rightBean.getData();
                adpter.setList(data2);
                break;
        }
    }


   private Context context;
    @Override
    public void getContext(Context context) {
        super.getContext(context);
        this.context = context;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.gouwuche:
                context.startActivity(new Intent(this.context, ShoppingActivity.class));
                break;
        }


    }
}
