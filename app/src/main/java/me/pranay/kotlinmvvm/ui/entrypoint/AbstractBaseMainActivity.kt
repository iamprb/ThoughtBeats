package me.pranay.kotlinmvvm.ui.entrypoint

import me.pranay.kotlinmvvm.Base.activity.AbstractNormalActivity

abstract class AbstractBaseMainActivity:AbstractNormalActivity(){

    interface UiInteraction{
        fun getNavigationController():MainActivityNavigationController
    }
}