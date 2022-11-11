using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace JuegoConsola
{
    public class Queco
    {
        private int posicion;

        /// <summary>
        /// Obtiene o establece el espacio en el que se puede mover el queco
        /// </summary>
        public int Ancho 
        {
            get { throw new System.NotImplementedException(); }
            private set { }
        }

        /// <summary>
        /// Obtiene o establece la posicion en la que se encuentra el queco
        /// </summary>
        public int Posicion
        {
            get
            {
                throw new System.NotImplementedException();
            }

            private set
            {

            }
        }

        /// <summary>
        /// Constructor de la clase
        /// </summary>
        /// <param name="resolucionX">Espacio horizontal en el que se puede mover el queco</param>
        /// <remarks>
        /// 1 - asignar a Ancho la resolucionX
        /// 2 - llamar a MoverCentro()
        /// </remarks>
        public Queco(int resolucionX)
        {
            throw new System.NotImplementedException();
        }
    
        /// <summary>
        /// Mueve el queco a la derecha
        /// </summary>
        /// <remarks>
        /// 1 - Si posicion menor que ancho
        /// 1.1 - aumenta la posicion en 1
        /// </remarks>
        public void MoverDerecha()
        {
            throw new System.NotImplementedException();
        }

        /// <summary>
        /// Mueve el queco a la izquierda
        /// </summary>
        /// <remarks>
        /// 1 - Si posicion > 0
        /// 1.1 - disminuye la posicion en 1
        /// </remarks>
        public void MoverIzquierda()
        {
            throw new System.NotImplementedException();
        }

        /// <summary>
        /// Mueve el queco al centro de la pantalla.
        /// </summary>
        /// <remarks>
        /// 1 - Esteblece posicion como (Ancho / 2) 
        /// </remarks>
        public void MoverCentro()
        {
            throw new System.NotImplementedException();
        }
    }
}
