package com.example.a4kwallpapersapi.models

import com.google.gson.annotations.SerializedName

data class TopicSubmissionsX(
    val animals: Animals,
    @SerializedName("color-of-water") val color_of_water: ColorOfWater,
    val nature: Nature,
    val wallpapers: WallpapersX
)