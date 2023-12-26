package com.example.pam9

import android.app.Application
import com.example.pam9.repository.AppContainer
import com.example.pam9.repository.KontakContainer

class KontakAplikation : Application(){
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = KontakContainer()
    }
}