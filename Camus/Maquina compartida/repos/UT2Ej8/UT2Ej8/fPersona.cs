using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using UT2Ej8.Clases;

namespace UT2Ej8
{
    public partial class fPersona : Form
    {
        Persona persona;
        public fPersona(Persona persona)
        {
            InitializeComponent();
            this.persona = persona;

            if (this.persona.PersonaId==0)
            {
                tcPestanas.Enabled = false;
            }
        }

    }
}
