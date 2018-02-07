package com.project.eason.cryptocharts.apiService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * ApiService
 */

public interface ApiService
{
    @GET("data/all/coinlist")
    Call<ResponseBody> getCurrency();
}
