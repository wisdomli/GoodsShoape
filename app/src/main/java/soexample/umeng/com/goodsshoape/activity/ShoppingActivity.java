package soexample.umeng.com.goodsshoape.activity;

import soexample.umeng.com.goodsshoape.mvp.presenter.BaseActivityPresenter;
import soexample.umeng.com.goodsshoape.presenter.ShoppingActivityPresenter;

/**
 * 作者:李自强
 * <p>
 * 2018/10/24
 **/
public class ShoppingActivity extends BaseActivityPresenter<ShoppingActivityPresenter> {
    @Override
    public Class<ShoppingActivityPresenter> getClassDelegate() {
        return ShoppingActivityPresenter.class;
    }
}
