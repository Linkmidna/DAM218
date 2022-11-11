using System.Collections;
using System.Collections.Generic;
using System.Windows.Forms;

namespace UT2E6_Julio_F_Higuera
{
    public class NumeroComparer : IComparer
    {
        public SortOrder Orden { get; set; }

        public NumeroComparer()
        {
            this.Orden = SortOrder.None;
        }

        public int Compare(object x, object y)
        {
            int objX = int.Parse(((ListViewItem)x).SubItems[0].Text);
            int objY = int.Parse(((ListViewItem)y).SubItems[0].Text);
            int result;

            if (objX > objY)
            {
                result = 1;
            }
            else if (objX < objY)
            {
                result = -1;
            }
            else
            {
                result = 0;
            }

            if (Orden==SortOrder.Ascending)
            {
                return result;
            }
            else if (Orden == SortOrder.None)
            {
                return 0;
            }
            else
            {
                return -result;

            }

        }
    }
}