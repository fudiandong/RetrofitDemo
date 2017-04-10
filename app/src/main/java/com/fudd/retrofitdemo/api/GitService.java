package com.fudd.retrofitdemo.api;

import com.fudd.retrofitdemo.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by fudiandong on 2017/4/10.
 */

public interface GitService {

    @GET("/users/{username}")
    Call<User> getUser(@Path("username") String username);
}
