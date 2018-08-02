package me.pranay.kotlinmvvm.repository.firstFragmentRepository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import me.pranay.kotlinmvvm.database.dao.UserDao
import me.pranay.kotlinmvvm.database.table.UserDetails
import me.pranay.kotlinmvvm.helper.AppExecutors
import javax.inject.Inject

class FirstFragmentRepositoryImpl @Inject constructor(var appExecutors: AppExecutors,var userDao: UserDao):FirstFragmentRepository{

    override fun getUserdetails(): LiveData<List<UserDetails>> {
        val resourcesResponseMutableLiveData = MutableLiveData<List<UserDetails>>()
        appExecutors.diskOp.execute({
            val seedFeaturesList = userDao.getUserDetails()
            resourcesResponseMutableLiveData.postValue(seedFeaturesList)
        })
        return resourcesResponseMutableLiveData
        }

    override fun insertUserDetails() {
        val userDetail=UserDetails()
        appExecutors.diskOp.execute({
            userDetail.userAddress="Pune"
            userDetail.userContactDetails="user@anymail.com"
            userDetail.userDesignation="Android Developer"
            userDetail.userId=1
            userDetail.userName="User"

            userDao.insertUserData(userDetails = userDetail)
        })
    }
    override fun getToastString()="This is second fragment"
}