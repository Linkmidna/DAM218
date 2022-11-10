package es.ivanlorenzo.ejemplout1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.findNavController


class InicioFragment : Fragment()
{
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        val botonFragment1 = view.findViewById<Button>(R.id.botonFragment1)
        val botonFragment2 = view.findViewById<Button>(R.id.botonFragment2)

        botonFragment1.setOnClickListener {
            view.findNavController().navigate(R.id.action_inicioFragment_to_primerFragment)
        }
        botonFragment2.setOnClickListener {
            view.findNavController().navigate(R.id.action_inicioFragment_to_segundoFragment)
        }

    }
}