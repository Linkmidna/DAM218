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
    public partial class PeliculaFrm : Form
    {
        Pelicula pelicula;
        public PeliculaFrm(Pelicula pelicula)
        {
            InitializeComponent();
            this.pelicula = pelicula;
            this.txtTitulo.Text = pelicula.Titulo;
            this.txtGenero.Text = pelicula.Genero;
            this.txtAno.Text = pelicula.Anno.ToString();
        }

        private void btnAceptar_Click(object sender, EventArgs e)
        {
            if (int.TryParse(txtAno.Text, out int result))
            {
                Guardar();
                this.Close();
            }
            else
            {
                MessageBox.Show("Que no metas letras en el año");
            }
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            this.Close();
        }
        private void Guardar()
        {
            pelicula.Anno = int.Parse(txtAno.Text);
            pelicula.Genero = txtGenero.Text;
            pelicula.Titulo = txtTitulo.Text;

            if (pelicula.PeliculaId == 0)
            {
                Negocio.CrearPelicula(pelicula);
            }
            else
            {

            }
        }
    }
}
