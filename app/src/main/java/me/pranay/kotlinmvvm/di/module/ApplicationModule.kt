package me.pranay.kotlinmvvm.di.module

import dagger.Module
import dagger.Provides
import me.pranay.kotlinmvvm.di.common.ApplicationScope

@Module(includes = [ViewModelModule::class])
class   ApplicationModule{
    enum class ApplicationMode {
        NORMAL, TESTING
    }

    @ApplicationScope
    @Provides
    fun provideApplicationMode(): ApplicationMode {
        return ApplicationMode.NORMAL
    }

}