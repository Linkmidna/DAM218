package com.juliofhiguera.app_ut2_06.modelo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class ReservaZooViewModel: ViewModel() {
    private val _tipoReserva = MutableLiveData<String>()
    private val _fecha = MutableLiveData<Calendar>()
    private val _numeroAdultos = MutableLiveData<Int>()
    private val _numeroNinos = MutableLiveData<Int>()
    private val _precio = MutableLiveData<Double>()

    val tipoReserva: LiveData<String> = _tipoReserva
    val fecha: LiveData<Calendar> = _fecha
    val numeroAdultos: LiveData<Int> = _numeroAdultos
    val numeroNinos: LiveData<Int> = _numeroNinos
    val precio: LiveData<Double> = _precio

    fun setTipoReserva(tipo: String) {
        _tipoReserva.value = tipo
    }

    fun setFecha(fecha: Calendar) {
        _fecha.value = fecha
        actualizarPrecio()
    }

    fun setNumeroAdultos(numero: Int) {
        _numeroAdultos.value = numero
        actualizarPrecio()
    }

    fun setNumeroNinos(numero: Int) {
        _numeroNinos.value = numero
        actualizarPrecio()
    }

    private fun actualizarPrecio() {
        //TODO
    }
}