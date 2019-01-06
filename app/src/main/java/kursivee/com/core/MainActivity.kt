package kursivee.com.core

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kursivee.com.core.service.data.di.dataModule
import kursivee.com.core.service.di.coreModule
import kursivee.com.core.service.login.di.loginModule
import kursivee.com.core.service.di.networkModule
import org.koin.android.ext.android.startKoin

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        startKoin(this, listOf(coreModule, networkModule, loginModule, dataModule))
    }

}
