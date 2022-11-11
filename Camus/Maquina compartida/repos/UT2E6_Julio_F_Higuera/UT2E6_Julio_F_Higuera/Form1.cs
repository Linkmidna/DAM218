using System;
using System.Collections;
using System.Windows.Forms;

namespace UT2E6_Julio_F_Higuera
{
    public partial class Form1 : Form
    {
        NumeroComparer comparador = new NumeroComparer();
        public Form1()
        {
            InitializeComponent();
           
            lvLista.ListViewItemSorter = comparador;
            comparador.Orden = SortOrder.None;
        }

        private void btnAnadir_Click(object sender, EventArgs e)
        {
            if (!txtNuevo.Text.Equals(string.Empty) && int.TryParse(txtNuevo.Text, out int result))
            {
                lvLista.Items.Add(txtNuevo.Text);
            }
            txtNuevo.Text = String.Empty;
            Actualizar();
        }

        private void Actualizar()
        {
            int elementos = lvLista.Items.Count;
            int suma = 0;
            int media;
            int? maximo = null;
            int? minimo = null;
            int aux;
            if (elementos > 0)
            {
                for (int i = 0; i < elementos; i++)
                {
                    aux = int.Parse(lvLista.Items[i].Text);
                    suma += aux;
                    if (maximo == null)
                    {
                        maximo = aux;
                    }
                    else if (aux > maximo)
                    {
                        maximo = aux;
                    }
                    if (minimo == null)
                    {
                        minimo = aux;
                    }
                    else if (aux < minimo)
                    {
                        minimo = aux;
                    }
                }
                media = suma / elementos;
                txtElementos.Text = elementos.ToString();
                txtSumatorio.Text = suma.ToString();
                txtMedia.Text = media.ToString();
                txtMaximo.Text = maximo.ToString();
                txtMinimo.Text = minimo.ToString();
            }
            else
            {
                txtElementos.Text = "0";
                txtSumatorio.Text = "0";
                txtMedia.Text = "0";
                txtMaximo.Text = "0";
                txtMinimo.Text = "0";
            }
        }

        private void btnEliminar_Click(object sender, EventArgs e)
        {
            if (lvLista.SelectedItems.Count > 0)
            {
                lvLista.Items.Remove(lvLista.SelectedItems[0]);
                Actualizar();
            }

        }

        private void btnOrdenar_Click(object sender, EventArgs e)
        {
            if (comparador.Orden == SortOrder.None)
            {
                lvLista.Sort();
                comparador.Orden = SortOrder.Ascending;
            }
            else if (comparador.Orden == SortOrder.Ascending)
            {
                lvLista.Sort();
                comparador.Orden = SortOrder.Descending;
            }
            else if(comparador.Orden == SortOrder.Descending)
            {
                lvLista.Sort();
                comparador.Orden = SortOrder.None;
            }
        }
    }
}
