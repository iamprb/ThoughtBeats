package me.pranay.kotlinmvvm.ui.entrypoint.fragment

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.google.zxing.Result
import kotlinx.android.synthetic.main.fragment_first.*
import me.pranay.kotlinmvvm.Base.fragment.AbstractBaseFragment
import me.pranay.kotlinmvvm.R
import me.pranay.kotlinmvvm.viewmodel.FirstFragmentViewModel
import javax.inject.Inject


class FirstFragment : AbstractBaseFragment<FirstFragmentViewModel>() {

    lateinit var  QROutput:String
    public fun FirstFragment(p0: Result?){
        QROutput= p0.toString()
    }
    override fun getViewModel()=FirstFragmentViewModel::class.java

    @Inject
    lateinit var viewModels:FirstFragmentViewModel
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Toast.makeText(context,viewModels.getToastString(),Toast.LENGTH_SHORT).show()
        viewModels.insertUserDetails()
        viewModels.getUserDetails().observe(this , Observer{ userDetail ->
            if(userDetail!=null && !userDetail.isEmpty()){
                tv_address.text=userDetail[userDetail.size-1].userDesignation
            }
        })



    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    companion object {
        var  tv_address :TextView?=null
    }
}
