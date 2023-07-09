package br.com.antoniojoseuchoa.apicommvp.api

import br.com.antoniojoseuchoa.apicommvp.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface PostApi {

    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>

}