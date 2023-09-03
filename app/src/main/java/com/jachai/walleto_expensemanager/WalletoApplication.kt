package com.jachai.walleto_expensemanager

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WalletoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}