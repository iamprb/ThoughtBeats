package me.pranay.kotlinmvvm.ui.entrypoint

import com.google.zxing.Result
import me.pranay.kotlinmvvm.Base.activity.AbstractNavigationController
import me.pranay.kotlinmvvm.R
import me.pranay.kotlinmvvm.ui.entrypoint.activity.MainActivity
import me.pranay.kotlinmvvm.ui.entrypoint.activity.QRCodeScanner
import me.pranay.kotlinmvvm.ui.entrypoint.fragment.FirstFragment
import javax.inject.Inject

class MainActivityNavigationController @Inject constructor(mainActivity: QRCodeScanner):
        AbstractNavigationController(mainActivity){
        override fun providerContainerId()= R.id.container

    fun navigateToFirstFragment(p0: Result?) {
        changeFragment(FirstFragment(),false)
        updateFragment()
    }
}