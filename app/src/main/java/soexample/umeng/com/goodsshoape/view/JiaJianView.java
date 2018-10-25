package soexample.umeng.com.goodsshoape.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import soexample.umeng.com.goodsshoape.R;

/**
 * 作者:李自强
 * <p>
 * 2018/10/24
 **/
public class JiaJianView extends LinearLayout {

    public JiaJianView(Context context) {
        super(context);
        initData(context);
    }

    public JiaJianView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initData(context);
    }

    public JiaJianView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData(context);
    }
    private Context context;
    private void initData(Context context) {
        this.context = context;
        View view = View.inflate(context, R.layout.shop_car_price_layout,null);

       addView(view);

    }

}
