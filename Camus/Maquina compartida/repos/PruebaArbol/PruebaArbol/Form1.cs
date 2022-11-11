using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PruebaArbol
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void tvArbol_AfterSelect(object sender, TreeViewEventArgs e)
        {
            this.txTexto.Text += "Before expand" + e.Node.Text + Environment.NewLine;
        }

        private void tvArbol_BeforeExpand(object sender, TreeViewCancelEventArgs e)
        {
            this.txTexto.Text += "Before expand" + e.Node.Text + Environment.NewLine;
        }
    }
}
