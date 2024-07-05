package ru.me.testplayertimer

import android.app.Application
import org.koin.core.context.startKoin
import ru.me.testplayertimer.di.viewModelModule

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(viewModelModule)
        }
    }
}