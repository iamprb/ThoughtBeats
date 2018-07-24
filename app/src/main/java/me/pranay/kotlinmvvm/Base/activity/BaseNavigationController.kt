package me.pranay.kotlinmvvm.Base.activity

import android.support.v4.app.FragmentManager

abstract class BaseNavigationController protected constructor(private val fragmentManager: FragmentManager)
{
     protected fun getFragmentManager():FragmentManager=fragmentManager
}
