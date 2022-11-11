namespace UT2E7
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.scContenedor = new System.Windows.Forms.SplitContainer();
            this.tvArbol = new System.Windows.Forms.TreeView();
            this.lvLista = new System.Windows.Forms.ListView();
            this.chNombre = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.chFecha = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.chTamaño = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.ilIconos = new System.Windows.Forms.ImageList(this.components);
            ((System.ComponentModel.ISupportInitialize)(this.scContenedor)).BeginInit();
            this.scContenedor.Panel1.SuspendLayout();
            this.scContenedor.Panel2.SuspendLayout();
            this.scContenedor.SuspendLayout();
            this.SuspendLayout();
            // 
            // scContenedor
            // 
            this.scContenedor.Dock = System.Windows.Forms.DockStyle.Fill;
            this.scContenedor.Location = new System.Drawing.Point(0, 0);
            this.scContenedor.Name = "scContenedor";
            // 
            // scContenedor.Panel1
            // 
            this.scContenedor.Panel1.Controls.Add(this.tvArbol);
            // 
            // scContenedor.Panel2
            // 
            this.scContenedor.Panel2.Controls.Add(this.lvLista);
            this.scContenedor.Size = new System.Drawing.Size(800, 450);
            this.scContenedor.SplitterDistance = 266;
            this.scContenedor.TabIndex = 0;
            // 
            // tvArbol
            // 
            this.tvArbol.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tvArbol.ImageIndex = 1;
            this.tvArbol.ImageList = this.ilIconos;
            this.tvArbol.Location = new System.Drawing.Point(0, 0);
            this.tvArbol.Name = "tvArbol";
            this.tvArbol.SelectedImageIndex = 1;
            this.tvArbol.Size = new System.Drawing.Size(266, 450);
            this.tvArbol.TabIndex = 0;
            this.tvArbol.BeforeExpand += new System.Windows.Forms.TreeViewCancelEventHandler(this.tvArbol_BeforeExpand);
            this.tvArbol.AfterSelect += new System.Windows.Forms.TreeViewEventHandler(this.tvArbol_AfterSelect);
            // 
            // lvLista
            // 
            this.lvLista.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.chNombre,
            this.chFecha,
            this.chTamaño});
            this.lvLista.Dock = System.Windows.Forms.DockStyle.Fill;
            this.lvLista.GridLines = true;
            this.lvLista.HideSelection = false;
            this.lvLista.LargeImageList = this.ilIconos;
            this.lvLista.Location = new System.Drawing.Point(0, 0);
            this.lvLista.Name = "lvLista";
            this.lvLista.Size = new System.Drawing.Size(530, 450);
            this.lvLista.SmallImageList = this.ilIconos;
            this.lvLista.TabIndex = 0;
            this.lvLista.UseCompatibleStateImageBehavior = false;
            this.lvLista.View = System.Windows.Forms.View.Details;
            this.lvLista.ColumnClick += new System.Windows.Forms.ColumnClickEventHandler(this.lvLista_ColumnClick);
            // 
            // chNombre
            // 
            this.chNombre.Text = "Nombre";
            this.chNombre.Width = 246;
            // 
            // chFecha
            // 
            this.chFecha.Text = "Fecha";
            this.chFecha.Width = 136;
            // 
            // chTamaño
            // 
            this.chTamaño.Text = "Tamaño";
            this.chTamaño.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            this.chTamaño.Width = 144;
            // 
            // ilIconos
            // 
            this.ilIconos.ImageStream = ((System.Windows.Forms.ImageListStreamer)(resources.GetObject("ilIconos.ImageStream")));
            this.ilIconos.TransparentColor = System.Drawing.Color.Transparent;
            this.ilIconos.Images.SetKeyName(0, "folder_Closed_16xLG.png");
            this.ilIconos.Images.SetKeyName(1, "folder_Open_16xLG.png");
            this.ilIconos.Images.SetKeyName(2, "document_16xLG.png");
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.scContenedor);
            this.Name = "Form1";
            this.Text = "Explorador";
            this.scContenedor.Panel1.ResumeLayout(false);
            this.scContenedor.Panel2.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.scContenedor)).EndInit();
            this.scContenedor.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.SplitContainer scContenedor;
        private System.Windows.Forms.TreeView tvArbol;
        private System.Windows.Forms.ListView lvLista;
        private System.Windows.Forms.ColumnHeader chNombre;
        private System.Windows.Forms.ColumnHeader chFecha;
        private System.Windows.Forms.ColumnHeader chTamaño;
        private System.Windows.Forms.ImageList ilIconos;
    }
}

