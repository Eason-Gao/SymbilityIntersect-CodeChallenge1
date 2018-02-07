package com.project.eason.cryptocharts.asynctask;

import android.os.AsyncTask;

import com.project.eason.cryptocharts.viewmodel.CryptoCurrencyViewModel;

/**
 * Asynctask to handle api and database read/write
 */

public class CurrencyAsyncTask extends AsyncTask<Void, Void, Void>
{

    private final CryptoCurrencyViewModel cryptoCurrencyViewModel;

    public CurrencyAsyncTask(CryptoCurrencyViewModel cryptoCurrencyViewModel)
    {
	this.cryptoCurrencyViewModel = cryptoCurrencyViewModel;
    }

    @Override
    protected Void doInBackground(Void... voids)
    {
	cryptoCurrencyViewModel.getCurrencyList();
	return null;
    }
}
