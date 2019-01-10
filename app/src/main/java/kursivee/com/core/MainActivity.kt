package kursivee.com.core

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kursivee.com.navigation.ActivityLoader
import kursivee.com.network.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        startKoin {
            androidContext(this@MainActivity)
        }
        loadKoinModules(NetworkModule.modules)
        val intent = ActivityLoader.getIntent("kursivee.com.login.MainActivity2")
        intent?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        finish()
    }

}
