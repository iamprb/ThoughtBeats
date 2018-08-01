package me.pranay.kotlinmvvm.ui.entrypoint.activity

import android.os.Bundle
import me.pranay.kotlinmvvm.Base.activity.AbstractNormalActivity
import me.pranay.kotlinmvvm.R
import me.pranay.kotlinmvvm.ui.entrypoint.AbstractBaseMainActivity
import me.pranay.kotlinmvvm.ui.entrypoint.MainActivityNavigationController
import javax.inject.Inject

class MainActivity : AbstractNormalActivity(),AbstractBaseMainActivity.UiInteraction {

   @Inject lateinit var navController: MainActivityNavigationController

    override fun getNavigationController(): MainActivityNavigationController =navController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController.navigateToFirstFragment()
    }

//   override fun onBackPressed() {
//       try{
//           val fragmentBackPress:FragmentUiTransaction=supportFragmentManager.fragments
//                   .get(supportFragmentManager.fragments.size-1) as FragmentUiTransaction
//           if(!fragmentBackPress.onFragmentBackPress()){
//               if(supportFragmentManager.backStackEntryCount==1){
//                   finish()
//               }else{
//                   super.onBackPressed()
//               }
//           }
//       }catch (e:Exception){
//           Log.e("exception",e.localizedMessage)
//       }
//
//    }
}
