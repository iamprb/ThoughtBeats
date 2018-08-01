package me.pranay.kotlinmvvm.ui.entrypoint.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import me.pranay.kotlinmvvm.Base.fragment.AbstractBaseFragment
import me.pranay.kotlinmvvm.R
import me.pranay.kotlinmvvm.viewmodel.FirstFragmentViewModel
import javax.inject.Inject


class FirstFragment : AbstractBaseFragment<FirstFragmentViewModel>() {
    override fun getViewModel()=FirstFragmentViewModel::class.java

    @Inject
    lateinit var viewModels:FirstFragmentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Toast.makeText(context,viewModels.getToastString(),Toast.LENGTH_SHORT).show()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

}
