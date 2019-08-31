package com.sar.user.rxjava_retrofit;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.POST;

public interface Api {
    @POST("posts")
    Observable<List<Post>> getPost();
}
