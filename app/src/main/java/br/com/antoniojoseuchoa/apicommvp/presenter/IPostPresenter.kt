package br.com.antoniojoseuchoa.apicommvp.presenter

import br.com.antoniojoseuchoa.apicommvp.model.Post

interface IPostPresenter{
    suspend fun exibirPostagens(list: List<Post>)
}