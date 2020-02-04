package com.bankmandiri.poc.jumat

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    val employee = ArrayList<Employee>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycleview.layoutManager = LinearLayoutManager(this)
        val adapter = FirstAdapter(employee, this)
        recycleview.adapter = adapter

        reload.setOnClickListener {

            pbar.visibility = View.VISIBLE
            recycleview.visibility = View.INVISIBLE
            Network.provideNetwork().getEmployees().enqueue(object : Callback<EmployeeResponse>{
                override fun onFailure(call: Call<EmployeeResponse>, t: Throwable) {
                    t.printStackTrace()
                }

                override fun onResponse(
                    call: Call<EmployeeResponse>,
                    response: Response<EmployeeResponse>
                ) {
                    response.body().let {
                        pbar.visibility = View.GONE
                        recycleview.visibility = View.VISIBLE
                        employee.clear()
                        employee.addAll(it!!.data)
                    }
                    adapter.notifyDataSetChanged()
                }

            })
        }

        Network.provideNetwork().getEmployees().enqueue(object : Callback<EmployeeResponse>{
            override fun onFailure(call: Call<EmployeeResponse>, t: Throwable) {

                t.printStackTrace()
            }

            override fun onResponse(
                call: Call<EmployeeResponse>,
                response: Response<EmployeeResponse>
            ) {
                pbar.visibility = View.GONE
                recycleview.visibility = View.VISIBLE

                response.body().let {
                    employee.addAll(it!!.data)
                }
                adapter.notifyDataSetChanged()
            }

        })

    }

}


