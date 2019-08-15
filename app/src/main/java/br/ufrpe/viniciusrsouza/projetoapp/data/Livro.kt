package br.ufrpe.viniciusrsouza.projetoapp.data

import java.io.Serializable

data class Livro(
    val title: String,
    val isbn: String,
    val pageCount: Int,
    val publishedDate: Date,
    val thumbnailUrl: String,
    val shortDescription: String,
    val status: String,
    val authors: Set<String>,
    val categories: Set<String>,
    val serial:Long = 1L
): Serializable

data class Date(val date: String)

class LivrosWrapper(val livros: ArrayList<Livro>): Serializable{
    val serial = 1L
}