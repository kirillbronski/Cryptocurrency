package com.kbcoding.cryptocurrency.core.common

sealed class Resource<T>(
    open val data: T? = null,
    open val message: String? = null,
    open val code: Int? = null
) {
    data class Success<T>(override val data: T) : Resource<T>(data)

    data class Error<T>(
        override val message: String,
        override val data: T? = null,
        override val code: Int? = null
    ) : Resource<T>(data, message, code)

    data class Loading<T>(override val data: T? = null) : Resource<T>(data)
}

fun <T, R> Resource<T>.map(transform: (T) -> R): Resource<R> {
    return when (this) {
        is Resource.Success -> Resource.Success(transform(data))
        is Resource.Error -> Resource.Error(message, data?.let { transform(it) }, code)
        is Resource.Loading -> Resource.Loading(data?.let { transform(it) })
    }
}

//sealed class LoadResult<out T> {
//    data object Loading : LoadResult<Nothing>()
//    data class Success<T>(val data: T) : LoadResult<T>()
//    data class Error(val message: String) : LoadResult<Nothing>()
//}