package th.co.toei.finomena.view.fund

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import th.co.toei.finomena.base.BaseViewModel
import th.co.toei.finomena.base.Result
import th.co.toei.finomena.model.FundResponseModel
import th.co.toei.finomena.usecase.GetFundListUseCase
import javax.inject.Inject

@HiltViewModel
class FundViewModel @Inject constructor(private val getFundListUseCase: GetFundListUseCase) :
    BaseViewModel() {

    val fundListLiveData: MutableLiveData<MutableList<FundResponseModel>> = MutableLiveData()

    fun getListFund(date: String) {
        viewModelScope.launch {
            loadingLiveData.postValue(true)

            val result = withContext(Dispatchers.IO) {
                getFundListUseCase.execute(date)
            }

            when (result) {
                is Result.Success -> {
                    fundListLiveData.postValue(result.data!!)
                }
                is Result.Error -> {
                    errorMessageLiveData.postValue(result.exception)
                }
            }

        }
    }
}