package com.kbcoding.cryptocurrency.core.presentation

import androidx.lifecycle.ViewModel
import com.kbcoding.cryptocurrency.core.common.Resource
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<T> : ViewModel() {

    protected val _stateFlow = MutableStateFlow<Resource<T>>(Resource.Loading())
    val stateFlow: StateFlow<Resource<T>> = _stateFlow

    protected val _exitChannel = Channel<Unit>()
    val exitChannel: ReceiveChannel<Unit> = _exitChannel

    protected fun handleResult(result: Resource<T>) {
        when (result) {
            is Resource.Success -> {
                _stateFlow.value = Resource.Success(result.data)
            }

            is Resource.Error -> {
                _stateFlow.value = Resource.Error(result.message)
                handleError()
            }

            is Resource.Loading -> {
                _stateFlow.value = Resource.Loading(result.data)
            }
        }
    }

    protected open fun handleError() {
        // implement in child class
    }
}