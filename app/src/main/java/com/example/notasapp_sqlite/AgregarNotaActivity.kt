package com.example.notasapp_sqlite

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.notasapp_sqlite.databinding.ActivityAgregarNotaBinding
import com.example.notasapp_sqlite.databinding.ActivityMainBinding

class AgregarNotaActivity : AppCompatActivity() {


    private lateinit var binding: ActivityAgregarNotaBinding
    private lateinit var p0 : NotasDatasBaseHelp


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgregarNotaBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        p0 = NotasDatasBaseHelp(this)

        binding.ivGuardarNota.setOnClickListener {
            val titulo = binding.etTitulo.text.toString()
            val descripcion = binding.etDescripcion.text.toString()

            if(!titulo.isEmpty() &&!descripcion.isEmpty()){
                guardarNota(titulo,descripcion)
            }else {Toast.makeText(applicationContext, "escriba en los espacios en blanco", Toast.LENGTH_SHORT).show()

            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun guardarNota(titulo: String, descripcion: String){
        val nota = Nota(0,titulo,descripcion)
        p0.inserNota(nota)
        startActivity(Intent(applicationContext, MainActivity:: class.java))
        finishAffinity()
        Toast.makeText(applicationContext, "se a agragado al nota", Toast.LENGTH_SHORT).show()
    }
}