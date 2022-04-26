package com.eneszeydan.hipointernshipcase.models

import com.google.gson.annotations.SerializedName


data class Hipo(

    @SerializedName("position") var position: String? = null,
    @SerializedName("years_in_hipo") var yearsInHipo: Int? = null

)