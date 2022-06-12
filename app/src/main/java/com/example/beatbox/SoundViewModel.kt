package com.example.beatbox

import androidx.lifecycle.MutableLiveData

class SoundViewModel(private val beatBox: BeatBox) {
    init {
    }
    fun onButtonClicked() {
        sound?.let {
            beatBox.play(it)
        }
    }

    val title: MutableLiveData<String?> = MutableLiveData()

    var sound: Sound? = null
    set(sound) {
        field = sound
        title.postValue(sound?.name)
    }

}