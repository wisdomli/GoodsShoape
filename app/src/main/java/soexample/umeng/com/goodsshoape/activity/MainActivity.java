package soexample.umeng.com.goodsshoape.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import soexample.umeng.com.goodsshoape.R;
import soexample.umeng.com.goodsshoape.mvp.presenter.BaseActivityPresenter;
import soexample.umeng.com.goodsshoape.presenter.MainActivityPresenter;

public class MainActivity extends BaseActivityPresenter<MainActivityPresenter> {
    @Override
    public Class<MainActivityPresenter> getClassDelegate() {
        return MainActivityPresenter.class;
    }
}
