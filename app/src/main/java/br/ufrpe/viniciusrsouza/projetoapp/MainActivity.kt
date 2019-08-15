package br.ufrpe.viniciusrsouza.projetoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        httpGet("https://api.myjson.com/bins/h8xi7")
    }

    private fun httpGet(url: String){
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                parseResponse(response)
            },
            Response.ErrorListener { println("DEBUG") })
        queue.add(stringRequest)
    }

    private fun parseResponse(response: String){

    }
}