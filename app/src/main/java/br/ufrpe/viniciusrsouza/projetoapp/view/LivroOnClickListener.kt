package br.ufrpe.viniciusrsouza.projetoapp.view

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.ufrpe.viniciusrsouza.projetoapp.activities.LivroActivity
import br.ufrpe.viniciusrsouza.projetoapp.data.Livro

class LivroOnClickListener(val recyclerView: RecyclerView, val livros: List<Livro>, val activity: AppCompatActivity)
    : View.OnClickListener {

    override fun onClick(view: View) {
        val position = recyclerView.getChildLayoutPosition(view)
        Log.println(Log.DEBUG, "DBG", "Clicou no livro ${livros[position]}")
        val intent = Intent(recyclerView.context, LivroActivity::class.java).apply {
            putExtra("Livro", livros[position])
        }
        activity.startActivity(intent)
    }
}