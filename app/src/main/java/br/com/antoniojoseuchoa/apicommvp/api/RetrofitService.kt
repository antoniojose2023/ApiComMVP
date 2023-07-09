package br.com.antoniojoseuchoa.apicommvp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    companion object{
        val base_url = "https://jsonplaceholder.typicode.com/"

        val retrofit = Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostApi::class.java)
    }
}