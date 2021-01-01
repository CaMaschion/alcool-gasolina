package com.gasolinaoualcool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcularPreco(view: View){

       //recuperar valores digitados
       //val precoAlcool = findViewById<EditText>(R.id.precoAlcool) mesma coisa que a linha de baixo:
        val precoAlcool = editPrecoAlcool.text.toString()
        val precoGasolina = editPrecoGasolina.text.toString()

        //validar os campos

        val validaCampos = validarCampos(precoAlcool, precoGasolina)
        if(validaCampos){
            calcularMelhorPreco (precoAlcool, precoGasolina)
        } else {
            textResultado.text = "Preencha os preços primeiro"
        }
    }

    fun validarCampos (precoAcool: String, precoGasolina: String): Boolean {

        var camposValidados: Boolean = true

        if(precoAcool == null || precoAcool.equals("")){
            camposValidados = false
        } else if (precoGasolina == null || precoGasolina.equals("")){
            camposValidados = false
        }

        return camposValidados
    }

    fun calcularMelhorPreco (precoAcool: String, precoGasolina: String){

      val valorAlcool = precoAcool.toDouble()
      val valorGasolina = precoGasolina.toDouble()
      val resultadoPreco = valorAlcool / valorGasolina

        if(resultadoPreco >= 0.7){
            textResultado.text = "Melhor utilizar gasolina"
        } else {
            textResultado.text = "Melhor utilizar álcool"
        }
    }
}