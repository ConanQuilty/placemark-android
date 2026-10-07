package com.example.placemark

/**
 * Data class representing a single Placemark item.
 * Kotlin automatically generates toString(), equals(), hashCode(), and copy().
 */

data class PlacemarkModel (
    var id: Long = 0L,
    var title: String = "",
    var desc: String = "",
    val x: Double = 0.0,
    val y: Double = 0.0

)