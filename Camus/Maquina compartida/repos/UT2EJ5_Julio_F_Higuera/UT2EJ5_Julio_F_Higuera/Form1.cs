using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace UT2EJ5_Julio_F_Higuera
{
    public partial class Form1 : Form
    {
        string texto = String.Empty;
        string rutaActual = String.Empty;
        Boolean descartar;
        string textoBusqueda = string.Empty;
        int inicioBusqueda;
        public Form1()
        {
            InitializeComponent();

        }

        //MENU ARCHIVO

        private Boolean ComprobarDescarte()
        {
            string message = "Hay un archivo en edición en curso ¿Desea descartarlo?";
            string caption = "Descartar fichero";
            MessageBoxButtons buttons = MessageBoxButtons.YesNo;
            DialogResult result;

            result = MessageBox.Show(message, caption, buttons);
            if (result == System.Windows.Forms.DialogResult.Yes)
            {
                return true;
            }
            return false;
        }

        private void tsmAbrir_Click(object sender, EventArgs e)
        {
            if (!texto.Equals(txtTexto.Text))
            {
                descartar = ComprobarDescarte();
            }
            if (texto.Equals(txtTexto.Text) || descartar == true)
            {
                OpenFileDialog ofd = new OpenFileDialog();
                ofd.Filter = "Archivos de texto (*.txt)|*.txt";
                ofd.Multiselect = false;
                ofd.Title = "Abrir archivo";
                if (ofd.ShowDialog() == DialogResult.OK)
                {
                    texto = File.ReadAllText(ofd.FileName);
                    txtTexto.Text = texto;
                    rutaActual = ofd.FileName;
                }
            }
        }

        private void tsmGuardar_Click(object sender, EventArgs e)
        {
            if (!rutaActual.Equals(String.Empty))
            {
                texto = txtTexto.Text;
                File.WriteAllText(rutaActual, texto);
            }
            else
            {
                SaveFileDialog sfd = new SaveFileDialog();
                sfd.Filter = "Archivos de texto (*.txt)|*.txt";
                sfd.Title = "Guardar archivo";
                if (sfd.ShowDialog() == DialogResult.OK)
                {
                    texto = txtTexto.Text;
                    File.WriteAllText(sfd.FileName, texto);
                    rutaActual = sfd.FileName;
                }
            }
        }

        private void tsmNuevo_Click(object sender, EventArgs e)
        {
            if (!texto.Equals(txtTexto.Text))
            {
                descartar = ComprobarDescarte();
            }
            if (texto.Equals(txtTexto.Text) || descartar == true)
            {
                texto = "";
                txtTexto.Text = texto;
                rutaActual = String.Empty;
            }
        }

        private void tsmSalir_Click(object sender, EventArgs e)
        {
            if (!texto.Equals(txtTexto.Text))
            {
                descartar = ComprobarDescarte();
            }
            if (texto.Equals(txtTexto.Text) || descartar == true)
            {
                Application.Exit();
            }
        }

        private void tsmGuardarComo_Click(object sender, EventArgs e)
        {
            SaveFileDialog sfd = new SaveFileDialog();
            sfd.Filter = "Archivos de texto (*.txt)|*.txt";
            sfd.Title = "Guardar archivo";
            if (sfd.ShowDialog() == DialogResult.OK)
            {
                texto = txtTexto.Text;
                File.WriteAllText(sfd.FileName, texto);
                rutaActual = sfd.FileName;
            }
        }



        // MENU EDICION

        private void tsmDeshacer_Click(object sender, EventArgs e)
        {
            if (txtTexto.CanUndo)
            {
                txtTexto.Undo();
            }
        }

        private void tsmCortar_Click(object sender, EventArgs e)
        {
            txtTexto.Cut();
        }

        private void tsmCopiar_Click(object sender, EventArgs e)
        {
            txtTexto.Copy();
        }

        private void tsmPegar_Click(object sender, EventArgs e)
        {
            txtTexto.Paste();
        }

        private void tsmEliminar_Click(object sender, EventArgs e)
        {
            txtTexto.Text = txtTexto.Text.Remove(txtTexto.SelectionStart ,txtTexto.SelectionLength);
        }

        private void tsmBuscar_Click(object sender, EventArgs e)
        {
            
            Form3 buscar = new Form3();
            
            if (buscar.ShowDialog() == DialogResult.OK)
            {
                textoBusqueda = buscar.Buscar();
                if (txtTexto.Text.Contains(textoBusqueda))
                {
                    txtTexto.Select(inicioBusqueda=txtTexto.Text.IndexOf(textoBusqueda, 0),textoBusqueda.Length);
                    inicioBusqueda += textoBusqueda.Length;
                }
            }
        }
        private void tsmBuscarSiguiente_Click(object sender, EventArgs e)
        {
            if (!textoBusqueda.Equals(string.Empty))
            {
                try
                {
                    txtTexto.Select(inicioBusqueda = txtTexto.Text.IndexOf(textoBusqueda, inicioBusqueda), textoBusqueda.Length);
                    inicioBusqueda += textoBusqueda.Length;
                }catch(ArgumentOutOfRangeException )
                {
                    inicioBusqueda = 0;
                    txtTexto.Select(inicioBusqueda = txtTexto.Text.IndexOf(textoBusqueda, inicioBusqueda), textoBusqueda.Length);
                    inicioBusqueda += textoBusqueda.Length;
                }
            }
        }

        private void tsmSeleccionarTodo_Click(object sender, EventArgs e)
        {
            txtTexto.SelectAll();
        }



        // MENU FORMATO

        private void tsmFuente_Click(object sender, EventArgs e)
        {
            FontDialog fuente = new FontDialog();
            fuente.ShowDialog();
            txtTexto.Font = fuente.Font;
        }

        private void tsmAjusteDeLinea_Click(object sender, EventArgs e)
        {
            if (tsmAjusteDeLinea.Checked)
            {
                txtTexto.WordWrap = true;
            }
            else
            {
                txtTexto.WordWrap = false;
            }
        }

        // MENU AYUDA
        private void tsmAcercaDe_Click(object sender, EventArgs e)
        {
            Form2 ayuda = new Form2();
            ayuda.ShowDialog();
        }

        
    }
}
