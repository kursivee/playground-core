package kursivee.com.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kursivee.com.feature_data.FeatureDataModule
import org.koin.core.context.loadKoinModules

class FeatureActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_activity)
    }

}
