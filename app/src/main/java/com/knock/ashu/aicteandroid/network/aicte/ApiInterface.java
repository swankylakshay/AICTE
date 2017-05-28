package com.knock.ashu.aicteandroid.network.aicte;

import com.knock.ashu.aicteandroid.models.Blog;
import com.knock.ashu.aicteandroid.models.BlogList;
import com.knock.ashu.aicteandroid.models.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Ashu on 1/3/2017.
 */

public interface ApiInterface {

    @FormUrlEncoded
    @POST("/AicteSignUp.php")
    Call<User> signUp(@Field("email") String email, @Field("fullname") String fullname,
                      @Field("password") String password);

    @FormUrlEncoded
    @POST("/AicteLogin.php")
    Call<User> login(@Field("email") String email, @Field("password") String password);


    @FormUrlEncoded
    @POST("/AicteCreateBlog.php")
    Call<User> createBlog(@Field("title") String title, @Field("description") String description,
                          @Field("image") String image);

    @GET("/AicteBlogs.php")
    Call<BlogList> readBlogs();
}
