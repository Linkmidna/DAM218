package es.JulioFHiguera.app_ut3_01.view

import android.graphics.Color
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import es.JulioFHiguera.app_ut3_01.databinding.FragmentDetalleAnimalBinding
import es.JulioFHiguera.app_ut3_01.model.Animal

class FragmentDetalleAnimal : Fragment() {
    private lateinit var binding: FragmentDetalleAnimalBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetalleAnimalBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        val animal = intent.extras?.get("animal") as Animal
        binding.textViewNombre.text = animal.nombre
        binding.textViewDescripcion.text = animal.descripcion
        binding.textViewDescripcion.movementMethod = ScrollingMovementMethod()
        binding.imageViewAnimal.setImageResource(animal.imagenId)

        binding.imageViewFavorito.setOnClickListener {
            binding.imageViewFavorito.setColorFilter(Color.parseColor("#FFDAA95E"))
        }


        binding.botonPositivo.setOnClickListener {
            crearIntentAMain(animal, 1)
        }

        binding.botonNegativo.setOnClickListener {
            crearIntentAMain(animal, -1)
        }


    }
}