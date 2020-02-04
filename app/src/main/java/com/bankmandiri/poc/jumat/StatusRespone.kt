package com.bankmandiri.poc.jumat

import com.google.gson.annotations.SerializedName

data class StatusRespone(
    @SerializedName("status")
    val status: String,
    @SerializedName("data")
    val data: Employee
)