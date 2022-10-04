package com.magdy.rxjavawithretrofit.data;

import com.magdy.rxjavawithretrofit.pojo.Post;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    public PostApi api;
    public static PostClient INSTANCE;

    public PostClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        api = retrofit.create(PostApi.class);

    }

    public static PostClient getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new PostClient();
        }
        return INSTANCE;
    }

    public Observable<List<Post>> getPosts(){
        return api.getPosts();
    }
}
