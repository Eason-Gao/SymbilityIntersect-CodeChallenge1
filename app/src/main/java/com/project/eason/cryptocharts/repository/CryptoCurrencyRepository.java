package com.project.eason.cryptocharts.repository;

import static android.content.ContentValues.TAG;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.project.eason.cryptocharts.apiService.ApiService;
import com.project.eason.cryptocharts.db.dao.CurrencyDao;
import com.project.eason.cryptocharts.db.model.CryptoCurrency;
import com.project.eason.utils.ApiUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Repository for inserting/updating currencies
 */

public class CryptoCurrencyRepository{

    @Inject ApiService apiService;

    private final CurrencyDao currencyDao;

    @Inject
    public CryptoCurrencyRepository(CurrencyDao currencyDao){
        this.currencyDao = currencyDao;
    }

    public void insertCurrencytoDb (CryptoCurrency cryptoCurrency)
    {
        currencyDao.insertAllCurrencies(cryptoCurrency);
    }

    public MutableLiveData<List<CryptoCurrency>> getCryptoCurrencyListFromDB()
    {
	final MutableLiveData<List<CryptoCurrency>> data = new MutableLiveData<>();

	data.setValue(currencyDao.getAllCurrencies());

	return data;
    }

    public void getCryptoCurrencyList(){

	Call<ResponseBody> call = apiService.getCurrency();

	call.enqueue(new Callback<ResponseBody>()
	{

	    // this does not run on the main thread
	    @Override
	    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response)
	    {
	        if(response.isSuccessful())
		{
		    // the response body returns currencies as a data class instead of a array so some parsing needed to be done
		    Set<Map.Entry<String, JsonElement>> entries = ApiUtil.convertToMap(response);

		    ArrayList<CryptoCurrency> cryptoCurrencies = new ArrayList<>();

		    for (Map.Entry<String, JsonElement> entry : entries) {

			CryptoCurrency cryptoCurrency = new CryptoCurrency();
			cryptoCurrency.setCoinName(entry.getValue().getAsJsonObject().get("CoinName").getAsString());

			insertCurrencytoDb(cryptoCurrency);
		    }
		}
	    }

	    @Override
	    public void onFailure(Call<ResponseBody> call, Throwable t)
	    {

	    }
	});
    }
}
