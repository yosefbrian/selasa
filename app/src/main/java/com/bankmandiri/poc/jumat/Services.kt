package com.bankmandiri.poc.jumat

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Services {
    @GET("employees")
    fun getEmployees(): Call<EmployeeResponse>

    @POST("create")
    fun postEmployees(@Body employee: Employee): Call<StatusRespone>
}