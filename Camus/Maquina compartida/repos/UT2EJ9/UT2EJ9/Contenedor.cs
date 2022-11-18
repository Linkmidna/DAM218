using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace UT2EJ9
{
    public partial class Contenedor : Form
    {
        public Contenedor()
        {
            InitializeComponent();
            Libro libro = new Libro();
            libro.Autor = "Pedro";
            libro.Titulo = "La comedia de pedro";
            libro.Anno = 1994;
            Negocio.CrearLibro(libro);
        }

        private void tsmiCascada_Click(object sender, EventArgs e)
        {
            LayoutMdi(MdiLayout.Cascade);
        }

        private void tsmiHorizontal_Click(object sender, EventArgs e)
        {
            LayoutMdi(MdiLayout.TileHorizontal);
        }

        private void tsmiVertical_Click(object sender, EventArgs e)
        {
            LayoutMdi(MdiLayout.TileVertical);
        }

        private void tsmiSalir_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void tsmiPeliculas_Click(object sender, EventArgs e)
        {
            ListaPeliculaFrm lPelicula = new ListaPeliculaFrm();
            lPelicula.MdiParent = this;
            lPelicula.Show();
        }

        private void tsmiLibros_Click(object sender, EventArgs e)
        {
            ListaLibroFrm lLibro = new ListaLibroFrm();
            lLibro.MdiParent = this;
            lLibro.Show();
        }
    }
}
