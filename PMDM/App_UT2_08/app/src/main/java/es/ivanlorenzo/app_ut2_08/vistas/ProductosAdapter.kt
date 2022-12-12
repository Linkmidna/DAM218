package es.ivanlorenzo.app_ut2_08.vistas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.ivanlorenzo.app_ut2_08.R
import es.ivanlorenzo.app_ut2_08.viewmodel.ProductosViewModel

class ProductosAdapter(val viewModel: ProductosViewModel)
    : RecyclerView.Adapter<ProductosAdapter.ProductoViewHolder>()
{
    val productos = viewModel.listaProductos.value ?: listOf()

    class ProductoViewHolder(view: View)
        : RecyclerView.ViewHolder(view)
    {
        val textViewNombre = view.findViewById<TextView>(R.id.textViewNombre)
        val imageViewProducto = view.findViewById<ImageView>(R.id.imageProducto)
        val botonComprar = view.findViewById<ImageButton>(R.id.botonComprar)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder
    {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto, parent, false)

        return ProductoViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int)
    {
        val producto = productos[position]
        holder.textViewNombre.text = producto.nombre
        holder.imageViewProducto.setImageResource(producto.imagenId)
        holder.botonComprar.setOnClickListener { viewModel.insertarCesta(producto) }
    }

    override fun getItemCount(): Int = productos.size


}