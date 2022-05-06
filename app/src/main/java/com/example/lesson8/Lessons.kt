package com.example.lesson8

import java.io.Serializable

data class Lessons(
    var lessonName : String? = null,
    var lessonImage: String? = null,
    var color: Int? = null,
    var textColor: Int? = null
) : Serializable
