using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Timers;

namespace JuegoConsola
{
    public class Motor
    {
        /// <summary>
        /// Temporizador encargado de refrescar el juego
        /// </summary>
        private Timer reloj;
        private int granizo;
        private int queco;
        private int resolucionX;
        private int resolucionY;
        private int velocidad;

        /// <summary>
        /// Constructor por defecto
        /// </summary>
        /// <remarks>
        /// 1 - Instanciar granizo pasandole resolucionX y resolucionY
        /// 2 - Instanciar queco pasandole resolucionX
        /// 3 - Dar un valor por defecto a Velocidad de 1000 (1 segundo)
        /// 4 - intanciar el evento time elapsed del reloj
        /// reloj.Elapsed += new ElapsedEventHandler(reloj_Elapsed);
        /// </remarks>
        public Motor(int resolucionX, int resolucionY)
        {
            throw new System.NotImplementedException();
        }


        /// <summary>
        /// Obtiene o establece el ancho de nuestra matriz de juego
        /// </summary>
        /// <remarks>
        /// get
        /// 1 - devolver resolucionX
        /// 
        /// set
        /// 1 - resolucionX = value
        /// 2 - intanciar de granizo pasandole resolucionX y resolucionY
        /// 3 - instanciar queco pasandole resolucionX
        /// </remarks>
        public int ResolucionX
        {
            get
            {
                throw new System.NotImplementedException();
            }
            set
            {
            }
        }

        /// <summary>
        /// Obtiene o establece el alto de nuestra matriz de juego
        /// </summary>
        /// <remarks>
        /// get
        /// 1 - devolver resolucionY
        /// 
        /// set
        /// 1 - resolucionY = value
        /// 2 - intanciar de granizo pasandole resolucionX y resolucionY
        /// </remarks>
        public int ResolucionY
        {
            get
            {
                throw new System.NotImplementedException();
            }
            set
            {
            }
        }

        /// <summary>
        /// Obtene o establece la velocidad de movimiento del granizo
        /// </summary>
        /// <remarks>
        /// get
        /// 1 - devolver velocidad
        /// 
        /// set
        /// 1 - asignar velocidad = value
        /// 2 - llamar a Parar
        /// 3 - volver a instanciar reloj
        /// </remarks>
        public int Velocidad
        {
            get
            {
                throw new System.NotImplementedException();
            }
            set
            {

            }
        }

        /// <summary>
        /// Obtiene o establece el numero de bolas por linea de granizo
        /// </summary>
       /// <remarks>
        /// get
        /// 1 - devolver bolasPorLinea
        /// 
        /// set
        /// 1 - asignar bolasPorLinea = value
        /// 2 - llamar a Parar
        /// 3 - granizo.BolasPorLinea = value
        /// </remarks>
        public int BolasPorLinea
        {
            get
            {
                throw new System.NotImplementedException();
            }
            set
            {

            }
        }

        /// <summary>
        /// Refresca la pantalla
        /// </summary>
        /// <remarks>
        /// 2 - llamar a ComprobarColision()
        /// 2.1 - si existe colision 
        /// 2.1.1 - llamar a Parar()
        /// 3 - Limpiar la consola con Console.Clear()
        /// 4 - Escribir en consola granizo.Estado poniendo un * donde se encuentre un valor 1, espacio con el valor 0
        /// 5 - Escribir en consola queco.Posicion poniendo una X donde se encuentre, el resto de valores como espacio
        /// </remarks>
        private void Dibujar()
        {                        
            throw new System.NotImplementedException();
        }

        /// <summary>
        /// Manejador del evento TimeElapsed del reloj
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        /// <remarks>
        /// 1 - llamar a granizo.AvanzarLinea()
        /// 2 - llamar a Dibujar()
        /// </remarks>
        private void reloj_Elapsed(object sender, ElapsedEventArgs e)
        {
            throw new NotImplementedException();
        }

        /// <summary>
        /// Arranca el juego
        /// </summary>
        /// <remarks>
        /// 1 - llamar a queco.MoverCentro()
        /// 2 - llamar a granizo.Limpiar()
        /// 1 - Arrancar el timer con Enable = true
        /// </remarks>
        public void Arrancar()
        {
            throw new System.NotImplementedException();
        }

        /// <summary>
        /// Detiene el juego
        /// </summary>
        /// <remarks>
        /// Detiene el timer y desmapea el evento keypress
        /// 1 - deshabilitar el reloj, enable = false
        /// </remarks>
        public void Parar()
        {
            throw new System.NotImplementedException();
        }

        /// <summary>
        /// Comprueba si el queco a chocado con un granizo
        /// </summary>
        /// <returns>Devuelve verdadero si se ha producido una colision</returns>
        /// <remarks>
        /// 1 - comprobar si granizo.Estado[0, queco.Posicion] esta ocupada
        /// 1.1 - devolver true si esta ocupada
        /// 1.2 -sino devolver false
        /// </remarks>
        public bool ComprobarColision()
        {
            throw new System.NotImplementedException();
        }

        /// <summary>
        /// Indica al motor la tecla pulsada.
        /// </summary>
        /// <param name="tecla"></param>
        /// <remarks>
        /// 1 - Si tecla es derecha
        /// 1.1 - llamar a queco.MoverDerecha()
        /// 1.2 - llamar a Dibujar()
        /// 2 - si tecla es izquirda
        /// 2.1 - llamar a queco.MoverIzquierda()
        /// 2.2 - llamar a Dibujar()
        /// </remarks>
        public void TeclaPulsada(ConsoleKeyInfo tecla)
        {
            throw new System.NotImplementedException();
        }
    }
}
