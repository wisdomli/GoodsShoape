package soexample.umeng.com.goodsshoape.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import soexample.umeng.com.goodsshoape.R;
import soexample.umeng.com.goodsshoape.moudle.ShoppinBean;

/**
 * 作者:李自强
 * <p>
 * 2018/10/24
 **/
public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.MyHolder>{
    private List<ShoppinBean.DataBean> list = new ArrayList<>();
    private Context context;

    public TitleAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public TitleAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context,R.layout.shop_seller_car_adapter,null);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TitleAdapter.MyHolder myHolder, int i) {
      myHolder.textView.setText(list.get(i).getSellerName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<ShoppinBean.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        TextView textView;
        RecyclerView recyclerView;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.seller_name);
            recyclerView = itemView.findViewById(R.id.seller_recyclerview);

        }
    }
}
