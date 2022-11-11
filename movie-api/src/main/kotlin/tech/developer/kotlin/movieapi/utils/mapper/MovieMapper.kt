package tech.developer.kotlin.movieapi.utils.mapper


import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import tech.developer.kotlin.movieapi.dto.MovieDto
import tech.developer.kotlin.movieapi.entity.Movie

@Service
class MovieMapper: Mapper<MovieDto,Movie> {
    override fun fromEntity(entity: Movie): MovieDto = MovieDto(
            entity.id,
            entity.name,
            entity.rating
    )
    override fun toEntity(domain: MovieDto): Movie = Movie(
        domain.id,
        domain.name,
        domain.rating
    )
}