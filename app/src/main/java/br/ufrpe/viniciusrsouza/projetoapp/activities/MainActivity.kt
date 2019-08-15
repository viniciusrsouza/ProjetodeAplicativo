package br.ufrpe.viniciusrsouza.projetoapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import br.ufrpe.viniciusrsouza.projetoapp.R
import br.ufrpe.viniciusrsouza.projetoapp.data.Livro
import br.ufrpe.viniciusrsouza.projetoapp.data.LivrosWrapper
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.Exception
import java.lang.IllegalArgumentException
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
            Response.ErrorListener {
                findViewById<TextView>(R.id.progressLabel).apply{
                    text = resources.getString(R.string.load_fail)
                }
            })
        queue.add(stringRequest)
    }

    private fun finnish(livros: ArrayList<Livro>){
        val wrapper = LivrosWrapper(livros)
        val intent = Intent(this, DisplayLivrosActivity::class.java).apply {
            putExtra("livrosWrapper", wrapper)
        }
        startActivity(intent)
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