package com.eneszeydan.hipointernshipcase.models

import com.google.gson.annotations.SerializedName


data class HipoResponse(

    @SerializedName("company") var company: String? = null,
    @SerializedName("team") var team: String? = null,
    @SerializedName("members") var members: ArrayList<Members> = arrayListOf()

)