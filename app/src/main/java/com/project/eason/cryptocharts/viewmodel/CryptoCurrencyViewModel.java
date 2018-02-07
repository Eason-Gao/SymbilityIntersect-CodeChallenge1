package com.project.eason.cryptocharts.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.project.eason.cryptocharts.db.model.CryptoCurrency;
import com.project.eason.cryptocharts.repository.CryptoCurrencyRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * View Model which handles currency data
 */

public class CryptoCurrencyViewModel extends ViewModel
{
    private MutableLiveData<List<CryptoCurrency>> currencies;

    private CryptoCurrencyRepository cryptoCurrencyRepository;

    @Inject
    public CryptoCurrencyViewModel(CryptoCurrencyRepository cryptoCurrencyRepository)
    {
	this.cryptoCurrencyRepository = cryptoCurrencyRepository;
	this.currencies = cryptoCurrencyRepository.getCryptoCurrencyListFromDB();
    }

    public void getCurrencyList()
    {
	cryptoCurrencyRepository.getCryptoCurrencyList();
    }

    public void insertCurrencyList(CryptoCurrency cryptoCurrency)
    {
	cryptoCurrencyRepository.insertCurrencytoDb(cryptoCurrency);
    }

    public LiveData<List<CryptoCurrency>> getCurrencyListFromDb()
    {
	return this.currencies;
    }

}
