package com.example.githubbam.apis.models


import com.google.gson.annotations.SerializedName

data class Permissions(
    @SerializedName("admin")
    var admin: Boolean? = false,
    @SerializedName("pull")
    var pull: Boolean? = false,
    @SerializedName("push")
    var push: Boolean? = false
)