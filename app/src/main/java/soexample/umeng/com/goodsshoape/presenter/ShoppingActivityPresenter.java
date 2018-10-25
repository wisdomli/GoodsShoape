package soexample.umeng.com.goodsshoape.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.List;

import soexample.umeng.com.goodsshoape.R;
import soexample.umeng.com.goodsshoape.adapter.TitleAdapter;
import soexample.umeng.com.goodsshoape.moudle.ShoppinBean;
import soexample.umeng.com.goodsshoape.mvp.view.Appdelegate;
import soexample.umeng.com.goodsshoape.net.HttpUrl;

/**
 * 作者:李自强
 * <p>
 * 2018/10/24
 **/
public class ShoppingActivityPresenter extends Appdelegate{
    private TitleAdapter titleAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.layout_shopping;
    }

    @Override
    public void initData() {
        super.initData();
         getString(0, HttpUrl.SHOW_SHOAPING);
         titleAdapter = new TitleAdapter(context);
        RecyclerView recyclerView = get(R.id.show_RecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(titleAdapter);
    }

    @Override
    public void suecssString(int type, String data) {
        super.suecssString(type, data);
        Gson gson = new Gson();
        ShoppinBean shoppinBean = gson.fromJson(data, ShoppinBean.class);
        List<ShoppinBean.DataBean> data1 = shoppinBean.getData();
        titleAdapter.setList(data1);
    }
  private Context context;
    @Override
    public void getContext(Context context) {
        super.getContext(context);
        this.context = context;
    }
}
