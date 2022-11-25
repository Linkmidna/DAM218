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
    public partial class ListaPeliculaFrm : Form
    {
        public ListaPeliculaFrm()
        {
            InitializeComponent();
            LlenarLista();
        }

        private void cmsPeliculas_Opening(object sender, CancelEventArgs e)
        {
            this.tsmiCrear.Enabled = false;
            this.tsmiBorrar.Enabled = false;
            this.tsmiVer.Enabled = false;

            if (this.lvPeliculas.SelectedItems.Count == 1)
            {
                this.tsmiCrear.Enabled = true;
                this.tsmiBorrar.Enabled = true;
                this.tsmiVer.Enabled = true;
            }
            else
            {
                this.tsmiCrear.Enabled = true;
            }
        }
        private void tsmiCrear_Click(object sender, EventArgs e)
        {
            Pelicula nuevo = new Pelicula();
            nuevo.PeliculaId = 0;
            NuevoCrear(nuevo);
        }

        private void cmsCrear_Click(object sender, EventArgs e)
        {
            Pelicula nuevo = new Pelicula();
            nuevo.PeliculaId = 0;
            NuevoCrear(nuevo);
        }

        private void tsmiVer_Click(object sender, EventArgs e)
        {
            NuevoCrear(Negocio.ObtenerPelicula(int.Parse(lvPeliculas.SelectedItems[0].Tag.ToString())));
        }

        private void tsmiBorrar_Click(object sender, EventArgs e)
        {
            Borrar();
        }
        private void Borrar()
        {

            string message = "¿Desea eliminar la pelicula de la lista?";
            string caption = "Eliminar pelicula";
            MessageBoxButtons buttons = MessageBoxButtons.YesNo;
            DialogResult result;

            result = MessageBox.Show(message, caption, buttons);
            if (result == DialogResult.Yes)
            {
                Negocio.BorrarPelicula(int.Parse(lvPeliculas.SelectedItems[0].Tag.ToString()));
                LlenarLista();
            }
        }
        private void LlenarLista()
        {
            lvPeliculas.Items.Clear();
            Pelicula[] peliculas = Negocio.ObtenerPeliculas().ToArray();
          
            foreach (var pel in peliculas)
            {
                string[] pelicula = new string[3];
                pelicula[0] = pel.Titulo;
                pelicula[1] = pel.Anno.ToString();
                pelicula[2] = pel.Genero;
                ListViewItem item = new ListViewItem(pelicula);
                item.Tag = pel.PeliculaId;
                lvPeliculas.Items.Add(item);
            }
        }

        private void NuevoCrear(Pelicula pelicula)
        {
            PeliculaFrm pelForm = new PeliculaFrm(pelicula);
            pelForm.ShowDialog();
            LlenarLista();
        }

        private void lvPeliculas_DoubleClick(object sender, EventArgs e)
        {
            if (lvPeliculas.SelectedIndices.Count>0)
            {
                NuevoCrear(Negocio.ObtenerPelicula(int.Parse(lvPeliculas.SelectedItems[0].Tag.ToString())));
            }
        }
    }
}
