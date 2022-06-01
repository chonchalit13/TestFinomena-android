package th.co.toei.finomena.base

import retrofit2.Response

abstract class BaseAsyncUseCase<in P, R> {
    abstract suspend fun execute(parameter: P): Result<R>

    fun <T> isResponseSuccess(response: Response<T>): Boolean {
        return (response.code() == 200 && response.body() != null)
    }
}