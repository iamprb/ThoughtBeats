package me.pranay.kotlinmvvm.Base.activity

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.PersistableBundle
import me.pranay.kotlinmvvm.Base.viewmodel.AbstractViewModel
import javax.inject.Inject

abstract class AbstractMvvmActivity<VM:AbstractViewModel>:AbstractNormalActivity(){
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        var VM:ViewModel=ViewModelProviders.of(this,viewModelFactory).get(getViewModel());
    }

    abstract fun getViewModel(): Class<VM>


}

