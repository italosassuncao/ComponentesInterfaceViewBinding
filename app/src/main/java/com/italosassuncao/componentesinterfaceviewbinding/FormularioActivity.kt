package com.italosassuncao.componentesinterfaceviewbinding

import android.R.id.checkbox
import android.os.Bundle
import android.widget.CompoundButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.getValue
import com.italosassuncao.componentesinterfaceviewbinding.databinding.ActivityFormularioBinding

class FormularioActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormularioBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        with(binding) {
            btnEnviar.setOnClickListener {
                //checkbox()
            }

            cbEnviar.setOnCheckedChangeListener { _, isChecked ->
                val resultado = if (isChecked) "Checkbox selecionado" else "Checkbox não selecionado"
                textResultado.text = "Valor selecionado: $resultado"
            }

            /*cbEnviar.setOnClickListener {
                val selecionado = cbEnviar.isChecked
                val resultado = if (selecionado) "Checkbox selecionado" else "Checkbox não selecionado"

                textResultado.text = "Valor selecionado: $selecionado"
            }*/

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }

        /*fun checkbox() {
            val selecionado = binding.cbEnviar.isChecked
            val resultado = if (selecionado) {
                "Checkbox selecionado"
            } else {
                "Checkbox não selecionado"
            }
            binding.textResultado.text = "Valor selecionado: $selecionado"
        }*/
    }
}