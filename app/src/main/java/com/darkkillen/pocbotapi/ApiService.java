package com.darkkillen.pocbotapi;

import com.darkkillen.pocbotapi.model.ExchangeRateModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by darkkillen on 12/1/2017 AD.
 */

public interface ApiService {

    @GET("DAILY_AVG_EXG_RATE_V1/")
    Call<ExchangeRateModel> getExchangeRate(
            @Header("api-key") String apiKey,
            @Query("start_period") String startTime,
            @Query("end_period") String endTime
    );

}
