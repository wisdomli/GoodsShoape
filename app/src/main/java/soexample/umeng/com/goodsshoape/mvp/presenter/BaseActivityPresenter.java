package soexample.umeng.com.goodsshoape.mvp.presenter;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import soexample.umeng.com.goodsshoape.mvp.view.IDelegate;

/**
 * 作者:李自强
 * <p>
 * 2018/10/23
 **/
public abstract class BaseActivityPresenter<T extends IDelegate> extends AppCompatActivity {

    private  T delegate;

    public abstract  Class<T> getClassDelegate();

    public BaseActivityPresenter (){
        try {
             delegate = getClassDelegate().newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        delegate.crate(getLayoutInflater(),null,savedInstanceState);
        setContentView(delegate.rootview());
        delegate.getContext(this);
        delegate.initData();
    }


}
