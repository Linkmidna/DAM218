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
            Informe informe = new Informe();
            informe.PersonaId=persona.PersonaId;
            CrearInforme(informe);
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
            BorrarInforme(personaId);
            Cita[] citasBuscadas = BuscarCitas(personaId);
            for (int i = 0; i < citasBuscadas.Length; i++)
            {
                BorrarCita(citasBuscadas[i].CitaId);
            }
        }
        public Informe BuscarInforme(int personaId)
        {
            for (int i = 0; i < informes.Count; i++)
            {
                if (informes[i].PersonaId == personaId)
                {
                    return informes[i];
                }
            }
            return null;
        }
        private void CrearInforme(Informe informe)
        {
            informes.Add(informe);
        }
        private void BorrarInforme(int personaId)
        {
            for (int i = 0; i < informes.Count; i++)
            {
                if (informes[i].PersonaId == personaId)
                {
                    informes.Remove(informes[i]);
                }
            }
        }
        public Cita[] BuscarCitas(int personaId)
        {
            List<Cita> citasBuscadas = citas;
            for (int i = 0; i < citas.Count; i++)
            {
                if (citas[i].PersonaId!=personaId)
                {
                    citasBuscadas.Remove(citas[i]);
                }
            }
            return citasBuscadas.ToArray();
        }
        public Cita BuscarCita(int citaId)
        {
            for (int i = 0; i < citas.Count; i++)
            {
                if (citas[i].PersonaId == citaId)
                {
                    return citas[i];
                }
            }
            return null;
        }
        public void CrearCita(Cita cita)
        {
            citas.Add(cita);
        }
        public void BorrarCita(int citaId)
        {
            for (int i = 0; i < citas.Count; i++)
            {
                if (citas[i].PersonaId == citaId)
                {
                    citas.Remove(citas[i]);
                }
            }
        }
    }
}
