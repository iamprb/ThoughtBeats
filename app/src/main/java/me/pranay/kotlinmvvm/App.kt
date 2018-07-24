package me.pranay.kotlinmvvm

import android.app.Activity
import android.app.Service
import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasServiceInjector
import me.pranay.kotlinmvvm.di.AppInjector
import javax.inject.Inject

class App : MultiDexApplication(),HasActivityInjector,HasServiceInjector{

    @Inject lateinit var dispatchingAndroidInjector:DispatchingAndroidInjector<Activity>
    @Inject lateinit var dispatchingAndroidServiceInjector:DispatchingAndroidInjector<Service>

    override fun onCreate() {
        super.onCreate()
        //AppInjector to be initialized here
        AppInjector().initialize(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun activityInjector()=dispatchingAndroidInjector

    override fun serviceInjector()=dispatchingAndroidServiceInjector

}