package com.example.beatbox

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class SoundViewModelTest {
    private lateinit var beatBox: BeatBox
    @get:Rule
    var rule = InstantTaskExecutorRule()
    private lateinit var sound: Sound
    private lateinit var subject:SoundViewModel

    @Before
    fun setUp() {
        beatBox = mock(BeatBox::class.java)
        sound = Sound("assetPath")
        subject = SoundViewModel(beatBox)
        subject.sound = sound
    }
    @Test
    fun exposesSoundNameAsTitle(){
        val value = subject.title
            assertThat(value.value, (`is`(sound.name)))
    }

    @Test
    fun callsBeatBoxPlayOnButtonClicked(){
        subject.onButtonClicked()
        verify(beatBox).play(sound)
    }
}