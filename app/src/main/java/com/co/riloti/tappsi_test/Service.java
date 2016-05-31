package com.co.riloti.tappsi_test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MichaelRicardo on 25/05/2016.
 */
public class Service {
    public static final String BASE_URL = "https://raw.githubusercontent.com/tappsi/test_recruiting/master/sample_files/";



    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();



}
