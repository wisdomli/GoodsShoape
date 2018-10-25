package soexample.umeng.com.goodsshoape.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import soexample.umeng.com.goodsshoape.R;
import soexample.umeng.com.goodsshoape.moudle.RightBean;

/**
 * 作者:李自强
 * <p>
 * 2018/10/24
 **/
public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.MyHolder>{

 private List<RightBean.DataBean.ListBean> list;


   private Context context;
    public ChildAdapter(Context context, List<RightBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context,R.layout.layout_right_iterm,null);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        Glide.with(context).load(list.get(i).getIcon()).into(myHolder.imageView);
        myHolder.textView.setText(list.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder{
      ImageView imageView;
      TextView textView;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.shop_img);
            textView =itemView.findViewById(R.id.shop_iterm);
        }
    }
}
