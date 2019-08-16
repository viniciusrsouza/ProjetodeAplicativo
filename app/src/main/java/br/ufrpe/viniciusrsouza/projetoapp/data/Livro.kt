package br.ufrpe.viniciusrsouza.projetoapp.data

import android.icu.text.SimpleDateFormat
import java.io.Serializable

data class Livro(
    val title: String,
    val isbn: String,
    val pageCount: Int,
    val publishedDate: Date?,
    val thumbnailUrl: String?,
    val shortDescription: String,
    val status: String,
    val authors: Set<String>,
    val categories: Set<String>,
    val serialVersionUID:Long = 1L
): Serializable

class Date(date: String): Serializable{
    val date:String = date
    get() {
        return field.substring(0, 4) + "/" +
                field.substring(5, 7) + "/" +
                field.substring(8, 10)
    }

    override fun toString(): String {
        return this.date
    }
}

class LivrosWrapper(val livros: ArrayList<Livro>): Serializable{
    val serialVersionUID = 1L
}