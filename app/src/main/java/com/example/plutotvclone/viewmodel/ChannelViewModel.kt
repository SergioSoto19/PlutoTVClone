package com.example.plutotvclone.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.plutotvclone.model.Channel
import com.example.plutotvclone.state.UIState
import com.example.plutotvclone.R

class ChannelViewModel : ViewModel() {
    private val _uiState = MutableLiveData<UIState>()
    val uiState: LiveData<UIState> get() = _uiState

    init {
        loadChannels()
    }

    private fun loadChannels() {
        _uiState.value = UIState(
            isLoading = false,
            channels = listOf(
                Channel(R.string.channel_name_ac, R.drawable.cineaccion,R.drawable.conac),
                Channel(R.string.channel_name_Te, R.drawable.cineterror,R.drawable.cont),
                Channel(R.string.channel_name_Sus, R.drawable.cinesuspenso,R.drawable.consus),
                Channel(R.string.channel_name_Dra, R.drawable.cinedrama,R.drawable.condram),
                Channel(R.string.channel_name_Com, R.drawable.cinecomedia,R.drawable.conco),
                Channel(R.string.channel_name_Rom, R.drawable.cineromance,R.drawable.conroma),
                Channel(R.string.channel_name_So, R.drawable.southp,R.drawable.south),
                Channel(R.string.channel_name_Det, R.drawable.dea,R.drawable.condea),
                Channel(R.string.channel_name_Nar, R.drawable.naruto,R.drawable.conna),
            ),
            imageResId = R.drawable.south
        )
    }

    fun updateImage(imageResId: Int) {
        _uiState.value = _uiState.value?.copy(imageResId = imageResId)
    }
}
