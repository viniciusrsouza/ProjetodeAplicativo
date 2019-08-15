package br.ufrpe.viniciusrsouza.projetoapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.ufrpe.viniciusrsouza.projetoapp.R
import br.ufrpe.viniciusrsouza.projetoapp.data.Livro
import br.ufrpe.viniciusrsouza.projetoapp.data.LivrosWrapper

class DisplayLivrosActivity: AppCompatActivity() {
    lateinit var livros: ArrayList<Livro>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_displaylivros)
        val wrapper = intent.getSerializableExtra("livrosWrapper") as LivrosWrapper
        livros = wrapper.livros
    }
}