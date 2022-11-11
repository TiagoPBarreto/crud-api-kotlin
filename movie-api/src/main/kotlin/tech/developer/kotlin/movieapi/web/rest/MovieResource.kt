package tech.developer.kotlin.movieapi.web.rest

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tech.developer.kotlin.movieapi.dto.MovieDto
import tech.developer.kotlin.movieapi.service.MovieService


@RestController
class MovieResource(
    private val movieService: MovieService
) {
    @PostMapping
    fun createMovie(@RequestBody movieDto: MovieDto):ResponseEntity<MovieDto>{
            return ResponseEntity(movieService.createMovie(movieDto),HttpStatus.CREATED)
    }
    @GetMapping
    fun getMovies():ResponseEntity<List<MovieDto>> =
         ResponseEntity.ok(movieService.getMovies())

    @GetMapping("/{id}")
    fun getMovie(@PathVariable id:Int) =
        ResponseEntity.ok(movieService.getMovie(id))

    @PutMapping
    fun updateMovie(@RequestBody movieDto: MovieDto):ResponseEntity<MovieDto> =
        ResponseEntity.ok(movieService.updateMovie(movieDto))

    @DeleteMapping("/{id}")
    fun deleteMovie(@PathVariable id: Int): ResponseEntity<Unit> =
        ResponseEntity(movieService.deleteMovie(id),HttpStatus.NO_CONTENT)
}