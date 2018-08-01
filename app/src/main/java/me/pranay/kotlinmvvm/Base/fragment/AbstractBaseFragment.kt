package me.pranay.kotlinmvvm.Base.fragment

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import me.pranay.kotlinmvvm.Base.viewmodel.AbstractViewModel
import javax.inject.Inject

abstract class AbstractBaseFragment<VM:AbstractViewModel>:Fragment(),InjectableFragment,FragmentUiTransaction {


    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    internal lateinit var viewModel:VM


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(getViewModel())

    }

    protected abstract fun getViewModel():Class<VM>
    override fun onFragmentBackPress()=false

}