package br.ufrpe.viniciusrsouza.projetoapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.ufrpe.viniciusrsouza.projetoapp.R
import br.ufrpe.viniciusrsouza.projetoapp.data.Livro
import br.ufrpe.viniciusrsouza.projetoapp.data.LivrosWrapper
import br.ufrpe.viniciusrsouza.projetoapp.view.LivroAdapter

class DisplayLivrosActivity: AppCompatActivity() {
    lateinit var livros: ArrayList<Livro>
    lateinit var listLivros: RecyclerView
    lateinit var livroAdapter: LivroAdapter
    lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_displaylivros)
        val wrapper = intent.getSerializableExtra("livrosWrapper") as LivrosWrapper
        livros = wrapper.livros
        listLivros = findViewById(R.id.listLivros)

        livroAdapter = LivroAdapter(livros)
        layoutManager = LinearLayoutManager(this)

        listLivros.adapter = livroAdapter
        listLivros.layoutManager = layoutManager

    }

}