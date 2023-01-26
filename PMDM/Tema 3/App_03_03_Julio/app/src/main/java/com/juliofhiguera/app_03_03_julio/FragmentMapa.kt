package com.juliofhiguera.app_03_03_julio

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.google.android.gms.location.*

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.util.*

class FragmentMapa : Fragment() {

    private lateinit var miMapa: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationCallback: LocationCallback


    private val callback = OnMapReadyCallback { googleMap ->
        //Se llama únicamente cuando se crea el mapa
        miMapa = googleMap
        val sydney = LatLng(-34.0, 151.0)
        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 12f))
    }

    override fun onStart()
    {
        super.onStart()
        comprobarPermisos()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mapa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    //A partir de aqui mi codigo

    private fun comprobarPermisos()
    {
        val permisos = arrayOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION)
        if (!tienePermisos(permisos))
            solicitarPermisos(permisos)
        else
            geolocalizacionConstante()
    }

    private fun tienePermisos(permisos: Array<String>): Boolean {
        return permisos.all {
            return ContextCompat.checkSelfPermission(
                requireContext(),
                it
            ) == PackageManager.PERMISSION_GRANTED
        }
    }

    private val peticionPermisos =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            val aceptados = permissions.entries.all {
                Toast.makeText(context, "${it.key} = ${it.value}", Toast.LENGTH_SHORT).show()
                it.value
            }
            if(aceptados)
                geolocalizar()
        }
    private fun solicitarPermisos(permisos: Array<String>)
    {
        peticionPermisos.launch(permisos)
    }

    @SuppressLint("MissingPermission")
// Hasta aquí sabemos que los permisos ya están concedidos, por eso añado la anotación
    private fun geolocalizar()
    {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())
        fusedLocationClient.lastLocation.addOnSuccessListener {
            if (it != null)
                imprimirUbicacion(it)

        }
    }

    private fun imprimirUbicacion(ubicacion: Location)
    {
        geolocalizacionConstante()
    }

    //Geolocalizacion constante
    @SuppressLint("MissingPermission")
    private fun geolocalizacionConstante()
    {
        val locationCallback = object : LocationCallback()
        {
            override fun onLocationResult(locationResult: LocationResult)
            {
                for (location in locationResult.locations)
                {
                    val coordenadas = LatLng(location.latitude, location.longitude)
                    miMapa.clear()
                    miMapa.addMarker(MarkerOptions().position(coordenadas).title("Estoy aquí"))
                    miMapa.moveCamera(CameraUpdateFactory.newLatLngZoom(coordenadas, 16f))
                }
            }
        }
    }
}