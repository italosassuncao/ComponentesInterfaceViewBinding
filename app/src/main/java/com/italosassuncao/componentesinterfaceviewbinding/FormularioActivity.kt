package com.italosassuncao.componentesinterfaceviewbinding

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
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
                //radioButton()
                //switchToggle()
                exibirSnackBar(it)
                //Toast.makeText(this, "Mensagem enviada", Toast.LENGTH_SHORT).show()
                Snackbar.make(
                    it,
                    "Mensagem enviada",
                    Snackbar.LENGTH_LONG
                ).show()
            }

            /*rbMasculino.setOnCheckedChangeListener { _, isChecked ->
                val resultado = if (isChecked) "Masculino" else "Feminino"
                textResultado.text = "Valor selecionado: $resultado"
            }*/

            /*cbEnviar.setOnCheckedChangeListener { _, isChecked ->
                val resultado = if (isChecked) "Checkbox selecionado" else "Checkbox não selecionado"
                textResultado.text = "Valor selecionado: $resultado"
            }*/

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

    private fun exibirSnackBar(view: View) {
        val snackbar = Snackbar.make(
            view,
            "Mensagem enviada",
            Snackbar.LENGTH_LONG
        )

        snackbar.setAction("Desfazer") {
            Toast.makeText(this, "Desfeito", Toast.LENGTH_SHORT).show()
        }

        snackbar.setTextColor(
            ContextCompat.getColor(this, R.color.white)
        )

        snackbar.show()

    }

    private fun switchToggle() {
        val switchMarcado = binding.switchNotificacoes.isChecked
        val toggleMarcado = binding.toggleAtivar.isChecked
        binding.textResultado.text = "Switch: $switchMarcado\nToggle: $toggleMarcado"
    }

    private fun radioButton() {
        val masculino = binding.rbMasculino.isChecked
        //binding.textResultado.text = if(masculino) "Masculino" else "Feminino"

        val idItemSelecionado = binding.rgSexo.checkedRadioButtonId
        binding.textResultado.text = when (idItemSelecionado) {
            binding.rbMasculino.id -> "Masculino"
            binding.rbFeminino.id -> "Feminino"
            binding.rbNaoresponder.id -> "Não responder"
            else -> "Não selecionado"
        }
        binding.rgSexo.clearCheck()


        /*if (selecionado){

        }else if(binding.rbFeminino.isChecked){

        }else if(binding.rbNaoresponder.isChecked){

        }*/

    }
}