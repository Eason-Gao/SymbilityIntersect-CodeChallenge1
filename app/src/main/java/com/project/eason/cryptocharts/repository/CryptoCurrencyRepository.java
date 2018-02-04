package com.project.eason.cryptocharts.repository;

import android.provider.ContactsContract;

import com.project.eason.cryptocharts.db.CryptoCurrencyDatabase;
import com.project.eason.cryptocharts.db.dao.CurrencyDao;
import com.project.eason.cryptocharts.db.model.CryptoCurrency;

import javax.inject.Inject;

/**
 * Repository for inserting/updating currencies
 */

public class CryptoCurrencyRepository
{
    private final CurrencyDao currencyDao;

    @Inject
    public CryptoCurrencyRepository(CryptoCurrencyDatabase database){
        this.currencyDao = database.getCurrencyDao();
    }

    public void insertCurrencytoDb (CryptoCurrency cryptoCurrency)
    {
        currencyDao.insertCurrency(cryptoCurrency);
    }

    public void updateCurrencyInDb (CryptoCurrency cryptoCurrency)
    {
        currencyDao.updateCurrency(cryptoCurrency);
    }
}
