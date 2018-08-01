package me.pranay.kotlinmvvm.di.module.fragment

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.pranay.kotlinmvvm.ui.entrypoint.fragment.FirstFragment

@Module
abstract class FirstFragmentModule{
    @ContributesAndroidInjector
    abstract fun contributeFirstFragment(): FirstFragment
}