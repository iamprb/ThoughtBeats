package me.pranay.kotlinmvvm.ui.entrypoint.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import me.pranay.kotlinmvvm.Base.activity.AbstractNormalActivity
import me.pranay.kotlinmvvm.R
import me.pranay.kotlinmvvm.ui.entrypoint.AbstractBaseMainActivity
import me.pranay.kotlinmvvm.ui.entrypoint.MainActivityNavigationController
import javax.inject.Inject

class MainActivity : AbstractNormalActivity() {

//   @Inject lateinit var navController: MainActivityNavigationController
//
//    override fun getNavigationController(): MainActivityNavigationController =navController

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        navController.navigateToFirstFragment()
       tvresult = findViewById(R.id.tv_barcodeText)
        btn_codeScan.setOnClickListener {
            val intent = Intent(this,QRCodeScanner::class.java)
            startActivity(intent)
        }

    }

    companion object {

       lateinit var tvresult: TextView
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
