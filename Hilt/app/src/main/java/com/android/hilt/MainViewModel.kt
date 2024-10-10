package com.android.hilt

import androidx.lifecycle.ViewModel
import com.android.hilt.repository.FirstRepository
import com.android.hilt.repository.SecondRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    first: FirstRepository,
    second: SecondRepository
): ViewModel() {
    private var _firstMessage = first.getMessage()
    val firstMessage get() = _firstMessage

    private var _secondMessage = second.getMessage()
    val secondMessage get() = _secondMessage
}