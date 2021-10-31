package com.ardroid.rentalio

data class BannerModel(
    val name: String,
    val image: Int
)

val bannerList = listOf(
    BannerModel("Banner 1", R.drawable.banner_slider_1),
    BannerModel("Banner 2", R.drawable.banner_slider_2),
)