package th.co.toei.finomena.usecase

import th.co.toei.finomena.base.BaseAsyncUseCase
import th.co.toei.finomena.base.Result
import th.co.toei.finomena.model.FundResponseModel
import th.co.toei.finomena.repository.FundRepository
import javax.inject.Inject

class GetFundListUseCase @Inject constructor(private val fundRepository: FundRepository) :
    BaseAsyncUseCase<String, MutableList<FundResponseModel>>() {
    override suspend fun execute(parameter: String): Result<MutableList<FundResponseModel>> {
        return try {
            val response = fundRepository.getFundList(parameter)
            if (isResponseSuccess(response) && response.body()?.status == true) {
                Result.Success(response.body()?.data!!)
            } else {
                Result.Error(response.message())
            }
        } catch (e: Exception) {
            Result.Error(e.message.toString())
        }
    }
}
