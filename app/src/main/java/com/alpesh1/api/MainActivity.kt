package com.alpesh1.api

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.alpesh1.api.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgsearch.setOnClickListener {
            var id = binding.edtSearch.text.toString()

            callApi(id)
        }

    }

    private fun callApi(id: String) {

        var apiInterface = APIClient.getApiClient().create(ApiInterface::class.java)
        apiInterface.getPosts(id).enqueue(object : Callback<List<DataModel>>{
            override fun onResponse(
                call: Call<List<DataModel>>,
                response: Response<List<DataModel>>
            ) {
                if (response.isSuccessful){

                    var list = response.body()

                    for (l in list!! ){
                        Log.e(TAG, "onResponse: ---------"+l.id )
                        Log.e(TAG, "onResponse: ---------"+l.title )
                        Log.e(TAG, "onResponse: ---------"+l.body )
                        Log.e(TAG, "onResponse: ---------"+l.userId )
                    }

                }
            }

            override fun onFailure(call: Call<List<DataModel>>, t: Throwable) {

            }

        })

    }
}