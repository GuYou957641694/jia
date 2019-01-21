package com.example.dell.jiadongshengyuekao.utli;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RetrofitUtils {

    private final MyApiService myApiService;

    private RetrofitUtils() {
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .readTimeout(20,TimeUnit.SECONDS)
                .connectTimeout(20,TimeUnit.SECONDS)
                .writeTimeout(20,TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .retryOnConnectionFailure(true)
                .build();
        Retrofit retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Contacts.BASE_URL)
                .client(okHttpClient)
                .build();
        //通过Retrofit创建完 这个ApiService 就可以调用方法了
        myApiService = retrofit.create(MyApiService.class);
    }
    private static class RetroHolder{
        private static final  RetrofitUtils retrofitUtils=new RetrofitUtils();
    }
    public static RetrofitUtils getInstence(){
        return RetroHolder.retrofitUtils;
    }
    public RetrofitUtils get(String url, HashMap<String,String> map, HashMap<String,Object> headmap, final HttpListener httpListener){
        Observer<ResponseBody> observer=new Observer<ResponseBody>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                httpListener.onError(e.getMessage());

            }
            @Override
            public void onNext(ResponseBody responseBody) {
                if(httpListener!=null){
                    try {
                        httpListener.onSuccess(responseBody.string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        myApiService.get(url,map,headmap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

        return RetrofitUtils.getInstence();

    }
    public RetrofitUtils post(String url, HashMap<String,String> map,HashMap<String,Object> headmap, final HttpListener httpListener){
        Observer<ResponseBody> observer=new Observer<ResponseBody>() {
            @Override
            public void onCompleted() {

            }
            @Override
            public void onError(Throwable e) {

            }
            @Override
            public void onNext(ResponseBody responseBody) {
                if(httpListener!=null){
                    try {
                        httpListener.onSuccess(responseBody.string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        myApiService.post(url,map,headmap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

        return RetrofitUtils.getInstence();
    }
    public RetrofitUtils delete(String url, HashMap<String,String> map,HashMap<String,Object> headmap, final HttpListener httpListener){
        Observer<ResponseBody> observer=new Observer<ResponseBody>() {
            @Override
            public void onCompleted() {

            }
            @Override
            public void onError(Throwable e) {
                httpListener.onError(e.getMessage());

            }
            @Override
            public void onNext(ResponseBody responseBody) {
                if(httpListener!=null){
                    try {
                        httpListener.onSuccess(responseBody.string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        myApiService.delete(url,map,headmap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

        return RetrofitUtils.getInstence();
    }
    public RetrofitUtils put(String url, HashMap<String,String> map,HashMap<String,Object> headmap, final HttpListener httpListener){
        Observer<ResponseBody> observer=new Observer<ResponseBody>() {
            @Override
            public void onCompleted() {

            }
            @Override
            public void onError(Throwable e) {

            }
            @Override
            public void onNext(ResponseBody responseBody) {
                if(httpListener!=null){
                    try {
                        httpListener.onSuccess(responseBody.string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        myApiService.put(url,map,headmap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

        return RetrofitUtils.getInstence();
    }

    //HttpListener httpListener;
    public interface HttpListener{
        void onSuccess(String jsonStr);
        void onError(String error);
    }
  /*  public void setHttpListene( HttpListener httpListener){
        this.httpListener=httpListener;
    }*/


}
