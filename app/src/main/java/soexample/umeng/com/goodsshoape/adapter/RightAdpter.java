package soexample.umeng.com.goodsshoape.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import soexample.umeng.com.goodsshoape.R;
import soexample.umeng.com.goodsshoape.moudle.RightBean;

/**
 * 作者:李自强
 * <p>
 * 2018/10/24
 **/
public class RightAdpter extends RecyclerView.Adapter<RightAdpter.MyHolder>{


    private List<RightBean.DataBean> list = new ArrayList<>();
    private Context context;

    public RightAdpter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RightAdpter.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context,R.layout.layout_right_recyview,null);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RightAdpter.MyHolder myHolder, int i) {
        ChildAdapter childAdapter = new ChildAdapter(context,list.get(i).getList());
         GridLayoutManager gridLayoutManager = new GridLayoutManager(context,3);
      myHolder.recyclerView.setLayoutManager(gridLayoutManager);
        myHolder.recyclerView.setAdapter(childAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<RightBean.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }


    public class MyHolder extends RecyclerView.ViewHolder{


    RecyclerView recyclerView;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            recyclerView  =itemView.findViewById(R.id.rignt_recyclerview_child);
        }
    }
}
