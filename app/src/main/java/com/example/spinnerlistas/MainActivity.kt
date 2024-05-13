package com.example.spinnerlistas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var texto: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.spinner)
        texto = findViewById(R.id.texto)
        button = findViewById(R.id.button)

        //Se crea la lista de los paises del Spinner
        val countries = arrayOf("EEUU", "MEXICO", "FRANCIA", "ALEMANIA", "BRASIL")

        // Crear un ArrayAdapter utilizando el array y un diseño de spinner por defecto
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, countries)

        // Especificar el diseño que se utilizará cuando la lista de opciones aparezca
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1)
        // Aplicar el adaptador al spinner
        spinner.adapter = adapter

        //Funcion para imprimir la alerta (Bienvenida)
        fun showAlert(message: String) {
            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.apply {
                setMessage(message)
                setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            }.create().show()
        }

        //Que accion realizara el boton al ser presionado dependiendo la opcion del spinner
        button.setOnClickListener {
            val selectedItem = spinner.selectedItemPosition
            when (selectedItem) {
                0 -> showAlert("Welcome! You have selected United States of America")
                1 -> showAlert("Bienvenido! Haz seleccionado México")
                2 -> showAlert("Accueillir! Vous avez sélectionné France")
                3 -> showAlert("Willkommen! Sie haben Deutschland ausgewählt")
                4 -> showAlert("Bem-vindo! Você selecionou Brasil")
            }
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                when (position) {
                    0 -> {
                        texto.text = "Select your country"
                        button.text = "Next"
                    }

                    1 -> {
                        texto.text = "Selecciona tu país"
                        button.text = "Siguiente"
                    }

                    2 -> {
                        texto.text = "Sélectionnez votre pays"
                        button.text = "Suivant"
                    }

                    3 -> {
                        texto.text = "Wähle dein Land"
                        button.text = "Folgende"
                    }

                    4 -> {
                        texto.text = "Escolha o seu país"
                        button.text = "Seguindo"
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Manejar caso donde no se selecciona nada
            }
        }

    }
}