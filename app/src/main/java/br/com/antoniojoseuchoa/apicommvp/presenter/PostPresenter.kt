package br.com.antoniojoseuchoa.apicommvp.presenter

import android.util.Log
import br.com.antoniojoseuchoa.apicommvp.api.RetrofitService
import br.com.antoniojoseuchoa.apicommvp.model.Post
import br.com.antoniojoseuchoa.apicommvp.model.PostagemApi
import kotlinx.coroutines.*
import retrofit2.Response

class PostPresenter(val view: PostagemApi) {

    val retrofitService = RetrofitService.retrofit
    val coroutine = CoroutineScope(Dispatchers.IO)

    fun recuperarPostagens(){
        coroutine.launch {
            var response: Response<List<Post>>? = null

            try{
                response = retrofitService.getPosts()
                if(response != null){
                    val list = response.body()

                    withContext(Dispatchers.Main){
                        list?.let {
                            view.exibirPostagens(it)
                        }
                    }

                }
            }catch (ex: java.lang.Exception){
                Log.i("TAG", "recuperarPostagens: "+ex.message)
            }
        }
    }

    fun onDestroy(){
        coroutine.cancel()
    }

}