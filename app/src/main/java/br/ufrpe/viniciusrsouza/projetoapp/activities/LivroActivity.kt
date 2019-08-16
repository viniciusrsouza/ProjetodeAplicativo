package br.ufrpe.viniciusrsouza.projetoapp.activities

import android.graphics.BitmapFactory
import android.os.Bundle
import android.text.Layout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.ufrpe.viniciusrsouza.projetoapp.R
import br.ufrpe.viniciusrsouza.projetoapp.data.Livro

class LivroActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livro)

        val isbn = findViewById<TextView>(R.id.isbn)
        val title = findViewById<TextView>(R.id.title)
        val image = findViewById<ImageView>(R.id.img)
        val status = findViewById<TextView>(R.id.status)
        val authors = findViewById<TextView>(R.id.authors)
        val categories = findViewById<TextView>(R.id.categories)
        val pageNumber = findViewById<TextView>(R.id.pages)
        val publishDate = findViewById<TextView>(R.id.date)
        val description = findViewById<TextView>(R.id.description)

        val livro = intent.getSerializableExtra("Livro") as Livro
        val imagemBytes = intent.getSerializableExtra("Imagem") as ByteArray
        val imgBitmap = BitmapFactory.decodeByteArray(imagemBytes, 0, imagemBytes.size)

        title.text = livro.title
        isbn.text = "isbn: ${livro.isbn}"
        authors.text = livro.authors.joinToString()
        categories.text = livro.categories.joinToString()
        publishDate.text = if(livro.publishedDate == null) "" else livro.publishedDate.toString()
        description.text =
            if(livro.longDescription == "")
                livro.shortDescription.replace("    ", "\n")
            else livro.longDescription.replace("    ", "\n")
        pageNumber.text = "Pages: ${livro.pageCount}"
        status.text = "Status: ${livro.status}"
        image.setImageBitmap(imgBitmap)

        description.justificationMode = Layout.JUSTIFICATION_MODE_INTER_WORD
    }
}