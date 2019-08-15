package br.ufrpe.viniciusrsouza.projetoapp.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import android.widget.ImageView
import java.lang.Exception
import java.net.URL

class DownloadImageTask(val image: ImageView): AsyncTask<String, Void, Bitmap>() {
    override fun doInBackground(vararg url: String?): Bitmap? {
        val urlDisplay = url[0]
        var bmp: Bitmap? = null
        try{
            val input = URL(urlDisplay).openStream()
            bmp = BitmapFactory.decodeStream(input)
        } catch(e: Exception){
            Log.println(Log.ERROR, "ERR", e.message.toString())
        }
        return bmp
    }

    override fun onPostExecute(result: Bitmap?) {
        image.setImageBitmap(result)
    }
}