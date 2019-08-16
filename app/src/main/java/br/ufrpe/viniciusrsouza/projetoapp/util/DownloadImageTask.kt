package br.ufrpe.viniciusrsouza.projetoapp.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import br.ufrpe.viniciusrsouza.projetoapp.data.Livro
import br.ufrpe.viniciusrsouza.projetoapp.view.LivroAdapter
import java.lang.Exception
import java.net.URL

class DownloadImageTask(private val map: HashMap<Livro, Bitmap?>,
                        private val livro: Livro,
                        private val livroAdapter: LivroAdapter,
                        private val position: Int
    ): AsyncTask<String, Void, Bitmap>() {

    override fun doInBackground(vararg url: String?): Bitmap? {
        val urlDisplay = url[0]
        var bmp: Bitmap? = null
        try{
            if(urlDisplay != null) {
                val input = URL(urlDisplay).openStream()
                bmp = BitmapFactory.decodeStream(input)
            }
        } catch(e: Exception){
            Log.println(Log.ERROR, "DBG", e.message.toString())
        }
        return bmp
    }

    override fun onPostExecute(result: Bitmap?) {
        map[livro] = result
        livroAdapter.notifyItemChanged(position)
    }
}