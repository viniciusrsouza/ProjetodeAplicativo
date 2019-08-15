package br.ufrpe.viniciusrsouza.projetoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import br.ufrpe.viniciusrsouza.projetoapp.data.Livro
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.lang.reflect.Type
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.progressLabel).apply{
            text = resources.getString(R.string.load_request)
        }
        httpGet("https://api.myjson.com/bins/h8xi7")
    }

    private fun httpGet(url: String){
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                findViewById<TextView>(R.id.progressLabel).apply{
                    text = resources.getString(R.string.load_json)
                }
                val livros = parseResponse(response)
                finnish(livros)
            },
            Response.ErrorListener { println("DEBUG") })
        queue.add(stringRequest)
    }

    private fun finnish(livros: ArrayList<Livro>){
        findViewById<ProgressBar>(R.id.progress).visibility = View.GONE
        findViewById<TextView>(R.id.progressLabel).apply{
            text = livros.toString()
        }
    }

    private fun parseResponse(response: String): ArrayList<Livro> {
        val filtrada = response.replace("\$date", "date")
        val livrosType = object : TypeToken<ArrayList<Livro>>() {}.type
        val livros: ArrayList<Livro>
        try {
            livros = Gson().fromJson(filtrada, livrosType)
            Log.println(Log.DEBUG, "DBG", livros.toString())
        } catch (e: Exception) {
            Log.println(Log.DEBUG, "DBG", e.message.toString())
            throw IllegalArgumentException("não foi possível ler o Json")
        }
        return livros
    }
}