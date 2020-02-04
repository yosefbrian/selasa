package com.bankmandiri.poc.jumat

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_post.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        post.setOnClickListener {
            postEmployee()
        }
    }

    fun postEmployee(){
        val request = Employee(0, etName.text.toString(), etSalary.text.toString())

        Network.provideNetwork().postEmployees(request).enqueue(object : Callback<StatusRespone>{
            override fun onFailure(call: Call<StatusRespone>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<StatusRespone>, response: Response<StatusRespone>) {
                Toast.makeText(this@PostActivity, response.body().toString(), Toast.LENGTH_LONG).show()
            }

        })
    }
}
