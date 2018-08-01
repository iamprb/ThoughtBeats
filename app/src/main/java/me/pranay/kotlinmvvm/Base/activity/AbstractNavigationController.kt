package me.pranay.kotlinmvvm.Base.activity

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

abstract class AbstractNavigationController(private var activity: AppCompatActivity)
            : BaseNavigationController(activity.supportFragmentManager){
    private  var fragmentToChange:Fragment?=null
    private var isBackStack=false


    protected fun changeFragment( fragment: Fragment,addToBackStack:Boolean){
        this.fragmentToChange=fragment
        this.isBackStack=addToBackStack
    }
    protected fun updateFragment(){
        if(this.fragmentToChange==null){
            return
        }
        val backstackName= this.fragmentToChange?.javaClass?.simpleName
        val isPop = getFragmentManager().popBackStackImmediate(backstackName,0)
        if(!isPop){
            val fragmentTransaction=getFragmentManager().beginTransaction()
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            fragmentTransaction.replace(providerContainerId(),this.fragmentToChange,backstackName)
            if(this.isBackStack){
                fragmentTransaction.addToBackStack(backstackName)
            }
            fragmentTransaction.commit()
        }
        this.fragmentToChange=null
        this.isBackStack=false
    }

    protected fun updateFragment(fragment:Fragment,backstackName:String){
      val  fragmentTransaction = getFragmentManager().beginTransaction()
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        fragmentTransaction.replace(providerContainerId(),fragment,backstackName)
        fragmentTransaction.addToBackStack(backstackName)
        fragmentTransaction.commit()
    }

    fun popStackInclusive(backstackName: String){
        getFragmentManager().popBackStackImmediate(backstackName,FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
    fun popStackImmediate(backstackName: String){
        getFragmentManager().popBackStackImmediate(backstackName,0)
    }
    fun popStackImmediate(){
        getFragmentManager().popBackStackImmediate()
    }
    @IdRes
    abstract fun providerContainerId(): Int
    //Return type is AppCompatActivity
    fun getActivity()=activity
}