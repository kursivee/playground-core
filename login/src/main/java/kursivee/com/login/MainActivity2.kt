package kursivee.com.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kursivee.com.login.ui.LoginModule
import kursivee.com.login.ui.main.MainFragment
import kursivee.com.login_data.LoginDataModule
import org.koin.core.context.loadKoinModules

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
        loadKoinModules(LoginDataModule.modules, LoginModule.modules)
    }

}
