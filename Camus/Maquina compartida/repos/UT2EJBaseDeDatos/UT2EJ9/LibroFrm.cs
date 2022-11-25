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
    public partial class LibroFrm : Form
    {
        Libro libro;
        public LibroFrm(Libro libro)
        {
            InitializeComponent();
            this.libro = libro;
            this.txtTitulo.Text=libro.Titulo;
            this.txtAutor.Text = libro.Autor;
            this.txtAno.Text = libro.Anno.ToString();
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            this.Close();
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

        private void Guardar()
        {
            libro.Anno = int.Parse(txtAno.Text);
            libro.Autor = txtAutor.Text;
            libro.Titulo = txtTitulo.Text;

            if (libro.LibroId==0)
            {
                Negocio.CrearLibro(libro);
            }
            else
            {
                //Negocio.ObtenerLibro(libro.LibroId).Titulo=libro.Titulo;
                //Negocio.ObtenerLibro(libro.LibroId).Autor = libro.Autor;
                //Negocio.ObtenerLibro(libro.LibroId).Anno = libro.Anno;
            }
        }
    }
}
