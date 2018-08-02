package me.pranay.kotlinmvvm.di.module

import android.app.Application
import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import me.pranay.kotlinmvvm.R
import me.pranay.kotlinmvvm.database.AppDatabase
import me.pranay.kotlinmvvm.di.common.ApplicationScope
import me.pranay.kotlinmvvm.di.module.fragment.FirstFragmentModule
import me.pranay.kotlinmvvm.di.module.viewmodel.FirstViewModelModule
import me.pranay.kotlinmvvm.helper.AppExecutors
import java.io.File

@Module(includes = [ViewModelModule::class,
                    FirstFragmentModule::class,
                    FirstViewModelModule::class])
class   ApplicationModule{
    enum class ApplicationMode {
        NORMAL, TESTING
    }

    @ApplicationScope
    @Provides
    fun provideApplicationMode(): ApplicationMode {
        return ApplicationMode.NORMAL
    }

    @ApplicationScope
    @Provides
    internal fun provideExecutor(): AppExecutors {
        return AppExecutors()
    }

    @ApplicationScope
    @Provides
    internal fun provideDatabase(application: Application): AppDatabase {
        var dbPath: String
        if (application.getExternalFilesDir(null) != null) {
            dbPath = application.getExternalFilesDir(null)!!.path
        } else {
            dbPath = application.filesDir.path
        }
        dbPath = dbPath + File.separator + application.getString(R.string.database_name)


        return Room.databaseBuilder(application, AppDatabase::class.java, dbPath)
                .build()
    }

    @ApplicationScope
    @Provides
    fun provideUserDao(appDatabase:AppDatabase)=appDatabase.provideUserDetails()


}