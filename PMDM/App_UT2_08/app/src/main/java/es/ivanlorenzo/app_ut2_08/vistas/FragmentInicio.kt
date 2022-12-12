package es.ivanlorenzo.app_ut2_08.vistas

import android.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import es.ivanlorenzo.app_ut2_08.databinding.FragmentInicioBinding
import es.ivanlorenzo.app_ut2_08.viewmodel.ProductosViewModel

class FragmentInicio : Fragment()
{
    private lateinit var binding: FragmentInicioBinding
    private val viewModel: ProductosViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        //Ejecutará lo de dentro de las llaves
        //cuando listaCategorias se modifique
        viewModel.listaCategorias.observe(viewLifecycleOwner){
            val adapterCategorias = ArrayAdapter(requireContext(),
                R.layout.simple_spinner_item, it)
            binding.spinnerCategorias.adapter = adapterCategorias
            binding.spinnerCategorias.setSelection(0,false)
        }

        //Cuando se modifique la listaProductos se desencadenará lo que está entre {}
        //Se desencadena cuando llamo al método cargarProductos del viewModel
        //Esto se hace cuando se modifique la categoría con el spinner
        viewModel.listaProductos.observe(viewLifecycleOwner){
            binding.apply {
                listaProductos.adapter = ProductosAdapter(viewModel)
                listaProductos.layoutManager = LinearLayoutManager(context)
                listaProductos.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            }
        }

        viewModel.cargarCategorias()

        binding.spinnerCategorias.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long)
            {
                val categoria = p0?.selectedItem.toString()
                viewModel.cargarProductos(categoria)
                Toast.makeText(context,categoria, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) = Unit
        }
    }


}