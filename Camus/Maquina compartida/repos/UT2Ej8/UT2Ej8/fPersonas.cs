using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Drawing.Text;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace UT2Ej8
{
    public partial class fPersonas : Form
    {
        private Clinica clinica;
        public fPersonas()
        {
            InitializeComponent();
            clinica = new Clinica();
            
        }

        public void LlenarLista()
        {
            lvPersonas.Items.Clear();
            Persona[] personas = clinica.ObtenerPersonas();
            foreach (var per in personas)
            {
                ListViewItem item = new ListViewItem(per.Nombre);
                item.Tag = per.PersonaId;
                lvPersonas.Items.Add(item);
            }
        }

        private void nuevoToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void verToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void borrarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            
        }

        private void cmsMenu_Opening(object sender, CancelEventArgs e)
        {
            this.verToolStripMenuItem.Enabled = false;
            this.nuevoToolStripMenuItem.Enabled = false;
            this.borrarToolStripMenuItem.Enabled = false;

            if (this.lvPersonas.SelectedItems.Count == 1)
            {
                this.verToolStripMenuItem.Enabled = true;
                this.nuevoToolStripMenuItem.Enabled = true;
                this.borrarToolStripMenuItem.Enabled = true;
            }
            else
            {
                this.nuevoToolStripMenuItem.Enabled = true;
            }
        }
    }
}
