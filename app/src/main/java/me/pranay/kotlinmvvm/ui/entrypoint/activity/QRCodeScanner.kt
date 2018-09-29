package me.pranay.kotlinmvvm.ui.entrypoint.activity

import android.app.FragmentManager
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.Toast
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView
import me.pranay.kotlinmvvm.Base.activity.AbstractNormalActivity
import me.pranay.kotlinmvvm.ui.entrypoint.AbstractBaseMainActivity
import me.pranay.kotlinmvvm.ui.entrypoint.MainActivityNavigationController
import javax.inject.Inject

class QRCodeScanner : AbstractNormalActivity(),ZXingScannerView.ResultHandler ,AbstractBaseMainActivity.UiInteraction{
    @Inject
    lateinit var navController: MainActivityNavigationController

    override fun getNavigationController(): MainActivityNavigationController =navController


    private var mScannerView:ZXingScannerView?=null
    override fun handleResult(p0: Result?) {
      //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        MainActivity.tvresult.setText(p0!!.text)
        onBackPressed()
        //navController.navigateToFirstFragment(p0)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            101->{

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupPermission()
        mScannerView = ZXingScannerView(applicationContext)
        setContentView(mScannerView)
    }

    private fun setupPermission(){
        val permission =ContextCompat.checkSelfPermission(this,android.Manifest.permission.CAMERA)
        if(permission!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA),101)
        }
    }

    override fun onResume() {
        super.onResume()
        mScannerView!!.setResultHandler(this)
        mScannerView!!.startCamera()
    }

    override fun onPause() {
        super.onPause()
        mScannerView!!.stopCamera()
    }

}
