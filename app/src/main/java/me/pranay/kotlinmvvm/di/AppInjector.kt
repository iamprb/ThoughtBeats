package me.pranay.kotlinmvvm.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import me.pranay.kotlinmvvm.App
import me.pranay.kotlinmvvm.Base.fragment.InjectableFragment
import me.pranay.kotlinmvvm.di.component.DaggerApplicationComponent

class AppInjector{


        fun initialize(application:App){
            DaggerApplicationComponent
                    .builder()
                    .application(application)
                    .build()
                    .inject(application)

            application.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
                override fun onActivityCreated(activity: Activity, bundle: Bundle?) {
                    injectActivity(activity)
                }

                override fun onActivityStarted(activity: Activity) {
                    // empty method
                }

                override fun onActivityResumed(activity: Activity) {
                    // empty method
                }

                override fun onActivityPaused(activity: Activity) {
                    // empty method
                }

                override fun onActivityStopped(activity: Activity) {
                    // empty method
                }

                override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle) {
                    // empty method
                }

                override fun onActivityDestroyed(activity: Activity) {
                    // empty method
                }
            })
        }


     fun injectActivity(activity: Activity) {
        if (activity is HasSupportFragmentInjector) {
            AndroidInjection.inject(activity)
        }

        if (activity is FragmentActivity) {
            activity.supportFragmentManager
                    .registerFragmentLifecycleCallbacks(
                            object : FragmentManager.FragmentLifecycleCallbacks() {
                                override fun onFragmentCreated(fm: FragmentManager?, f: Fragment?, savedInstanceState: Bundle?) {
                                    if (f is InjectableFragment) {
                                        AndroidSupportInjection.inject(f)
                                    }
                                }
                            }, true)
        }
    }
}