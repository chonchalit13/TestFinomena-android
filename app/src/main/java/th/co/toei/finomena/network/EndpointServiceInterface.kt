package th.co.toei.finomena.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import th.co.toei.finomena.base.BaseServiceModel
import th.co.toei.finomena.model.FundResponseModel

interface EndpointServiceInterface {
    @GET("fund-ranking-{date}.json")
    suspend fun getListFund(@Path("date") date: String): Response<BaseServiceModel<MutableList<FundResponseModel>>>
}
