package tech.developer.kotlin.movieapi.repository

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import tech.developer.kotlin.movieapi.entity.Movie

interface MovieRepository: CrudRepository<Movie,Int>{

    @Query("SELECT m FROM Movie as m")
    fun getAllMovies():List<Movie>
}