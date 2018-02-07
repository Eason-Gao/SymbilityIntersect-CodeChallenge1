package com.project.eason.cryptocharts.apiService;

import com.google.gson.JsonElement;

import com.project.eason.cryptocharts.db.model.MainPojo;

import org.json.JSONObject;

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
