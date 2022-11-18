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
    public partial class ListaLibroFrm : Form
    {
        public ListaLibroFrm()
        {
            InitializeComponent();
            LlenarLista();
        }

        

        private void cmsLibros_Opening(object sender, CancelEventArgs e)
        {
            this.tsmiCrear.Enabled = false;
            this.tsmiBorrar.Enabled = false;
            this.tsmiVer.Enabled = false;

            if (this.lvLibros.SelectedItems.Count == 1)
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

        private void tsmiBorrar_Click(object sender, EventArgs e)
        {
            Borrar();
        }

        private void tsmiCrear_Click(object sender, EventArgs e)
        {
            NuevoCrear(new Libro());
        }

        private void tsmiVer_Click(object sender, EventArgs e)
        {
            NuevoCrear(Negocio.ObtenerLibro(int.Parse(lvLibros.SelectedItems[0].Tag.ToString())));
        }

        private void crearToolStripMenuItem_Click(object sender, EventArgs e)
        {
            NuevoCrear(new Libro());
        }

        private void Borrar()
        {

            string message = "¿Desea eliminar el Libro de la lista?";
            string caption = "Eliminar libro";
            MessageBoxButtons buttons = MessageBoxButtons.YesNo;
            DialogResult result;

            result = MessageBox.Show(message, caption, buttons);
            if (result == DialogResult.Yes)
            {
                Negocio.BorrarLibro(int.Parse(lvLibros.SelectedItems[0].Tag.ToString()));
                LlenarLista();
            }
        }
        private void LlenarLista()
        {
            lvLibros.Items.Clear();
            Libro[] libros = Negocio.ObtenerLibros().ToArray();
            foreach (var lib in libros)
            {
                string[] libro = new string[3];
                libro[0] = lib.Titulo;
                libro[1] = lib.Anno.ToString();
                libro[2] = lib.Autor;
                ListViewItem item = new ListViewItem(libro);
                item.Tag = lib.LibroId;
                lvLibros.Items.Add(item);
            }
        }

        private void NuevoCrear(Libro libro)
        {
            LibroFrm libForm = new LibroFrm(libro);
            libForm.ShowDialog();
        }

        
    }
}
