package com.italosassuncao.componentesinterfaceviewbinding

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.italosassuncao.componentesinterfaceviewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //private lateinit var buttonClique: Button
    //private lateinit var binding: ActivityMainBinding ** Opçao 1 de configuraçao

    // Opçao 2 de configuraçao
    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityMainBinding.inflate(layoutInflater) ** Opçao 1 de configuraçao
        enableEdgeToEdge()
        setContentView(binding.root)

        with(binding) {
            buttonClique.setOnClickListener {}
            buttonExecutar?.setOnClickListener {}
        }

        /*buttonClique = findViewById(R.id.button_clique)
        buttonClique.setOnClickListener {
            // Lógica do clique do botão
            Toast.makeText(this, "Botão clicado!", Toast.LENGTH_SHORT).show()
        }*/

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}