package com.project.eason.cryptocharts.Components;

import com.project.eason.cryptocharts.activity.MainActivity;
import com.project.eason.cryptocharts.activity.SplashActivity;
import com.project.eason.cryptocharts.module.AppModule;
import com.project.eason.cryptocharts.module.RoomModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Eason on 2018-02-03.
 */

@Singleton
@Component(modules = {AppModule.class, RoomModule.class})
public interface AppComponent
{
    void inject(MainActivity mainActivity);

    void inject(SplashActivity splashActivity);
}
