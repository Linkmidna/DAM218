package com.juliofhiguera.app_ut2_06

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.juliofhiguera.app_ut2_06.databinding.FragmentResumenBinding
import com.juliofhiguera.app_ut2_06.modelo.ReservaZooViewModel

class FragmentResumen : Fragment() {
    private lateinit var binding : FragmentResumenBinding
    private val viewModelCompartido: ReservaZooViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResumenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModelCompartido

        val botonAtras = view.findViewById<Button>(R.id.botonReservar)
        botonAtras.setOnClickListener {
            Toast.makeText(context, "Se ha realizado la reserva", Toast.LENGTH_SHORT).show()
            view.findNavController().navigate(R.id.fragmentInicio)
        }
    }

}