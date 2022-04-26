package com.eneszeydan.hipointernshipcase.models

import com.google.gson.annotations.SerializedName


data class Members(

    @SerializedName("name") var name: String? = null,
    @SerializedName("age") var age: Int? = null,
    @SerializedName("location") var location: String? = null,
    @SerializedName("github") var github: String? = null,
    @SerializedName("hipo") var hipo: Hipo? = Hipo()

)