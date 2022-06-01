package th.co.toei.finomena.model

import com.google.gson.annotations.SerializedName

data class FundResponseModel(
    @SerializedName("avg_return")
    var avgReturn: Double? = 0.0,
    @SerializedName("mstar_id")
    var mstarId: String? = "",
    @SerializedName("nav")
    var nav: Double? = 0.0,
    @SerializedName("nav_date")
    var navDate: String? = "",
    @SerializedName("nav_return")
    var navReturn: Double? = 0.0,
    @SerializedName("thailand_fund_code")
    var thailandFundCode: String? = ""
)
