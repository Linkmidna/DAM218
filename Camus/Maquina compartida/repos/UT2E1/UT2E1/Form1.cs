using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace UT2E1
{
    public partial class Form1 : Form
    {       
        double val1;
        double val2;
        public Form1()
        {
            InitializeComponent();
            
        }

        private Boolean opCheck()
        {
            if (!Double.TryParse(txtOp1.Text,out val1))
            {
                txtRes.Text = "Valor 1 mal";
                return false;
            }
            if (!Double.TryParse(txtOp2.Text, out val2))
            {
                txtRes.Text = "Valor 2 mal";
                return false;
            }
            return true;
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void btnSuma_Click(object sender, EventArgs e)
        {
            if (opCheck())
            {
                txtRes.Text = (val1 + val2).ToString();
            }
        }

        private void btnResta_Click(object sender, EventArgs e)
        {
            if (opCheck())
            {
                txtRes.Text = (val1 - val2).ToString();
            }
        }

        private void btnMultiplicar_Click(object sender, EventArgs e)
        {
            if (opCheck())
            {
                txtRes.Text = (val1 * val2).ToString();
            }
        }

        private void btnDividir_Click(object sender, EventArgs e)
        {
            if (opCheck())
            {
                txtRes.Text = (val1 / val2).ToString();
            }
        }
    }
}
