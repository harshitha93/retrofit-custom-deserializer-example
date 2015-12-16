package com.github.vrcca.retrofitcustomadapterexample.services;


import com.github.vrcca.retrofitcustomadapterexample.model.User;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

public interface UserService {

    @GET("/users")
    void listAllUsers(Callback<List<User>> callback);

}
