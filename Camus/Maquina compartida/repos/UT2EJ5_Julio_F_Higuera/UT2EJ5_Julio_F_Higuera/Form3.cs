using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace UT2EJ5_Julio_F_Higuera
{
    public partial class Form3 : Form
    {
        string textoBusqueda;
        public Form3()
        {
            InitializeComponent();
        }

        private void btnBusqueda_Click(object sender, EventArgs e)
        {
            if (!txtBusqueda.Text.Equals(""))
            {
                textoBusqueda=txtBusqueda.Text;
                DialogResult = DialogResult.OK;
                
            }
        }
        public string Buscar()
        {
            return textoBusqueda;
        }
    }
}
