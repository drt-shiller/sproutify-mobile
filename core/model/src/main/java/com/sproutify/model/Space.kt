package com.sproutify.model

data class Space(
    val spaceId: String,
    val spaceName: String,
    val imgUrl: String,
    val modules: List<Any>? = null
)