package com.project.eason.cryptocharts;

import android.app.Application;

import com.project.eason.cryptocharts.Components.AppComponent;
import com.project.eason.cryptocharts.Components.DaggerAppComponent;
import com.project.eason.cryptocharts.module.AppModule;
import com.project.eason.cryptocharts.module.RoomModule;

/**
 * Application Class
 */

public class CryptoCharts extends Application
{
    private AppComponent appComponent;

    @Override
    public void onCreate()
    {
	super.onCreate();

	appComponent = DaggerAppComponent.builder()
	    .appModule(new AppModule("https://min-api.cryptocompare.com/"))
	    .roomModule(new RoomModule(this))
	    .build();
    }

    public AppComponent getAppComponent()
    {
	return appComponent;
    }
}
