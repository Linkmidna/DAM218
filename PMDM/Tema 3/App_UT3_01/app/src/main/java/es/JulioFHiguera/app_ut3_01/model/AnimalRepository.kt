package es.JulioFHiguera.app_ut3_01.model

class AnimalRepository
{
    fun get(): List<Animal> = DatosAnimales.getDatosAnimales()
}