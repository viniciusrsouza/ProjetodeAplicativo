package br.ufrpe.viniciusrsouza.projetoapp.activities

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.ufrpe.viniciusrsouza.projetoapp.R
import br.ufrpe.viniciusrsouza.projetoapp.data.Livro
import br.ufrpe.viniciusrsouza.projetoapp.view.LivroOnClickListener

class LivroActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val isbn = findViewById<TextView>(R.id.isbn)
        val title = findViewById<TextView>(R.id.title)
        val image = findViewById<ImageView>(R.id.img)
        val authors = findViewById<TextView>(R.id.authors)
        val categories = findViewById<TextView>(R.id.categories)
        val publishDate = findViewById<TextView>(R.id.date)
        val description = findViewById<TextView>(R.id.description)

        val livro = intent.getSerializableExtra("Livro") as Livro
        val imagemBitmap = intent.getSerializableExtra("Imagem") as LivroOnClickListener.ImagesWrapper
        title.text = livro.title
        image.setImageBitmap()

    }
}