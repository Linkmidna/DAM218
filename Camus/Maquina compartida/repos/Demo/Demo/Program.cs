using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo
{
    internal class Program
    {
        static void Main(string[] args)
        {
            InsertarDatos();
            SeleccionarDatos();
        }

        public static void ActualizarDatos()
        {
            DemoBD bd = new DemoBD();
            Cliente clientebd = bd.Clientes.FirstOrDefault(x => x.ClienteId == 1);

            if (clientebd != null)
            {
                clientebd.Nombre = "Quaxly";
                bd.SaveChanges();
            }
        }

        public static void SeleccionarDatos()
        {
            DemoBD db = new DemoBD();
            List<Gasto> resultado = db.Gastos.Where(x => x.Importe >= 40).ToList();
            foreach (Gasto gasto in resultado)
            {
                Console.WriteLine(gasto.Importe + " " + gasto.Fecha.ToShortDateString());
            }

            Cliente cliente = db.Clientes.FirstOrDefault(x => x.Nombre == "fuecoco");
            if (cliente != null)
            {
                Console.WriteLine($"Cliente{cliente.Nombre}, con id {cliente.ClienteId}");
            }
            else
            {
                Console.WriteLine("Cliente no encontrado.");
            }
        }
        public static void InsertarDatos()
        {
            DemoBD bd = new DemoBD();

            Cliente cliente = new Cliente();
            cliente.Nombre = "Sprigatito";
            //cliente.ClienteId = -1;

            bd.Clientes.Add(cliente);

            Gasto gasto=new Gasto();
            gasto.Importe = 23.5f;
            gasto.Fecha = new DateTime(2022, 12, 24);
            //gasto.GastoId = -1;

            Gasto gasto2 = new Gasto();
            gasto2.Importe = 54.70f;
            gasto2.Fecha = new DateTime(2022, 12, 4);
            //gasto2.GastoId = -1;

            bd.Gastos.Add(gasto);
            bd.Gastos.Add(gasto2);

            bd.SaveChanges();
        }
    }
}
