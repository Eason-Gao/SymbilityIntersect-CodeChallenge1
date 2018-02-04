package com.project.eason.cryptocharts.module;

import com.project.eason.cryptocharts.apiService.ApiService;
import com.project.eason.cryptocharts.repository.CryptoCurrencyRepository;
import com.project.eason.cryptocharts.viewmodel.CurrencyVIewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * ApiModule
 */

@Module
public class ApiModule
{
    @Provides
    @Singleton
    ApiService providesApiService()
    {
	final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

	return new Retrofit.Builder().baseUrl("https://min-api.cryptocompare.com/")
	    .client(httpClient.build())
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
