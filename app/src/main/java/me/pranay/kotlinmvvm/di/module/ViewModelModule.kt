package me.pranay.kotlinmvvm.di.module

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import me.pranay.kotlinmvvm.Base.viewmodel.BaseViewModelFactory

@Module
abstract class ViewModelModule{
    @Binds
    abstract fun bindViewModelFactory(factory:BaseViewModelFactory):ViewModelProvider.Factory
}