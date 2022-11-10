using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace UT2EJ5_Julio_F_Higuera
{
    public partial class Form1 : Form
    {
        string texto = String.Empty;
        public Form1()
        {
            InitializeComponent();
            
        }

        private void toolStripTextBox1_Click(object sender, EventArgs e)
        {

        }

        private void toolStripMenuItem5_Click(object sender, EventArgs e)
        {

        }

        private void tsmAbrir_Click(object sender, EventArgs e)
        {
            if (texto.Equals(txtTexto.Text))
            {
                OpenFileDialog ofd = new OpenFileDialog();
                ofd.Filter = "Archivos de texto (*.txt)|*.txt";
                ofd.Multiselect = false;
                ofd.Title = "Abrir archivo";
                if (ofd.ShowDialog() == DialogResult.OK)
                {
                    texto = File.ReadAllText(ofd.FileName);
                    txtTexto.Text = texto;
                }
            }
            
        }
    }
}
