namespace UT2EJ9
{
    partial class Contenedor
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
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.tsmiArchivo = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiMantenimiento = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiVentanas = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiSalir = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiPeliculas = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiLibros = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiCascada = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiHorizontal = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiVertical = new System.Windows.Forms.ToolStripMenuItem();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsmiArchivo,
            this.tsmiMantenimiento,
            this.tsmiVentanas});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(800, 24);
            this.menuStrip1.TabIndex = 1;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // tsmiArchivo
            // 
            this.tsmiArchivo.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsmiSalir});
            this.tsmiArchivo.Name = "tsmiArchivo";
            this.tsmiArchivo.Size = new System.Drawing.Size(60, 20);
            this.tsmiArchivo.Text = "Archivo";
            // 
            // tsmiMantenimiento
            // 
            this.tsmiMantenimiento.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsmiPeliculas,
            this.tsmiLibros});
            this.tsmiMantenimiento.Name = "tsmiMantenimiento";
            this.tsmiMantenimiento.Size = new System.Drawing.Size(101, 20);
            this.tsmiMantenimiento.Text = "Mantenimiento";
            // 
            // tsmiVentanas
            // 
            this.tsmiVentanas.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsmiCascada,
            this.tsmiHorizontal,
            this.tsmiVertical});
            this.tsmiVentanas.Name = "tsmiVentanas";
            this.tsmiVentanas.Size = new System.Drawing.Size(66, 20);
            this.tsmiVentanas.Text = "Ventanas";
            // 
            // tsmiSalir
            // 
            this.tsmiSalir.Name = "tsmiSalir";
            this.tsmiSalir.Size = new System.Drawing.Size(180, 22);
            this.tsmiSalir.Text = "Salir";
            this.tsmiSalir.Click += new System.EventHandler(this.tsmiSalir_Click);
            // 
            // tsmiPeliculas
            // 
            this.tsmiPeliculas.Name = "tsmiPeliculas";
            this.tsmiPeliculas.Size = new System.Drawing.Size(180, 22);
            this.tsmiPeliculas.Text = "Peliculas";
            this.tsmiPeliculas.Click += new System.EventHandler(this.tsmiPeliculas_Click);
            // 
            // tsmiLibros
            // 
            this.tsmiLibros.Name = "tsmiLibros";
            this.tsmiLibros.Size = new System.Drawing.Size(180, 22);
            this.tsmiLibros.Text = "Libros";
            this.tsmiLibros.Click += new System.EventHandler(this.tsmiLibros_Click);
            // 
            // tsmiCascada
            // 
            this.tsmiCascada.Name = "tsmiCascada";
            this.tsmiCascada.Size = new System.Drawing.Size(180, 22);
            this.tsmiCascada.Text = "Cascada";
            this.tsmiCascada.Click += new System.EventHandler(this.tsmiCascada_Click);
            // 
            // tsmiHorizontal
            // 
            this.tsmiHorizontal.Name = "tsmiHorizontal";
            this.tsmiHorizontal.Size = new System.Drawing.Size(180, 22);
            this.tsmiHorizontal.Text = "Horizontal";
            this.tsmiHorizontal.Click += new System.EventHandler(this.tsmiHorizontal_Click);
            // 
            // tsmiVertical
            // 
            this.tsmiVertical.Name = "tsmiVertical";
            this.tsmiVertical.Size = new System.Drawing.Size(180, 22);
            this.tsmiVertical.Text = "Vertical";
            this.tsmiVertical.Click += new System.EventHandler(this.tsmiVertical_Click);
            // 
            // Contenedor
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.menuStrip1);
            this.IsMdiContainer = true;
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "Contenedor";
            this.Text = "Contenedor";
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem tsmiArchivo;
        private System.Windows.Forms.ToolStripMenuItem tsmiSalir;
        private System.Windows.Forms.ToolStripMenuItem tsmiMantenimiento;
        private System.Windows.Forms.ToolStripMenuItem tsmiPeliculas;
        private System.Windows.Forms.ToolStripMenuItem tsmiLibros;
        private System.Windows.Forms.ToolStripMenuItem tsmiVentanas;
        private System.Windows.Forms.ToolStripMenuItem tsmiCascada;
        private System.Windows.Forms.ToolStripMenuItem tsmiHorizontal;
        private System.Windows.Forms.ToolStripMenuItem tsmiVertical;
    }
}

