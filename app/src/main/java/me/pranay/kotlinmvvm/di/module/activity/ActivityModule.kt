package me.pranay.kotlinmvvm.di.module.activity

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.pranay.kotlinmvvm.di.module.fragment.FirstFragmentModule
import me.pranay.kotlinmvvm.ui.entrypoint.activity.MainActivity

@Module
abstract class ActivityModule{

   @ContributesAndroidInjector(modules = [FirstFragmentModule::class])
    abstract fun contributeMainActivity(): MainActivity

}