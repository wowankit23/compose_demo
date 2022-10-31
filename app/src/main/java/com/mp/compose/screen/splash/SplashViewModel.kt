package com.mp.compose.screen.splash

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mp.compose.DataStoreRepository
import com.mp.compose.Screen
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * SplashViewModel
 * Specifies where the splash screen will go to after finishing.
 */
class SplashViewModel @Inject constructor(
    private val repository: DataStoreRepository
): ViewModel() {

    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    /**
     * @Property _startDestination Specifies the destination of the splash screen
     */
    private val _startDestination: MutableState<String> = mutableStateOf(Screen.Login.route)
    init {
        viewModelScope.launch {
            repository.readOnBoardingState().collect { completed ->
                if (completed) {
                    _startDestination.value = Screen.Home.route
                } else {
                    _startDestination.value = Screen.Login.route
                }
            }
            _isLoading.value = false
        }
    }
}
