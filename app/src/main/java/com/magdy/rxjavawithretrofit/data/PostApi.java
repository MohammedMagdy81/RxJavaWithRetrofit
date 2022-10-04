package com.magdy.rxjavawithretrofit.data;

import com.magdy.rxjavawithretrofit.pojo.Post;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostApi {

    @GET("posts")
     public Observable<List<Post>> getPosts();
}
