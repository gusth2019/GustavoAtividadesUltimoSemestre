package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun simular(componente:View){

        val valorAp = 190.00
        val valorEntrada = Entrada.toString().toDouble()
        val quantidadeDeParcelas = Parcelas.toString().toInt()
        val sobraValor = valorAp - valorEntrada
        val pagarParcelas = sobraValor / quantidadeDeParcelas
        val valorMinimo = 0.010 * valorAp

        if (
            !nomeCliente.toString().all { it.isLetter() } || Entrada.toString().toDouble() < 0 || Entrada.toString().toDouble() > 150.00 ||
                    Parcelas.toString().toInt() < 0 || Parcelas.toString().toInt() > 235
                ) {
            Toast.makeText(this, "Algum valor foi digitado incorretamente. Por gentileza, tente novamente", Toast.LENGTH_LONG).show()
        } else if (
            valorEntrada > 0 && valorEntrada < valorMinimo
                ) {
            mensagem.text = "Não é possível financiar o empreendimento com esse valor proposto"
            mensagem.setTextColor(Color.RED)
            mensagem.visibility = View.VISIBLE
        } else {
            mensagem.text = "Com a entrade de ${valorEntrada} e o tempo de financiamento de ${quantidadeDeParcelas} meses, suas parcelas ficarão no valor final de ${pagarParcelas} por mês"
            mensagem.setTextColor(Color.GREEN)
            mensagem.visibility = View.VISIBLE
        }

        }
    }