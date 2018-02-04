package com.project.eason.cryptocharts.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.view.View;

import com.project.eason.cryptocharts.repository.CryptoCurrencyRepository;

import javax.inject.Inject;

/**
 * Created by Eason on 2018-02-03.
 */

public class CryptoCurrencyViewModel extends ViewModel
{
    private CryptoCurrencyRepository cryptoCurrencyRepository;

    @Inject
    public CryptoCurrencyViewModel(CryptoCurrencyRepository cryptoCurrencyRepository) { this.cryptoCurrencyRepository = cryptoCurrencyRepository;}

}
