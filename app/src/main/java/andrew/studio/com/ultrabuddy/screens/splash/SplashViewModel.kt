package andrew.studio.com.ultrabuddy.screens.splash

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SplashViewModel() : ViewModel() {
    init {
        initTimeCounter()
    }

    private fun initTimeCounter() {
        Handler(). also {
            it.postDelayed({
                _navigateToHome.value = true
            }, 1000L)
        }
    }

    private var _navigateToHome = MutableLiveData<Boolean?>()
    val navigateToHome: LiveData<Boolean?>
        get() = _navigateToHome

    fun doneNavigateToHome() {
        _navigateToHome.value = null
    }
}