package com.project.eason.cryptocharts.db;

import android.arch.persistence.room.Database;

import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.project.eason.cryptocharts.db.dao.CurrencyDao;
import com.project.eason.cryptocharts.db.model.CryptoCurrency;

/**
 * Database for CryptoCurrencies
 */

@Database(entities = {CryptoCurrency.class}, version = 1)
@TypeConverters({})
public abstract class CryptoCurrencyDatabase extends RoomDatabase
{
	public abstract CurrencyDao getCurrencyDao();
}
