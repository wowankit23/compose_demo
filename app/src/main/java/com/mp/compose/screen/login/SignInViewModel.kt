package com.mp.compose.screen.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mp.compose.event.UIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
) : ViewModel() {


    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private val _showLoading = mutableStateOf(false)
    val showLoading: State<Boolean> = _showLoading


    suspend fun signInUser() {

        _eventFlow.emit(
            UIEvent.GoNext()
        )
    }

    fun changePassWordVisibility(visible : Boolean){
    }

    fun resetPassword(){
    }
}
