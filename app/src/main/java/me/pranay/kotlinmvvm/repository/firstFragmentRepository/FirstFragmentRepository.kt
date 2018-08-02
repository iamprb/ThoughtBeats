package me.pranay.kotlinmvvm.repository.firstFragmentRepository

import android.arch.lifecycle.LiveData
import me.pranay.kotlinmvvm.database.table.UserDetails

interface FirstFragmentRepository {
    fun getToastString():String
    fun insertUserDetails()
    fun getUserdetails():LiveData< List<UserDetails>>
}