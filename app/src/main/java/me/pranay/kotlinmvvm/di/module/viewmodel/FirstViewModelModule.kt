package me.pranay.kotlinmvvm.di.module.viewmodel

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import me.pranay.kotlinmvvm.di.common.ViewModelKey
import me.pranay.kotlinmvvm.viewmodel.FirstFragmentViewModel

@Module
abstract class FirstViewModelModule{
    @Binds
    @IntoMap
    @ViewModelKey(FirstFragmentViewModel::class)
    abstract fun bindFirstFragmentViewModel(firstFragmentViewModel: FirstFragmentViewModel):ViewModel
}