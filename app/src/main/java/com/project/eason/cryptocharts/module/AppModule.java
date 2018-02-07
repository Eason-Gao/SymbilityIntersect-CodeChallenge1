package com.project.eason.cryptocharts.module;

import com.project.eason.cryptocharts.apiService.ApiService;
import com.project.eason.cryptocharts.repository.CryptoCurrencyRepository;
import com.project.eason.cryptocharts.viewmodel.CurrencyViewModelFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * AppModule
 */

@Module
public class AppModule
{
    String mBAseUrl;

    public AppModule(String baseUrl)
    {
        this.mBAseUrl = baseUrl;
    }

    @Provides
    @Singleton
    ApiService providesApiService()
    {
	final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

	return new Retrofit.Builder().baseUrl(mBAseUrl)
	    .client(httpClient.build())
	    .addConverterFactory(GsonConverterFactory.create())
	    .callbackExecutor(Executors.newSingleThreadExecutor())
	    .build()
	    .create(ApiService.class);
    }

    @Provides
    @Singleton
    CurrencyViewModelFactory providesCurrencyViewModelFactory(CryptoCurrencyRepository cryptoCurrencyRepository)
    {
        return new CurrencyViewModelFactory(cryptoCurrencyRepository);
    }
}
