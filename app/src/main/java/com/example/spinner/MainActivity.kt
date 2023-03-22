package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var SpLenguaje: Spinner
    lateinit var txtTitulo: TextView
    lateinit var txtContenido: TextView
    lateinit var txtCaracteristica: TextView

    val lenguajes = arrayOf("JAVA", "KOTLIN", "PHP", "SWIFT", "C#", "C++", "DART", "JS")
    val caracteristicas = arrayOf(
        "Es un lenguaje orientado a objetos.",
        "Es un lenguaje moderno y conciso.",
        "Es un lenguaje utilizado principalmente para la creación de páginas web dinámicas.",
        "Es un lenguaje utilizado para el desarrollo de aplicaciones iOS.",
        "Es un lenguaje utilizado para el desarrollo de aplicaciones Windows.",
        "Es un lenguaje utilizado para el desarrollo de aplicaciones de sistemas y juegos.",
        "Es un lenguaje utilizado para el desarrollo de aplicaciones móviles con Flutter.",
        "Es un lenguaje utilizado principalmente para el desarrollo de aplicaciones web."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SpLenguaje = findViewById(R.id.sp_lenguajes)
        txtTitulo = findViewById(R.id.tituloVentana)
        txtContenido = findViewById(R.id.tituloVentana)
        txtCaracteristica = findViewById(R.id.txtCara)

        // CREAR ADAPTADOR
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, lenguajes)
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        SpLenguaje.adapter = adaptador
        SpLenguaje.onItemSelectedListener = this
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, posicion: Int, id: Long) {
        val lenguajeSeleccionado = lenguajes[posicion]
        val caracteristicaSeleccionada = caracteristicas[posicion]
        txtTitulo.text = lenguajeSeleccionado
        val valorSelecionado = lenguajes[posicion]
        Toast.makeText(this,"selecciono $valorSelecionado",
            Toast.LENGTH_LONG).show()
        txtCaracteristica.text = caracteristicaSeleccionada
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        txtTitulo.text = ""
        txtContenido.text = ""
        txtCaracteristica.text = ""
    }
}