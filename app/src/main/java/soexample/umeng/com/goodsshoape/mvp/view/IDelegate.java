package soexample.umeng.com.goodsshoape.mvp.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.okhttp.RequestBody;

/**
 * 作者:李自强
 * <p>
 * 2018/10/23
 **/
public interface  IDelegate {

    void initData();

    void crate(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle);

    View rootview();

    void  getContext(Context context);
     // get请求
    void  getString(int type,String url);
     // post请求
    void postString(int type,String url, RequestBody body);

}
