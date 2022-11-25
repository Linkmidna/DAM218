namespace UT2EJ9
{
    partial class ListaLibroFrm
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
            this.lvLibros = new System.Windows.Forms.ListView();
            this.chTitulo = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.chAño = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.chAutor = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.cmsLibros = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.tsmiCrear = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiVer = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiBorrar = new System.Windows.Forms.ToolStripMenuItem();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.libroToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.crearToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.cmsLibros.SuspendLayout();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // lvLibros
            // 
            this.lvLibros.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.chTitulo,
            this.chAño,
            this.chAutor});
            this.lvLibros.ContextMenuStrip = this.cmsLibros;
            this.lvLibros.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.lvLibros.GridLines = true;
            this.lvLibros.HideSelection = false;
            this.lvLibros.Location = new System.Drawing.Point(0, 27);
            this.lvLibros.MultiSelect = false;
            this.lvLibros.Name = "lvLibros";
            this.lvLibros.Size = new System.Drawing.Size(539, 423);
            this.lvLibros.TabIndex = 0;
            this.lvLibros.UseCompatibleStateImageBehavior = false;
            this.lvLibros.View = System.Windows.Forms.View.Details;
            // 
            // chTitulo
            // 
            this.chTitulo.Text = "Titulo";
            this.chTitulo.Width = 247;
            // 
            // chAño
            // 
            this.chAño.Text = "Año";
            // 
            // chAutor
            // 
            this.chAutor.Text = "Autor";
            this.chAutor.Width = 196;
            // 
            // cmsLibros
            // 
            this.cmsLibros.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsmiCrear,
            this.tsmiVer,
            this.tsmiBorrar});
            this.cmsLibros.Name = "cmsLibros";
            this.cmsLibros.Size = new System.Drawing.Size(107, 70);
            this.cmsLibros.Opening += new System.ComponentModel.CancelEventHandler(this.cmsLibros_Opening);
            // 
            // tsmiCrear
            // 
            this.tsmiCrear.Name = "tsmiCrear";
            this.tsmiCrear.Size = new System.Drawing.Size(180, 22);
            this.tsmiCrear.Text = "Crear";
            this.tsmiCrear.Click += new System.EventHandler(this.tsmiCrear_Click);
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
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.libroToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(539, 24);
            this.menuStrip1.TabIndex = 2;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // libroToolStripMenuItem
            // 
            this.libroToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.crearToolStripMenuItem});
            this.libroToolStripMenuItem.Name = "libroToolStripMenuItem";
            this.libroToolStripMenuItem.Size = new System.Drawing.Size(46, 20);
            this.libroToolStripMenuItem.Text = "Libro";
            // 
            // crearToolStripMenuItem
            // 
            this.crearToolStripMenuItem.Name = "crearToolStripMenuItem";
            this.crearToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.crearToolStripMenuItem.Text = "Crear";
            this.crearToolStripMenuItem.Click += new System.EventHandler(this.crearToolStripMenuItem_Click);
            // 
            // ListaLibroFrm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(539, 450);
            this.Controls.Add(this.menuStrip1);
            this.Controls.Add(this.lvLibros);
            this.Name = "ListaLibroFrm";
            this.Text = "ListaLibroFrm";
            this.cmsLibros.ResumeLayout(false);
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ListView lvLibros;
        private System.Windows.Forms.ColumnHeader chTitulo;
        private System.Windows.Forms.ColumnHeader chAño;
        private System.Windows.Forms.ColumnHeader chAutor;
        private System.Windows.Forms.ContextMenuStrip cmsLibros;
        private System.Windows.Forms.ToolStripMenuItem tsmiCrear;
        private System.Windows.Forms.ToolStripMenuItem tsmiVer;
        private System.Windows.Forms.ToolStripMenuItem tsmiBorrar;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem libroToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem crearToolStripMenuItem;
    }
}