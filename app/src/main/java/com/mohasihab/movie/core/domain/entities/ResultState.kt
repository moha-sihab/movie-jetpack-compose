package com.mohasihab.movie.core.domain.entities

sealed class ResultState<T>(
    val data: T? = null,
    val message: String? = null,
    val code: Int? = null
) {
    class Success<T>(data: T) : ResultState<T>(data)

    class Loading<T> : ResultState<T>()

    class Idle<T> : ResultState<T>()

    class Error<T>(message: String, data: T?) :
        ResultState<T>(data, message)

}
