package br.com.antoniojoseuchoa.apicommvp.model

data class Post(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)