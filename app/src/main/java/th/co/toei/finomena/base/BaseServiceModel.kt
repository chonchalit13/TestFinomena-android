package th.co.toei.finomena.base

import com.google.gson.annotations.SerializedName

data class BaseServiceModel<T>(
    @SerializedName("data")
    val data: T?,
    @SerializedName("status")
    val status: Boolean = false,
    @SerializedName("error")
    val error: String? = null
)