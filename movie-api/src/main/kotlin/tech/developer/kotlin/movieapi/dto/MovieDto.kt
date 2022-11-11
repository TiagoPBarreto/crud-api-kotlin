package tech.developer.kotlin.movieapi.dto

data class MovieDto(
    val id: Int = -1,
    var name: String = "Default Movie",
    var rating: Double
)
