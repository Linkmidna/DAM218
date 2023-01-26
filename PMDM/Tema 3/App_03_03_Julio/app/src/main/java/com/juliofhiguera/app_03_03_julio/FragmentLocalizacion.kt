package com.juliofhiguera.app_03_03_julio

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.google.android.gms.location.*
import com.juliofhiguera.app_03_03_julio.databinding.ActivityMainBinding
import com.juliofhiguera.app_03_03_julio.databinding.FragmentLocalizacionBinding
import java.util.*

class FragmentLocalizacion : Fragment() {

    private lateinit var binding: FragmentLocalizacionBinding
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationCallback: LocationCallback

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = FragmentLocalizacionBinding.inflate(layoutInflater)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLocalizacionBinding.inflate(layoutInflater, container, false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        binding.botonObtenerLocalizacion.setOnClickListener {
            comprobarPermisos()
        }
    }

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
        Toast.makeText(context, "${ubicacion.latitude}, ${ubicacion.longitude}",
            Toast.LENGTH_SHORT).show()
        binding.tvLatitud.text = getString(R.string.latitud, ubicacion.latitude)
        binding.tvLongitud.text = getString(R.string.longitud, ubicacion.longitude)
        binding.tvDireccion.text = buscarDireccion(ubicacion)
    }

    //Dirección
    private fun buscarDireccion(ubicacion: Location): String
    {
        val geocoder = Geocoder(context, Locale.getDefault())
        val direcciones = geocoder.getFromLocation(
            ubicacion.latitude, ubicacion.longitude, 1
        )
        if (direcciones.isNotEmpty())
        {
            val direccion = direcciones.first()
            val textoDireccion =
                (0..direccion.maxAddressLineIndex)
                    .joinToString("\n") { i -> direccion.getAddressLine(i)}
            return textoDireccion
        }
        return ""
    }

    //Geolocalizacion constante
    @SuppressLint("MissingPermission")
    private fun geolocalizacionConstante()
    {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())
        val locationRequest = LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY,
            10000).build()
        locationCallback = object : LocationCallback()
        {
            override fun onLocationResult(locationResult: LocationResult)
            {
                for (location in locationResult.locations)
                    imprimirUbicacion(location)
            }
        }
        fusedLocationClient.requestLocationUpdates(
            locationRequest,
            locationCallback, Looper.getMainLooper()
        )
    }

    }