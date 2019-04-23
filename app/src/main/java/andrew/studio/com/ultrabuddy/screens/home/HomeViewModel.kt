package andrew.studio.com.ultrabuddy.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private var _showSnackbarEvent = MutableLiveData<Boolean>()
    val showSnackbarEvent: LiveData<Boolean>
        get() = _showSnackbarEvent
    fun doneShowSnackbar() {
        _showSnackbarEvent.value = false
    }

    fun onFabClick() {
        _showSnackbarEvent.value = true
    }
}