using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace HolaMundo
{
    public partial class Form1 : Form
    {
        int opc = 1;
        public Form1()
        {
            InitializeComponent();

        }

        

        private void timer1_Tick(object sender, EventArgs e)
        {
            switch (opc)
            {
                case 1:
                    this.BackColor = Color.Red;
                    opc++;
                    break;
                case 2:
                    this.BackColor = Color.Green;
                    opc++;
                    break;
                case 3:
                    this.BackColor = Color.Pink;
                    opc++;
                    break;
                case 4:
                    this.BackColor = Color.Blue;
                    opc++;
                    break;
                case 5:
                    this.BackColor = Color.Yellow;
                    opc++;
                    break;
                case 6:
                    this.BackColor = Color.Purple;
                    opc++;
                    break;
                case 7:
                    this.BackColor = Color.Coral;
                    opc++;
                    break;
                case 8:
                    this.BackColor = Color.Orange;
                    opc++;
                    break;
                case 9:
                    this.BackColor = Color.Snow;
                    opc=1;
                    break;
            }
        }

        private void btnNoFiesta_Click(object sender, EventArgs e)
        {
            timer1.Enabled = false;
            this.BackColor = Color.Beige;
        }

        private void btnFiesta_Click(object sender, EventArgs e)
        {
            timer1.Enabled = true;
        }
    }
}
