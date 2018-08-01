package me.pranay.kotlinmvvm.Base.activity

import android.support.v4.app.Fragment

abstract class AbstractFragmentNavigationController(private var fragment:Fragment)
            :BaseNavigationController(fragment.childFragmentManager){

}