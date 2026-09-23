package com.example.placemark.models

import java.util.concurrent.atomic.AtomicLong

class PlacemarkMemStore {

    private val placemarks = ArrayList<PlacemarkModel>()
    private val lastId = AtomicLong(0L)

    fun findAll(): List<PlacemarkModel> {
        return placemarks
    }

    fun create(placemark: PlacemarkModel) {
        placemark.id = lastId.incrementAndGet()
        placemarks.add(placemark)
    }

    fun update(placemark: PlacemarkModel): Boolean {
        val foundPlacemark = findOne(placemark.id)
        return if (foundPlacemark != null) {
            val foundIndex = placemarks.indexOf(foundPlacemark)
            placemarks[foundIndex] = placemarks[foundIndex].copy(
                title = placemark.title,
                description = placemark.description,
                x = placemark.x,
                y = placemark.y,
            )
            true
        } else {
            false
        }
    }

    fun delete(id: Long): Boolean {
        val foundPlacemark = findOne(id)
        return if (foundPlacemark != null) {
            placemarks.remove(foundPlacemark)
            true
        } else {
            false
        }
    }

    fun findOne(id: Long): PlacemarkModel? {
        return placemarks.find { p -> p.id == id }
    }
}
