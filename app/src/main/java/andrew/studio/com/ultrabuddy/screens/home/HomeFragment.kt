package andrew.studio.com.ultrabuddy.screens.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import andrew.studio.com.ultrabuddy.R
import andrew.studio.com.ultrabuddy.databinding.FragmentHomeBinding
import andrew.studio.com.ultrabuddy.screens.splash.SplashViewModel
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false
        )
        (activity as AppCompatActivity).setSupportActionBar(binding.topToolbar)

        val homeViewModel = HomeViewModel()
        binding.homeViewModel = homeViewModel
        binding.setLifecycleOwner(this)

        homeViewModel.showSnackbarEvent.observe(this, Observer {
            if (it == true) {
                Snackbar.make(binding.layoutParent,
                    getString(R.string.text_test_snackbar),
                    Snackbar.LENGTH_SHORT).setAction(getString(android.R.string.ok), {}).show()
                homeViewModel.doneShowSnackbar()
            }
        })

        return binding.root
    }


}
