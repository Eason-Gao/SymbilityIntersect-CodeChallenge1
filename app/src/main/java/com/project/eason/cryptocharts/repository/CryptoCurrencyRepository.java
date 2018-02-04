package com.project.eason.cryptocharts.repository;

import android.provider.ContactsContract;
import android.util.Log;

import com.project.eason.cryptocharts.apiService.ApiService;
import com.project.eason.cryptocharts.db.CryptoCurrencyDatabase;
import com.project.eason.cryptocharts.db.dao.CurrencyDao;
import com.project.eason.cryptocharts.db.model.CryptoCurrency;

import java.util.List;

import javax.inject.Inject;

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
    public CryptoCurrencyRepository(CryptoCurrencyDatabase database){
        this.currencyDao = database.getCurrencyDao();
    }

    public void insertCurrencytoDb (CryptoCurrency cryptoCurrency)
    {
        currencyDao.insertCurrency(cryptoCurrency);
    }

    public void updateCurrencyInDb (CryptoCurrency cryptoCurrency)
    {
        currencyDao.updateCurrency(cryptoCurrency);
    }

    public void getCryptoCurrencyList(){

        apiService.getCurrency(new Callback<List<CryptoCurrency>>()
        {
            @Override
            public void onResponse(Call<List<CryptoCurrency>> call, Response<List<CryptoCurrency>> response)
            {
                if (response.code() == 200) {
		    Log.d("success", "succeess");
		}

            }

            @Override
            public void onFailure(Call<List<CryptoCurrency>> call, Throwable t)
            {

            }
        });
    }
}
