package soexample.umeng.com.goodsshoape.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import soexample.umeng.com.goodsshoape.R;
import soexample.umeng.com.goodsshoape.moudle.LeftBean;


/**
 * 作者:李自强
 * <p>
 * 2018/10/23
 **/
public class RecyviewLeft extends RecyclerView.Adapter<RecyviewLeft.MyHolder>{
    private List<LeftBean.DataBean> leftBeanList = new ArrayList<>();
    private Context context;

    public RecyviewLeft(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyviewLeft.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.layout_left_iterm,null);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyviewLeft.MyHolder myHolder,final int i) {
        myHolder.textView.setText(leftBeanList.get(i).getName());
        if(leftBeanList.get(i).isShow()){
            myHolder.view_show.setVisibility(View.GONE);
            myHolder.layout_bg.setBackgroundResource(R.color.colorAccent);
            myHolder.textView.setTextColor(Color.BLACK);
        }else {
            myHolder.view_show.setVisibility(View.VISIBLE);
            myHolder.layout_bg.setBackgroundResource(R.color.colorPrimary);
            myHolder.textView.setTextColor(Color.WHITE);
        }

        myHolder.layout_bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int a=0;a<leftBeanList.size();a++){
                    if(i==a){
                        leftBeanList.get(a).setShow(true);
                    }else{
                        leftBeanList.get(a).setShow(false);
                    }
                }
                leftBeanList.get(i).setShow(true);
             if ( itemClickListner != null){
                itemClickListner.itemClick(i);
            }
             notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return leftBeanList.size();
    }


    public void setList(List<LeftBean.DataBean> leftBeanList) {
        this.leftBeanList = leftBeanList;
        notifyDataSetChanged();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
       TextView textView;
       RelativeLayout layout_bg;
       View view_show;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
        textView = itemView.findViewById(R.id.shop_title);
            layout_bg = itemView.findViewById(R.id.layout_bg);
            view_show = itemView.findViewById(R.id.view_show);

        }
    }

    private ItemClickListner itemClickListner;
    public void setOnItemClickListner(ItemClickListner itemClickListner){
        this.itemClickListner=itemClickListner;
    }

    public interface ItemClickListner{
        void itemClick(int position);
    }
}
