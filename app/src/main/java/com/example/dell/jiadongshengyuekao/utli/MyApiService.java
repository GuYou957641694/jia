package com.example.dell.jiadongshengyuekao.utli;

import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

public interface MyApiService {
    @GET
    Observable<ResponseBody> get(@Url String url, @QueryMap HashMap<String, String> map, @HeaderMap HashMap<String, Object> headmap);
    @POST
    Observable<ResponseBody> post(@Url String url, @QueryMap HashMap<String, String> map, @HeaderMap HashMap<String, Object> headmap);
    @DELETE
    Observable<ResponseBody> delete(@Url String url, @QueryMap HashMap<String, String> map, @HeaderMap HashMap<String, Object> headmap);
    @PUT
    Observable<ResponseBody> put(@Url String url, @QueryMap HashMap<String, String> map, @HeaderMap HashMap<String, Object> headmap);





}
