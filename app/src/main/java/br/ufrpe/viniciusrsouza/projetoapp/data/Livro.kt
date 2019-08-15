package br.ufrpe.viniciusrsouza.projetoapp.data

data class Livro(
    val title: String,
    val isbn: String,
    val pageCount: Int,
    val publishedDate: Date,
    val thumbnailUrl: String,
    val shortDescription: String,
    val status: String,
    val authors: Set<String>,
    val categories: Set<String>
)

data class Date(val date: String)