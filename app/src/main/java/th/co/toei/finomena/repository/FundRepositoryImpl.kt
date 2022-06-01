package th.co.toei.finomena.repository

import retrofit2.Response
import th.co.toei.finomena.base.BaseServiceModel
import th.co.toei.finomena.model.FundResponseModel
import th.co.toei.finomena.network.EndpointServiceInterface
import javax.inject.Inject

class FundRepositoryImpl @Inject constructor(private val apiService: EndpointServiceInterface) :
    FundRepository {

    override suspend fun getFundList(date: String): Response<BaseServiceModel<MutableList<FundResponseModel>>> =
        apiService.getListFund(date)
}