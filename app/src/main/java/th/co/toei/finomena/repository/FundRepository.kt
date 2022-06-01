package th.co.toei.finomena.repository

import retrofit2.Response
import th.co.toei.finomena.base.BaseServiceModel
import th.co.toei.finomena.model.FundResponseModel

interface FundRepository {
    suspend fun getFundList(date: String): Response<BaseServiceModel<MutableList<FundResponseModel>>>
}