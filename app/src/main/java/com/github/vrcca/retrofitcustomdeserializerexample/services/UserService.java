package com.github.vrcca.retrofitcustomdeserializerexample.services;


import com.github.vrcca.retrofitcustomdeserializerexample.model.User;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

public interface UserService {

    @GET("/users")
    void listAllUsers(Callback<List<User>> callback);

}
