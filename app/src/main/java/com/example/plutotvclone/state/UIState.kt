package com.example.plutotvclone.state

import com.example.plutotvclone.model.Channel

data class UIState(
    val isLoading: Boolean = true,
    val channels: List<Channel> = emptyList(),
    val imageResId: Int? = null
)
