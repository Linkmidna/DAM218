namespace UT2EJ9
{
    partial class ListaPeliculaFrm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.tsmiPelicula = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiCrear = new System.Windows.Forms.ToolStripMenuItem();
            this.lvPeliculas = new System.Windows.Forms.ListView();
            this.chTitulo = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.chAño = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.chGenero = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.cmsPeliculas = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.cmsCrear = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiVer = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiBorrar = new System.Windows.Forms.ToolStripMenuItem();
            this.menuStrip1.SuspendLayout();
            this.cmsPeliculas.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsmiPelicula});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(800, 24);
            this.menuStrip1.TabIndex = 3;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // tsmiPelicula
            // 
            this.tsmiPelicula.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsmiCrear});
            this.tsmiPelicula.Name = "tsmiPelicula";
            this.tsmiPelicula.Size = new System.Drawing.Size(60, 20);
            this.tsmiPelicula.Text = "Pelicula";
            // 
            // tsmiCrear
            // 
            this.tsmiCrear.Name = "tsmiCrear";
            this.tsmiCrear.Size = new System.Drawing.Size(102, 22);
            this.tsmiCrear.Text = "Crear";
            this.tsmiCrear.Click += new System.EventHandler(this.tsmiCrear_Click);
            // 
            // lvPeliculas
            // 
            this.lvPeliculas.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.chTitulo,
            this.chAño,
            this.chGenero});
            this.lvPeliculas.ContextMenuStrip = this.cmsPeliculas;
            this.lvPeliculas.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.lvPeliculas.GridLines = true;
            this.lvPeliculas.HideSelection = false;
            this.lvPeliculas.Location = new System.Drawing.Point(0, 27);
            this.lvPeliculas.MultiSelect = false;
            this.lvPeliculas.Name = "lvPeliculas";
            this.lvPeliculas.Size = new System.Drawing.Size(800, 423);
            this.lvPeliculas.TabIndex = 4;
            this.lvPeliculas.UseCompatibleStateImageBehavior = false;
            this.lvPeliculas.View = System.Windows.Forms.View.Details;
            this.lvPeliculas.DoubleClick += new System.EventHandler(this.lvPeliculas_DoubleClick);
            // 
            // chTitulo
            // 
            this.chTitulo.Text = "Titulo";
            this.chTitulo.Width = 247;
            // 
            // chAño
            // 
            this.chAño.Text = "Año";
            this.chAño.Width = 188;
            // 
            // chGenero
            // 
            this.chGenero.Text = "Genero";
            this.chGenero.Width = 196;
            // 
            // cmsPeliculas
            // 
            this.cmsPeliculas.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.cmsCrear,
            this.tsmiVer,
            this.tsmiBorrar});
            this.cmsPeliculas.Name = "cmsLibros";
            this.cmsPeliculas.Size = new System.Drawing.Size(107, 70);
            this.cmsPeliculas.Opening += new System.ComponentModel.CancelEventHandler(this.cmsPeliculas_Opening);
            // 
            // cmsCrear
            // 
            this.cmsCrear.Name = "cmsCrear";
            this.cmsCrear.Size = new System.Drawing.Size(180, 22);
            this.cmsCrear.Text = "Crear";
            this.cmsCrear.Click += new System.EventHandler(this.cmsCrear_Click);
            // 
            // tsmiVer
            // 
            this.tsmiVer.Name = "tsmiVer";
            this.tsmiVer.Size = new System.Drawing.Size(180, 22);
            this.tsmiVer.Text = "Ver";
            this.tsmiVer.Click += new System.EventHandler(this.tsmiVer_Click);
            // 
            // tsmiBorrar
            // 
            this.tsmiBorrar.Name = "tsmiBorrar";
            this.tsmiBorrar.Size = new System.Drawing.Size(180, 22);
            this.tsmiBorrar.Text = "Borrar";
            this.tsmiBorrar.Click += new System.EventHandler(this.tsmiBorrar_Click);
            // 
            // ListaPeliculaFrm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.lvPeliculas);
            this.Controls.Add(this.menuStrip1);
            this.Name = "ListaPeliculaFrm";
            this.Text = "ListaPeliculaFrm";
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.cmsPeliculas.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem tsmiPelicula;
        private System.Windows.Forms.ToolStripMenuItem tsmiCrear;
        private System.Windows.Forms.ListView lvPeliculas;
        private System.Windows.Forms.ColumnHeader chTitulo;
        private System.Windows.Forms.ColumnHeader chAño;
        private System.Windows.Forms.ColumnHeader chGenero;
        private System.Windows.Forms.ContextMenuStrip cmsPeliculas;
        private System.Windows.Forms.ToolStripMenuItem cmsCrear;
        private System.Windows.Forms.ToolStripMenuItem tsmiVer;
        private System.Windows.Forms.ToolStripMenuItem tsmiBorrar;
    }
}