package com.project.eason.cryptocharts.apiService;

import com.project.eason.cryptocharts.db.dao.CurrencyDao;
import com.project.eason.cryptocharts.db.model.CryptoCurrency;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * ApiService
 */

public interface ApiService
{
    @POST("endpoint")
    Call<CurrencyDao>  getCurrency(@Body CryptoCurrency cryptoCurrency);
}
