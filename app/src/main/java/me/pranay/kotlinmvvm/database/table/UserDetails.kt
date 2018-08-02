package me.pranay.kotlinmvvm.database.table

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class UserDetails{
    @PrimaryKey
    @ColumnInfo(name = "UserID")
    var userId:Long = 0
    @ColumnInfo(name = "UserName")
    lateinit var userName:String
    @ColumnInfo(name = "ContactDetails")
    lateinit var userContactDetails:String
    @ColumnInfo(name = "UserAddress")
    lateinit var userAddress:String
    @ColumnInfo(name = "UserDesignation")
    lateinit var userDesignation:String
}