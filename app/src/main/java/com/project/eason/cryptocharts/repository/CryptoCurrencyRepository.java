package com.project.eason.cryptocharts.repository;

import android.provider.ContactsContract;

import com.project.eason.cryptocharts.db.CryptoCurrencyDatabase;
import com.project.eason.cryptocharts.db.dao.CurrencyDao;

import javax.inject.Inject;

/**
 * Created by Eason on 2018-02-03.
 */

public class CryptoCurrencyRepository
{
    private final CurrencyDao currencyDao;

    @Inject
    public CryptoCurrencyRepository(CryptoCurrencyDatabase database){
        this.currencyDao = database.getCurrencyDao();
    }
}
