package th.co.toei.finomena.base

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: String) : Result<Nothing>()
}