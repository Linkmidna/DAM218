using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UT2Ej8.Clases;

namespace UT2Ej8
{
    public class Clinica
    {
        private static List<Persona> personas;
        private static List<Informe> informes;
        private static List<Cita> citas;
        private static int sigPersonaId = 0;
        private static int sigCitaId = 0;
        static Clinica()
        {
            Clinica.personas = new List<Persona>();
            Clinica.informes = new List<Informe>();
            Clinica.citas = new List<Cita>();
        }
        private int SiguientePersonaId()
        {
            sigPersonaId++;
            return sigPersonaId;
        }
        private int SiguienteCitaId()
        {
            sigCitaId++;
            return sigCitaId;
        }
        public Persona[] ObtenerPersonas()
        {
            return personas.ToArray();
        }
        public Persona BuscarPersona(int personaId)
        {
            Persona per=null;
            for (int i = 0; i < personas.Count; i++)
            {
                if (personas[i].PersonaId==personaId)
                {
                    per=personas[i];
                }
            }
            return per;
        }
        public void CrearPersona(Persona persona)
        {
            personas.Add(persona);
        }
        public void BorrarPersona(int personaId)
        {
            for (int i = 0; i < personas.Count; i++)
            {
                if (personas[i].PersonaId==personaId)
                {
                    personas.Remove(personas[i]);
                }
            }
        }
        public Informe BuscarInforme(int personaId)
        {
            throw new NotImplementedException();
        }
        private void CrearInforme(Informe informe)
        {
            throw new NotImplementedException();
        }
        private void BorrarInforme(int personaId)
        {
            throw new NotImplementedException();
        }
        public Cita[] BuscarCitas(int personaId)
        {
            throw new NotImplementedException();
        }
        public Cita BuscarCita(int citaId)
        {
            throw new NotImplementedException();
        }
        public void CrearCita(Cita cita)
        {
            throw new NotImplementedException();
        }
        public void BorrarCita(int citaId)
        {
            throw new NotImplementedException();
        }
    }
}
