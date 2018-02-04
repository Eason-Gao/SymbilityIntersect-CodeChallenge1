package com.project.eason.cryptocharts.Components;

import com.project.eason.cryptocharts.MainActivity;
import com.project.eason.cryptocharts.module.ApiModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Eason on 2018-02-03.
 */

@Singleton
@Component(modules = {ApiModule.class})
public interface AppComponent
{
    void inject(MainActivity mainActivity);
}
