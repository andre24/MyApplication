package com.example.myapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ModelVoucher (
    @SerializedName("id_voucher")
    @Expose
    var id_voucher: String? = null,

    @SerializedName("type_voucher")
    @Expose
    var type_voucher: String? = null,

    @SerializedName("title_voucher")
    @Expose
    var title_voucher: String? = null,

    @SerializedName("poin_voucher")
    @Expose
    var poin_voucher: Int? = null

)