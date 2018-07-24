package me.pranay.kotlinmvvm.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import me.pranay.kotlinmvvm.App
import me.pranay.kotlinmvvm.di.common.ApplicationScope
import me.pranay.kotlinmvvm.di.module.ApplicationModule

@ApplicationScope
@Component(modules = [AndroidInjectionModule::class,
                      ApplicationModule::class])
interface ApplicationComponent{

        fun inject(application: App):Unit;

        @Component.Builder
        interface Builder{
            @BindsInstance
            fun application(application: Application):Builder

            fun build():ApplicationComponent
        }
}