package andrew.studio.com.ultrabuddy.screens.splash


import andrew.studio.com.ultrabuddy.R
import andrew.studio.com.ultrabuddy.databinding.FragmentSplashBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentSplashBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_splash, container, false)

        val splashViewModel = SplashViewModel()
        binding.splashViewModel = splashViewModel
        binding.setLifecycleOwner(this)

        splashViewModel.navigateToHome.observe(this, Observer {
            if (it == true) {
                this.findNavController()
                    .navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
                splashViewModel.doneNavigateToHome()
            }
        })

        return binding.root
    }


}
