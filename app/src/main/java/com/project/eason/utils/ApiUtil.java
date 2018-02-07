package com.project.eason.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.project.eason.cryptocharts.db.model.CryptoCurrency;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by Eason on 2018-02-04.
 */

public class ApiUtil
{
    public static Set<Map.Entry<String, JsonElement>> convertToMap(Response<ResponseBody> response) {


    JsonParser jsonParser = new JsonParser();
    Gson gson = new Gson();

    JsonElement element = gson.fromJson(response.body().toString(), JsonElement.class);
    JsonObject jsonObject = null;

    try {
	jsonObject = jsonParser.parse(response.body().string()).getAsJsonObject();

    } catch (IOException e) {
	e.printStackTrace();
    }

    JsonObject currency = jsonObject.get("Data").getAsJsonObject();

    Set<Map.Entry<String, JsonElement>> entries = currency.entrySet();

    return entries;

    }
}
