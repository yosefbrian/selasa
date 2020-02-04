package com.bankmandiri.poc.jumat

import com.google.gson.annotations.SerializedName

data class Employee (
    @SerializedName("id") val id : Int,
    @SerializedName("employee_name") val name : String,
    @SerializedName("employee_salary") val salary : String
)