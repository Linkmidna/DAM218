package es.ivanlorenzo.ejemplout1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController


class SegundoFragment : Fragment()
{
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_segundo, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        val botonAtras = view.findViewById<Button>(R.id.botonAtras)
        botonAtras.setOnClickListener {
            view.findNavController().navigate(R.id.action_segundoFragment_to_inicioFragment)
        }

        val botonSiguiente = view.findViewById<Button>(R.id.botonSiguiente)
        botonSiguiente.setOnClickListener {
            view.findNavController().navigate(R.id.action_segundoFragment_to_tercerFragment)
        }
    }
}