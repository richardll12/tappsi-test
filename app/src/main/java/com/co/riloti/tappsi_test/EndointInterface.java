package com.co.riloti.tappsi_test;

import com.co.riloti.tappsi_test.models.Solicitud;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by MichaelRicardo on 25/05/2016.
 */
public interface EndointInterface {

    @GET("driver_info.json")
    Call<Solicitud> getDriverInfo();
}
