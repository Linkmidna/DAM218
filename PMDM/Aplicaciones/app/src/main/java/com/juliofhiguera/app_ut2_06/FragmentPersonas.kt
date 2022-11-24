package com.juliofhiguera.app_ut2_06

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.juliofhiguera.app_ut2_06.databinding.FragmentPersonasBinding
import com.juliofhiguera.app_ut2_06.modelo.ReservaZooViewModel

class FragmentPersonas : Fragment() {

    private lateinit var binding : FragmentPersonasBinding
    private val viewModelCompartido: ReservaZooViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.numberPickerAdultos.apply {
            minValue = 0
            maxValue = 5
            value = 1
            wrapSelectorWheel = false
            setOnValueChangedListener { _, _, nuevo
                ->
                viewModelCompartido.setNumeroAdultos(nuevo)
            }

        }
        binding.numberPickerNinos.apply {
            minValue = 0
            maxValue = 5
            value = 0
            wrapSelectorWheel = false
            setOnValueChangedListener { _, _, nuevo
                ->
                viewModelCompartido.setNumeroAdultos(nuevo)
            }


            val botonAtras = view.findViewById<Button>(R.id.botonSiguiente)
            botonAtras.setOnClickListener {
                view.findNavController().navigate(R.id.fragmentFecha)
            }
        }
    }

}