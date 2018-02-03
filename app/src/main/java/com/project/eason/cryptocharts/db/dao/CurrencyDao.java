package com.project.eason.cryptocharts.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Update;
import android.view.View;

import com.project.eason.cryptocharts.db.model.CryptoCurrency;

/**
 * Dao for inserting currencies into local db
 */

@Dao
public interface CurrencyDao
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCurrency(CryptoCurrency cryptoCurrency);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateCurrency(CryptoCurrency cryptoCurrency);
}
