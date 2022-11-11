package tech.developer.kotlin.movieapi.utils.exceptions

import java.lang.Exception

class MovieException(override val message: String?): Exception(message)