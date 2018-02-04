package com.project.eason.cryptocharts.apiService;

import com.project.eason.cryptocharts.db.model.CryptoCurrency;

import java.util.List;

import retrofit2.Callback;
import retrofit2.http.GET;

/**
 * ApiService
 */

public interface ApiService
{
    @GET("data/all/coinlist")
    void getCurrency(Callback<List<CryptoCurrency>> cb);
}
