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
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
