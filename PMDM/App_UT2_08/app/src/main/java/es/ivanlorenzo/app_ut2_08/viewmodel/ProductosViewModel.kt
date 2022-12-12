package es.ivanlorenzo.app_ut2_08.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.ivanlorenzo.app_ut2_08.modelo.Producto
import es.ivanlorenzo.app_ut2_08.modelo.datos.Datos

class ProductosViewModel : ViewModel()
{
    private val _listaCategorias = MutableLiveData<List<String>>()
    private val _listaProductos = MutableLiveData<List<Producto>>()
    private val _listaCompra = MutableLiveData<List<Producto>>()

    val listaCategorias = _listaCategorias
    val listaProductos = _listaProductos
    val listaCompra = _listaCompra


    fun cargarCategorias()
    {
        _listaCategorias.postValue(Datos.nombresCategorias())
    }

    fun cargarProductos(categoria: String)
    {
        _listaProductos.postValue(Datos.getProductosCategoria(categoria))
    }


    fun insertarCesta(producto: Producto)
    {
        _listaCompra.value = _listaCompra.value?.plus(producto) ?: listOf(producto)
    }

}