package me.pranay.kotlinmvvm.Base.viewmodel

import android.arch.lifecycle.ViewModel

abstract class AbstractViewModel:ViewModel(){
    abstract fun getViewModel():ViewModel
}