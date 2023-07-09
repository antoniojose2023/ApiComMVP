package br.com.antoniojoseuchoa.apicommvp.model

interface PostagemApi {
    suspend fun exibirPostagens(list: List<Post>)
}