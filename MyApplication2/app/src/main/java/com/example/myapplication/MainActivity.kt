package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun simular(componente: View){

        val clinte = nomeCliente.text.toString()
        val valorAp = 190.000
        val valorEntrada = Entrada.text.toString().toDouble()
        val quantidadeDeParcelas = Parcelas.text.toString().toInt()
        val sobraValor = valorAp - valorEntrada
        val pagarParcelas = sobraValor / quantidadeDeParcelas
        val valorMinimo = 0.10 * valorAp
        val df = DecimalFormat("0.###")
        val valorDasParcelas = df.format(pagarParcelas)
        
        if (
            !clinte.all { it.isLetter() } || valorEntrada < 0.0 || valorEntrada > 150.000 ||
                    quantidadeDeParcelas < 0 || quantidadeDeParcelas > 235
                ) {
            Toast.makeText(
                this,
                "Algum valor foi digitado incorretamente. Por gentileza, tente novamente",
                Toast.LENGTH_LONG
            ).show()
        } else if (
             valorEntrada  < valorMinimo
                ) {
            mensagem.text = "Não é possível financiar o empreendimento com esse valor proposto"
            mensagem.setTextColor(Color.RED)
            mensagem.visibility = View.VISIBLE
        } else {
            mensagem.text = "Com a entrada de ${valorEntrada} e o tempo de financiamento de ${quantidadeDeParcelas} meses, suas parcelas ficarão no valor final de ${valorDasParcelas} por mês"
            mensagem.setTextColor(Color.GREEN)
            mensagem.visibility = View.VISIBLE
        }
        }
    }