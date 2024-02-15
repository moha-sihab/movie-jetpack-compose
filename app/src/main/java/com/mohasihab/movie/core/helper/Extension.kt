package com.mohasihab.movie.core.helper

fun String.youtubeThumbnail(): String {
    return "https://img.youtube.com/vi/$this/0.jpg"
}