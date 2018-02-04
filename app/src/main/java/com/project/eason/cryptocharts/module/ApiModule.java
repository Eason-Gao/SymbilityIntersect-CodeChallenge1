package com.project.eason.cryptocharts.module;

import com.project.eason.cryptocharts.apiService.ApiService;
import com.project.eason.cryptocharts.repository.CryptoCurrencyRepository;
import com.project.eason.cryptocharts.viewmodel.CurrencyVIewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ApiModule
 */

@Module
public class ApiModule
{
    String mBAseUrl;

    public ApiModule(String baseUrl)
    {
        this.mBAseUrl = baseUrl;
    }

    @Provides
    @Singleton
    ApiService providesApiService()
    {
	final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

	return new Retrofit.Builder().baseUrl("https://min-api.cryptocompare.com/")
	    .client(httpClient.build())
	    .addConverterFactory(GsonConverterFactory.create())
	    .build()
	    .create(ApiService.class);
    }

    @Provides
    @Singleton
    CurrencyVIewModelFactory providesCurrencyViewModelFactory(CryptoCurrencyRepository cryptoCurrencyRepository)
    {
        return new CurrencyVIewModelFactory(cryptoCurrencyRepository);
    }
}
