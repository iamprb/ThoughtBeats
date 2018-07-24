package me.pranay.kotlinmvvm.di.common

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope


@Scope
@Retention(RetentionPolicy.CLASS)
annotation class ApplicationScope
