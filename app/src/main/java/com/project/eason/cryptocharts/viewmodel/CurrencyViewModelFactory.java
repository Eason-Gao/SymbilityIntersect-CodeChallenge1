package com.project.eason.cryptocharts.viewmodel;

import android.arch.lifecycle.ViewModelProvider;

import com.project.eason.cryptocharts.repository.CryptoCurrencyRepository;

import javax.inject.Inject;

/**
 * Factory class for currency view model
 */

public class CurrencyViewModelFactory implements ViewModelProvider.Factory
{

    private CryptoCurrencyRepository cryptoCurrencyRepository;

    @Inject
    public CurrencyViewModelFactory(CryptoCurrencyRepository cryptoCurrencyRepository)
    {
	this.cryptoCurrencyRepository = cryptoCurrencyRepository;
    }

    @Override
    public CryptoCurrencyViewModel create(Class modelClass)
    {
	return new CryptoCurrencyViewModel(cryptoCurrencyRepository);
    }
}
