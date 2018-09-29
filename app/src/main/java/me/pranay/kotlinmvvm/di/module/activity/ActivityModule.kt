package me.pranay.kotlinmvvm.di.module.activity

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.pranay.kotlinmvvm.di.module.fragment.FirstFragmentModule
import me.pranay.kotlinmvvm.ui.entrypoint.activity.MainActivity
import me.pranay.kotlinmvvm.ui.entrypoint.activity.QRCodeScanner

@Module
abstract class ActivityModule{

   @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [FirstFragmentModule::class])
    abstract fun contributeQRScannerActivity():QRCodeScanner

}