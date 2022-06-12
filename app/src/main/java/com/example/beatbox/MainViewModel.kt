package com.example.beatbox

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    lateinit var beatBox: BeatBox
    val playSpeed: MutableLiveData<Float> = MutableLiveData(1f)

    private fun setPlaySpeed(speed: Float) {
        playSpeed.postValue(speed)
        beatBox.speed = speed
    }

    override fun onCleared() {
        super.onCleared()
        beatBox.release()
    }
    fun onProgressChanged(
        progress: Int
    ) {
        setPlaySpeed(progress / 100.0f * 2)
    }
}