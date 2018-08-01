package me.pranay.kotlinmvvm.ui.entrypoint

import me.pranay.kotlinmvvm.Base.activity.AbstractNavigationController
import me.pranay.kotlinmvvm.R
import me.pranay.kotlinmvvm.ui.entrypoint.activity.MainActivity
import me.pranay.kotlinmvvm.ui.entrypoint.fragment.FirstFragment
import javax.inject.Inject

class MainActivityNavigationController @Inject constructor(mainActivity: MainActivity):
        AbstractNavigationController(mainActivity){
        override fun providerContainerId()= R.id.container

    fun navigateToFirstFragment(){
        changeFragment(FirstFragment(),false)
        updateFragment()
    }
}