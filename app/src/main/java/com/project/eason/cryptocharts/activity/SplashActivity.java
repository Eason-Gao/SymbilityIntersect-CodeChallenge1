package com.project.eason.cryptocharts.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.project.eason.cryptocharts.CryptoCharts;
import com.project.eason.cryptocharts.R;
import com.project.eason.cryptocharts.asynctask.CurrencyAsyncTask;
import com.project.eason.cryptocharts.viewmodel.CryptoCurrencyViewModel;
import com.project.eason.cryptocharts.viewmodel.CurrencyViewModelFactory;

import javax.inject.Inject;

import butterknife.OnClick;

/**
 * splash activity
 */

public class SplashActivity extends AppCompatActivity
{
    @Inject
    CurrencyViewModelFactory currencyViewModelFactory;

    private CryptoCurrencyViewModel cryptoCurrencyViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
	super.onCreate(savedInstanceState);

	((CryptoCharts) getApplication()).getAppComponent().inject(this);
	setContentView(R.layout.activity_splash);

	getCurrencies();
    }

    private void getCurrencies()
    {
	cryptoCurrencyViewModel = ViewModelProviders.of(this, currencyViewModelFactory).get(CryptoCurrencyViewModel.class);
	CurrencyAsyncTask currencyAsyncTask = new CurrencyAsyncTask(cryptoCurrencyViewModel);
	currencyAsyncTask.execute();
    }

    @OnClick(R.id.main_activity)
    public void launchMainActivity()
    {
	Intent intent = new Intent(this, MainActivity.class);
	startActivity(intent);
    }
}
