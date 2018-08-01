package me.pranay.kotlinmvvm.viewmodel

import me.pranay.kotlinmvvm.Base.viewmodel.AbstractViewModel
import me.pranay.kotlinmvvm.repository.firstFragmentRepository.FirstFragmentRepositoryImpl
import javax.inject.Inject

class FirstFragmentViewModel @Inject constructor(var repository: FirstFragmentRepositoryImpl)
            : AbstractViewModel()
{

    fun getToastString()=repository.getToastString()

    override fun getViewModel()=this

}