package com.example.placemark.models

/**
 * Data class representing a single Placemark item.
 * Kotlin automatically generates toString(), equals(), hashCode(), and copy().
 */

data class PlacemarkModel (
    var id: Long = 0L,
    var title: String = "",
    var description: String = "",
    val x: Float = 0.0f,
    val y: Float = 0.0f

)