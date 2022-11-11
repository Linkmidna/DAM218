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

namespace UT2E7
{
    public partial class Form1 : Form
    {
        private lvComparer lvColumnSorter;

        public Form1()
        {
            InitializeComponent();

            lvColumnSorter = new lvComparer();
            lvLista.ListViewItemSorter = lvColumnSorter;

            DirectoryInfo directorio = new DirectoryInfo(@"C:\");
            TreeNode nodoOriginal = new TreeNode(directorio.FullName);
            nodoOriginal.Tag = directorio.FullName;
            nodoOriginal.ImageIndex = 0;

            TreeNode nodoDummy = new TreeNode();
            nodoDummy.Tag = "Nodo tonto";

            nodoOriginal.Nodes.Add(nodoDummy);

            tvArbol.Nodes.Add(nodoOriginal);

        }

        private void tvArbol_AfterSelect(object sender, TreeViewEventArgs e)
        {
            try
            {
                DirectoryInfo dir = new DirectoryInfo(e.Node.Tag.ToString());
                lvLista.Items.Clear();
                DirectoryInfo[] dirs = dir.GetDirectories();
                foreach (var d in dirs)
                {
                    string[] columnas = new string[3];
                    columnas[0] = d.Name;
                    columnas[1] = d.CreationTimeUtc.ToString();
                    columnas[2] = string.Empty;
                    ListViewItem item = new ListViewItem(columnas);
                    item.ImageIndex = 0;
                    lvLista.Items.Add(item);
                }
                FileInfo[] fichs = dir.GetFiles();
                foreach(var f in fichs)
                {
                    string[] columnas = new string[3];
                    columnas[0] = f.Name;
                    columnas[1] = f.CreationTime.ToString();
                    columnas[2] = f.Length.ToString();
                    ListViewItem item = new ListViewItem(columnas);
                    item.ImageIndex=2;
                    lvLista.Items.Add(item);
                }
            }
            catch (UnauthorizedAccessException) {
                lvLista.Items.Clear();
                lvLista.Items.Add("Acceso no permitido");
            }
        }

        private void tvArbol_BeforeExpand(object sender, TreeViewCancelEventArgs e)
        {
            try
            {
                if (e.Node.Nodes[0].Tag.Equals("Nodo tonto"))
                {
                    e.Node.Nodes.Clear();
                    DirectoryInfo dir = new DirectoryInfo(e.Node.Tag.ToString());
                    DirectoryInfo[] dirs = dir.GetDirectories();
                    for (int i = 0; i < dirs.Length; i++)
                    {
                        TreeNode nodo = new TreeNode(dirs[i].Name);
                        nodo.Tag = dirs[i].FullName;

                        TreeNode noDummy = new TreeNode();
                        noDummy.Tag = "Nodo tonto";

                        nodo.Nodes.Add(noDummy);
                        nodo.ImageIndex = 0;
                        e.Node.Nodes.Add(nodo);
                    }
                }
            }
            catch (UnauthorizedAccessException) { }
        }

        private void lvLista_ColumnClick(object sender, ColumnClickEventArgs e)
        {
            if (e.Column == lvColumnSorter.SortColumn)
            {
                // Reverse the current sort direction for this column.
                if (lvColumnSorter.Order == SortOrder.Ascending)
                {
                    lvColumnSorter.Order = SortOrder.Descending;
                }
                else
                {
                    lvColumnSorter.Order = SortOrder.Ascending;
                }
            }
            else
            {
                // Set the column number that is to be sorted; default to ascending.
                lvColumnSorter.SortColumn = e.Column;
                lvColumnSorter.Order = SortOrder.Ascending;
            }

            // Perform the sort with these new sort options.
            this.lvLista.Sort();
        }
    }
}


