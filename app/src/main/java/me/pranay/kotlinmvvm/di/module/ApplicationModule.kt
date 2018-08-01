package me.pranay.kotlinmvvm.di.module

import dagger.Module
import dagger.Provides
import me.pranay.kotlinmvvm.helper.AppExecutors
import me.pranay.kotlinmvvm.di.common.ApplicationScope
import me.pranay.kotlinmvvm.di.module.fragment.FirstFragmentModule
import me.pranay.kotlinmvvm.di.module.viewmodel.FirstViewModelModule

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

}