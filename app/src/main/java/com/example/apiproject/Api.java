package com.example.apiproject;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class Api {
    private static final String key = "users";
    private static final String url = "https://jsonplaceholder.typicode.com/";
    public static UserService userService = null;
    public static UserService getService(){

        if (userService == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            userService = retrofit.create(UserService.class);
        }
        return userService;
    }

    public interface UserService {
        @GET(key)
        Call<User> getUsers();
    }

}
