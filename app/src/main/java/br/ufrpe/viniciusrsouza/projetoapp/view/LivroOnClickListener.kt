package br.ufrpe.viniciusrsouza.projetoapp.view

import android.content.Intent
import android.graphics.Bitmap
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.ufrpe.viniciusrsouza.projetoapp.activities.LivroActivity
import br.ufrpe.viniciusrsouza.projetoapp.data.Livro
import java.io.ByteArrayOutputStream
import java.io.Serializable

class LivroOnClickListener(val recyclerView: RecyclerView, val livros: List<Livro>, val activity: AppCompatActivity)
    : View.OnClickListener {

    override fun onClick(view: View) {
        val position = recyclerView.getChildLayoutPosition(view)
        Log.println(Log.DEBUG, "DBG", "Clicou no livro ${livros[position]}")
        val adapter = recyclerView.adapter as LivroAdapter
        val image = adapter.imgCache[livros[position]]
        val stream = ByteArrayOutputStream()
        image!!.compress(Bitmap.CompressFormat.PNG, 100, stream)
        val bytes = stream.toByteArray()

        val intent = Intent(recyclerView.context, LivroActivity::class.java).apply {
            putExtra("Livro", livros[position])
            putExtra("Imagem", bytes)

        }
        activity.startActivity(intent)
    }
}