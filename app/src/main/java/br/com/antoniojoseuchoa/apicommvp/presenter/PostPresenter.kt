package br.com.antoniojoseuchoa.apicommvp.presenter

import br.com.antoniojoseuchoa.apicommvp.model.PostagemApi
import kotlinx.coroutines.*

class PostPresenter(val view: IPostPresenter) {

    val postagemApi = PostagemApi()
    val coroutine = CoroutineScope(Dispatchers.IO)

    fun recuperarPostagens(){
        coroutine.launch {
             val list = postagemApi.getRecuperarPostagens()
             list?.let {
                 withContext(Dispatchers.Main){
                     view.exibirPostagens( it )
                 }
             }
        }
    }

    fun onDestroy(){
        coroutine.cancel()
    }

}