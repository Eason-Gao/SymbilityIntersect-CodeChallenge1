package com.project.eason.cryptocharts;

import android.app.Application;

import com.project.eason.cryptocharts.Components.AppComponent;
import com.project.eason.cryptocharts.Components.DaggerAppComponent;

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
	    .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
