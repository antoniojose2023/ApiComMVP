package br.com.antoniojoseuchoa.apicommvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.antoniojoseuchoa.apicommvp.databinding.ActivityMainBinding
import br.com.antoniojoseuchoa.apicommvp.model.Post
import br.com.antoniojoseuchoa.apicommvp.presenter.IPostPresenter
import br.com.antoniojoseuchoa.apicommvp.presenter.PostPresenter

class MainActivity : AppCompatActivity(), IPostPresenter {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var postPresenter: PostPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        postPresenter = PostPresenter(this)
    }

    override fun onStart() {
        postPresenter.recuperarPostagens()
        super.onStart()
    }

    override fun onDestroy() {
        postPresenter.onDestroy()
        super.onDestroy()
    }

    override suspend fun exibirPostagens(list: List<Post>) {
            var retorno = ""
            list.forEach {
                retorno += "${it.id}  ${it.title} \n"
            }

            binding.tvResultado.text = retorno
    }

}