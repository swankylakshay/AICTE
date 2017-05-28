package com.knock.ashu.aicteandroid.network.aicte;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ashu on 1/3/2017.
 */

public class ApiClient {

    public static final String BASE_URL = "http://ashu07.esy.es/";
    public static ApiInterface apiInterface = null;


    public static ApiInterface getClient() {
        if (apiInterface == null) {

            apiInterface = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiInterface.class);
        }
        return apiInterface;
    }


    public static abstract class Callback<T> implements retrofit2.Callback<T> {

        @Override
        public void onResponse(final Call<T> call, Response<T> response) {

            if (response.isSuccessful()) {
                success(response.body());
            } else {
                try {
                    // never call response.errorBody().string() twice
                    String responseString = response.errorBody().string();
                    Log.d("codekamp", "onResponse: error response is " + responseString);
                    Gson gson = new Gson();
                    Error error = gson.fromJson(responseString, Error.class);
                    failure(error);
                } catch (IOException e) {
                    Log.d("codekamp", "onResponse IOException failure " + e.getMessage());
                    failure(new Error());
                }

            }
        }

        @Override
        public void onFailure(Call<T> call, Throwable t) {
            Log.d("codekamp", "onFailure: retrofit failure");
            Error error = new Error(t.getMessage());
            failure(error);
        }


        abstract public void success(T response);

        abstract public void failure(Error error);
    }


}