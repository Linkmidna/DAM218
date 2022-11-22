package com.juliofhiguera.app_ut2_06

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juliofhiguera.app_ut2_06.databinding.FragmentInicioBinding


class FragmentInicio : Fragment() {
    private lateinit var binding : FragmentInicioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root
        TE TOCA CONECTAR TODAS LAS CLASES ENTRE ELLAS
    }

}