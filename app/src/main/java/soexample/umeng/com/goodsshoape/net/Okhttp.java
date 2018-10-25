package soexample.umeng.com.goodsshoape.net;

import android.os.Handler;
import android.os.Message;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * 作者:李自强
 * <p>
 * 2018/10/23
 **/
public class Okhttp {

    private final int HTTP_SUECSS = 100;
    private final int HTTP_FAIL = 101;
    private HttpLisenter lisenter;
//    private OkHttpUtils(){}
//    private static OkHttpUtils mOkHttpUtils;
//
//    public synchronized static OkHttpUtils getOkHttpUtils(){
//        if(mOkHttpUtils==null){
//            mOkHttpUtils=new OkHttpUtils();
//        }
//        return mOkHttpUtils;
//    }
  // 单例模式
//    private Okhttp(){}
//
//    private static Okhttp mOkHttpUtils;
//
//    public synchronized static Okhttp getmOkHttpUtils(){
//        if (mOkHttpUtils==null){
//            mOkHttpUtils = new Okhttp();
//        }
//        return mOkHttpUtils;
//    }

    public Okhttp get(String url){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        doHttp(okHttpClient,request);
     return this;
    }



    private void doHttp(OkHttpClient okHttpClient, final Request request) {
           final Message message = Message.obtain();
        okHttpClient.newCall(request).enqueue(new Callback() {
            // 失败的信息
            @Override
            public void onFailure(Request request, IOException e) {
                message.what = HTTP_FAIL;
                message.obj = e.getMessage();
                 handler.sendMessage(message);
            }
            // 成功的信息
            @Override
            public void onResponse(Response response) throws IOException {
                String string = response.body().string();
                message.obj = string;

                message.what = HTTP_SUECSS;
                handler.sendMessage(message);
            }
        });

    }


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case HTTP_SUECSS:
                    String data = (String) msg.obj;
                    lisenter.suecss(data);
                    break;
                case HTTP_FAIL:
                  String error = (String) msg.obj;
                    lisenter.fail(error);
                    break;
            }

        }
    };

    public Okhttp post(String url, RequestBody body){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
          doHttp(okHttpClient,request);
        return this;
    }

    public void resout (HttpLisenter lisenter){
        this.lisenter = lisenter;
    }

    public interface HttpLisenter{
        void suecss(String data);
        void fail(String error);
    }

}
