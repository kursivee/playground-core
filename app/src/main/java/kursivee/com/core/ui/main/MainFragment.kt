package kursivee.com.core.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.main_fragment.*
import kursivee.com.core.R
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainFragment : Fragment() {

    private lateinit var vm: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViewModel()
        initOnClickHandlers()
    }

    private fun initOnClickHandlers() {
        login_btn.setOnClickListener {
            vm.login()
        }
        data_btn.setOnClickListener {
            vm.data()
        }
    }

    private fun initViewModel() {
        vm = getViewModel()
        vm.getSession().observe(this, Observer {
            message.text = it.session
        })
        vm.data.observe(this, Observer {
            data_tv.text = it.session
        })
    }

}
