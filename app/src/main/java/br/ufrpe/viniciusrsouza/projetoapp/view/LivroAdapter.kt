package br.ufrpe.viniciusrsouza.projetoapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.ufrpe.viniciusrsouza.projetoapp.R
import br.ufrpe.viniciusrsouza.projetoapp.data.Livro
import br.ufrpe.viniciusrsouza.projetoapp.util.DownloadImageTask

class LivroAdapter(val livros: List<Livro>):
    RecyclerView.Adapter<LivroAdapter.LivroViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.elemento_livro, parent, false)
        val holderLivro = LivroViewHolder(view)
        return holderLivro
    }

    override fun getItemCount(): Int = livros.size

    override fun onBindViewHolder(holder: LivroViewHolder, position: Int) {
        val livro = livros[position]
        holder.title.text = livro.title
        holder.authors.text = livro.authors.joinToString()
        holder.categories.text = livro.categories.joinToString()
        holder.publishDate.text = livro.publishedDate.date
        DownloadImageTask(holder.img).execute(livro.thumbnailUrl)

    }

    class LivroViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val img: ImageView = itemView.findViewById(R.id.icon)
        val title: TextView = itemView.findViewById(R.id.book_title)
        val authors: TextView = itemView.findViewById(R.id.authors)
        val categories: TextView = itemView.findViewById(R.id.categories)
        val publishDate: TextView = itemView.findViewById(R.id.publishDate)
    }

}