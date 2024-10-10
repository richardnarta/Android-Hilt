package com.android.hilt.repository

import com.android.hilt.utils.DummyData
import javax.inject.Inject

class FirstRepository @Inject constructor(
    private val dummy: DummyData
){
    fun getMessage(): String {
        return dummy.getFirstMessage()
    }
}