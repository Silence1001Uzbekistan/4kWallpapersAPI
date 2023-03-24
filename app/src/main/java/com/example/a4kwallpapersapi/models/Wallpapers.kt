package com.example.a4kwallpapersapi.models

data class Wallpapers(
    val results: List<Result>,
    val total: Int,
    val total_pages: Int
)