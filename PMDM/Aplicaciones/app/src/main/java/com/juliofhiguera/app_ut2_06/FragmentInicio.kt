package com.juliofhiguera.app_ut2_06

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.juliofhiguera.app_ut2_06.databinding.FragmentInicioBinding
import com.juliofhiguera.app_ut2_06.modelo.ReservaZooViewModel


class FragmentInicio : Fragment() {
    private lateinit var binding : FragmentInicioBinding
    private val viewModelCompartido: ReservaZooViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            botonZoologico.setOnClickListener { tipoVisita("Zoológico") }
            botonReptario.setOnClickListener { tipoVisita("Reptario") }
            botonVisitaGuiada.setOnClickListener { tipoVisita("Visita guiada") }
        }
    }
    fun tipoVisita(tipo: String)
    {
        viewModelCompartido.setTipoReserva(tipo)
        view?.findNavController()?.navigate(R.id.fragmentPersonas)
    }



}