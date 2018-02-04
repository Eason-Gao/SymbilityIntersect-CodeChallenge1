package com.project.eason.cryptocharts.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.project.eason.cryptocharts.repository.CryptoCurrencyRepository;

import javax.inject.Inject;

/**
 * View Model which handles currency data
 */

public class CryptoCurrencyViewModel extends ViewModel
{
    private CryptoCurrencyRepository cryptoCurrencyRepository;

    @Inject
    public CryptoCurrencyViewModel(CryptoCurrencyRepository cryptoCurrencyRepository) { this.cryptoCurrencyRepository = cryptoCurrencyRepository;}

}
