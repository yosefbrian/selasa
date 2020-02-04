package com.bankmandiri.poc.jumat

import com.google.gson.annotations.SerializedName

data class EmployeeResponse (
    @SerializedName("data") val data: List<Employee>
)