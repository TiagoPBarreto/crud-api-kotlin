package tech.developer.kotlin.movieapi.entity

import javax.persistence.*

@Entity
class Movie(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    var name: String,
    var rating: Double
) {

}