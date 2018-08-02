package me.pranay.kotlinmvvm.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import me.pranay.kotlinmvvm.database.table.UserDetails

@Dao
interface UserDao {
    @Query("SELECT * from userdetails")
    fun getUserDetails():List<UserDetails>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserData(userDetails: UserDetails)
}