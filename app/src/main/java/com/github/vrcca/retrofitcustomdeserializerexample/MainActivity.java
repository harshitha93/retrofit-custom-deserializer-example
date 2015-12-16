package com.github.vrcca.retrofitcustomdeserializerexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.github.vrcca.retrofitcustomdeserializerexample.model.User;
import com.github.vrcca.retrofitcustomdeserializerexample.services.UserService;
import com.github.vrcca.retrofitcustomdeserializerexample.services.serializers.UserResponseDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

public class MainActivity extends AppCompatActivity {

    private UserService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson userDeserializer = new GsonBuilder().registerTypeAdapter(User.class, new UserResponseDeserializer()).create();

        RestAdapter.Builder builder = new RestAdapter.Builder();
        builder.setEndpoint("http://10.0.2.2:3000/");
        builder.setConverter(new GsonConverter(userDeserializer));
        RestAdapter adapter = builder.build();
        service = adapter.create(UserService.class);

    }

    public void load(View view) {
        service.listAllUsers(new Callback<List<User>>() {
            @Override
            public void success(List<User> users, Response response) {
                for (User user : users) {
                    Log.i("USERS", user + ": " + user.getName() + " " + user.getType());
                }
            }

            @Override
            public void failure(RetrofitError error) {
            // TODO
            }
        });
    }
}
