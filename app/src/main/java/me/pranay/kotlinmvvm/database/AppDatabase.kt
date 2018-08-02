package me.pranay.kotlinmvvm.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import me.pranay.kotlinmvvm.database.dao.UserDao
import me.pranay.kotlinmvvm.database.table.UserDetails

@Database(entities = [UserDetails::class],version = 1,exportSchema = false)
abstract class AppDatabase:RoomDatabase(){

    abstract fun provideUserDetails():UserDao
}
