package soexample.umeng.com.goodsshoape.mvp.view;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.okhttp.RequestBody;

import soexample.umeng.com.goodsshoape.net.Okhttp;


/**
 * 作者:李自强
 * <p>
 * 2018/10/23
 **/
public abstract class Appdelegate implements IDelegate{

    private View rootview;

    @Override
    public void initData() {

    }
     private SparseArray<View> views = new SparseArray<>();
    public <T extends View> T get(int id){
        T view = (T) views.get(id);
        if (view == null){
            view = rootview.findViewById(id);
            views.put(id,view);
        }
        return view;
    }

   public void getClik(View.OnClickListener listener,int... ids){
        if (ids == null){
            return;
        }
        for (int id : ids){
            get(id).setOnClickListener(listener);
        }
   }


    @Override
    public void crate(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
         rootview = inflater.inflate(getLayoutId(), viewGroup, false);
    }

    @Override
    public View rootview() {
        return rootview;
    }
    private Context context;
    @Override
    public void getContext(Context context) {
     this.context= context;
    }

   public abstract int getLayoutId();

    // get请求
    @Override
    public void  getString(final int type, String url) {
       new Okhttp().get(url).resout(new Okhttp.HttpLisenter() {
           @Override
           public void suecss(String data) {
               suecssString(type,data);
           }

           @Override
           public void fail(String error) {
            fail(error);
           }
       });
    }



    // post请求
    @Override
    public void postString(final int type, String url, RequestBody body) {
        new Okhttp().post(url,body).resout(new Okhttp.HttpLisenter() {
            @Override
            public void suecss(String data) {
                suecssString(type,data);
            }

            @Override
            public void fail(String error) {
              fail(error);
            }
        });
    }



    // 成功
    public void suecssString(int type, String data){}
    // 失败
     public void  fail(String error){}

}
