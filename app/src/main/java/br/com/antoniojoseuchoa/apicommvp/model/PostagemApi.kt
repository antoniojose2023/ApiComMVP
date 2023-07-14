package br.com.antoniojoseuchoa.apicommvp.model

import br.com.antoniojoseuchoa.apicommvp.api.RetrofitService
import retrofit2.Response
import java.lang.Exception

class PostagemApi() {

    private var service = RetrofitService.retrofit
    suspend fun getRecuperarPostagens(): List<Post> {
        try{
             var response : Response<List<Post>>? = null
             response = service.getPosts()

            if(response.isSuccessful){
                 val list = response.body()
                 list?.let {
                     return it
                 }
             }
        }catch (ex: Exception){
                ex.stackTrace
        }

        return emptyList()
    }

}