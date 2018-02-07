package com.project.eason.cryptocharts.module;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.project.eason.cryptocharts.db.CryptoCurrencyDatabase;
import com.project.eason.cryptocharts.db.dao.CurrencyDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Provider Module for room related dependencies
 */

@Module
public class RoomModule
{

    private CryptoCurrencyDatabase cryptoCurrencyDatabase;


    public RoomModule(Application mApplication) {
        cryptoCurrencyDatabase = Room.databaseBuilder(mApplication, CryptoCurrencyDatabase.class, "CryptoCharts").allowMainThreadQueries().build();
    }

    @Singleton
    @Provides
    CryptoCurrencyDatabase providesCryptoCurrencyDatabase() {
        return cryptoCurrencyDatabase;
    }

    @Singleton
    @Provides
    CurrencyDao providesCurrencyDao(CryptoCurrencyDatabase cryptoCurrencyDatabase)
    {
        return cryptoCurrencyDatabase.getCurrencyDao();
    }
}
