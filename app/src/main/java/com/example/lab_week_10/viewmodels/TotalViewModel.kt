package com.example.lab_week_10.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TotalViewModel : ViewModel() {

    private val _total = MutableLiveData<Int>()
    val total: LiveData<Int> = _total

    private val _timestamp = MutableLiveData<Long>()
    val timestamp: LiveData<Long> = _timestamp

    init {
        _total.postValue(0)
        _timestamp.postValue(System.currentTimeMillis())
    }

    fun incrementTotal() {
        _total.postValue(_total.value?.plus(1))
        _timestamp.postValue(System.currentTimeMillis())
    }

    fun setInitialValue(total: Int, time: Long) {
        _total.postValue(total)
        _timestamp.postValue(time)
    }
}
