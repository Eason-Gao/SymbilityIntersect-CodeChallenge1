package com.project.eason.cryptocharts.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.view.View;

import com.project.eason.cryptocharts.db.model.CryptoCurrency;

import java.util.ArrayList;
import java.util.List;

/**
 * Dao for inserting currencies into local db
 */

@Dao
public interface CurrencyDao
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllCurrencies(CryptoCurrency... cryptoCurrencies);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateCurrency(CryptoCurrency cryptoCurrency);

    @Query("SELECT * FROM CryptoCurrencies")
    List<CryptoCurrency> getAllCurrencies();
}
