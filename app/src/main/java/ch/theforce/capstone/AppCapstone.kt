package ch.theforce.capstone

import android.app.Application
import ch.theforce.capstone.network.UnSplashHttpClient
import ch.theforce.capstone.network.UnSplashHttpClientImpl
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module
import timber.log.Timber

/**
 * Bootstrap class for the app
 */
class AppCapstone : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        startKoin {
            androidContext(this@AppCapstone)
            modules(module {
                single<UnSplashHttpClient> { UnSplashHttpClientImpl }
            })
        }
    }
}
