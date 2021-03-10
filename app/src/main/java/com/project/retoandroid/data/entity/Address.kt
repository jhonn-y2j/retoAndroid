package com.project.retoandroid.data.entity

import java.io.Serializable

data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val geo: Coordinate
): Serializable

data class Coordinate(
    val lat: Float,
    val lng: Float
): Serializable