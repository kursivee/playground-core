package kursivee.com.login.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.login_fragment.*
import kursivee.com.login.R
import kursivee.com.login_data.LoginRepository
import kursivee.com.navigation.ActivityLoader
import org.koin.android.ext.android.inject

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    val vm: MainViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
        vm.getSession().observe(this, Observer {
            val intent = ActivityLoader.getIntent("kursivee.com.feature.FeatureActivity")
            startActivity(intent)
        })
        login_btn.setOnClickListener {
            vm.login()
        }
    }

}
