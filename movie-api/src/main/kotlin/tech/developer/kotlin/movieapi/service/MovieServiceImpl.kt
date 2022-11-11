package tech.developer.kotlin.movieapi.service

import org.springframework.data.jpa.domain.AbstractPersistable
import org.springframework.data.jpa.domain.AbstractPersistable_
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.stereotype.Service
import tech.developer.kotlin.movieapi.dto.MovieDto
import tech.developer.kotlin.movieapi.repository.MovieRepository
import tech.developer.kotlin.movieapi.utils.exceptions.MovieException
import tech.developer.kotlin.movieapi.utils.mapper.MovieMapper

@Service
class MovieServiceImpl(
    private val movieRepository: MovieRepository,
    private val movieMapper: MovieMapper
) : MovieService {
    override fun createMovie(movieDto: MovieDto): MovieDto {

        if(movieDto.id != -1)
            throw MovieException("Id must be null or -1")

        val movie =  movieRepository.save(movieMapper.toEntity(movieDto))
        return movieMapper.fromEntity(movie)
    }

    override fun getMovies(): List<MovieDto> {
        val movies = movieRepository.getAllMovies()
            if (movies.isEmpty())
                throw MovieException("List of movie is empty")
        return movies.map {
            movieMapper.fromEntity(it)
        }
    }

    override fun getMovie(id: Int): MovieDto{
        val optionalMovie = movieRepository.findById(id)
        val movie = optionalMovie.orElseThrow{ MovieException("Movie with id $id is not present") }
        return  movieMapper.fromEntity(movie)
    }

    override fun updateMovie(movieDto: MovieDto): MovieDto {
       val exists =  movieRepository.existsById(movieDto.id)
        if (!exists)
            throw MovieException("Movie with id ${movieDto.id} is not present")

        if (movieDto.rating == 0.0 || movieDto.name == "Default Movie")
            throw MovieException("Complete movie object is expected")
        movieRepository.save(movieMapper.toEntity(movieDto))
        return movieDto
    }

    override fun deleteMovie(id: Int) {
        val exists =  movieRepository.existsById(id)
        if (!exists)
            throw MovieException("Movie with id $id is not present")
        movieRepository.deleteById(id)
    }

}