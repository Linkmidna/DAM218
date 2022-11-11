using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace UT2E2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            cbSituacion.SelectedIndex = 0;
        }

        private void cbSituacion_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void ckOtras_CheckedChanged(object sender, EventArgs e)
        {
            if (ckOtras.Checked)
            {
                txtAficiones.Enabled = true;
            }
            else
            {
                txtAficiones.Enabled = false;
                txtAficiones.Text = "";
            }
        }

        private void btnReiniciar_Click(object sender, EventArgs e)
        {
            txtNombre.Text = "";
            dtpNacimiento.Text=DateTime.Now.ToShortDateString();
            rbHombre.Checked = true;
            ckDeportes.Checked = false;
            ckLectura.Checked = false;
            ckMusica.Checked= false;
            ckOtras.Checked=false;
            cbSituacion.SelectedIndex=0;
        }
    }
}
