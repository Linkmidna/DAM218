namespace UT2EJ5_Julio_F_Higuera
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
            this.txtTexto = new System.Windows.Forms.TextBox();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.toolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmNuevo = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmAbrir = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmGuardar = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmGuardarComo = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripSeparator1 = new System.Windows.Forms.ToolStripSeparator();
            this.tsmSalir = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripMenuItem2 = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmDeshacer = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripSeparator2 = new System.Windows.Forms.ToolStripSeparator();
            this.tsmCortar = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmCopiar = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmPegar = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmEliminar = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripSeparator3 = new System.Windows.Forms.ToolStripSeparator();
            this.tsmBuscar = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmBuscarSiguiente = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripSeparator4 = new System.Windows.Forms.ToolStripSeparator();
            this.tsmSeleccionarTodo = new System.Windows.Forms.ToolStripMenuItem();
            this.ayudaToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmAjusteDeLinea = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmFuente = new System.Windows.Forms.ToolStripMenuItem();
            this.ayudaToolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmAcercaDe = new System.Windows.Forms.ToolStripMenuItem();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // txtTexto
            // 
            this.txtTexto.Dock = System.Windows.Forms.DockStyle.Fill;
            this.txtTexto.Location = new System.Drawing.Point(0, 24);
            this.txtTexto.Multiline = true;
            this.txtTexto.Name = "txtTexto";
            this.txtTexto.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.txtTexto.Size = new System.Drawing.Size(800, 426);
            this.txtTexto.TabIndex = 0;
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripMenuItem1,
            this.toolStripMenuItem2,
            this.ayudaToolStripMenuItem,
            this.ayudaToolStripMenuItem1});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(800, 24);
            this.menuStrip1.TabIndex = 1;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // toolStripMenuItem1
            // 
            this.toolStripMenuItem1.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsmNuevo,
            this.tsmAbrir,
            this.tsmGuardar,
            this.tsmGuardarComo,
            this.toolStripSeparator1,
            this.tsmSalir});
            this.toolStripMenuItem1.Name = "toolStripMenuItem1";
            this.toolStripMenuItem1.Size = new System.Drawing.Size(60, 20);
            this.toolStripMenuItem1.Text = "Archivo";
            // 
            // tsmNuevo
            // 
            this.tsmNuevo.Name = "tsmNuevo";
            this.tsmNuevo.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.N)));
            this.tsmNuevo.Size = new System.Drawing.Size(159, 22);
            this.tsmNuevo.Text = "Nuevo";
            this.tsmNuevo.Click += new System.EventHandler(this.tsmNuevo_Click);
            // 
            // tsmAbrir
            // 
            this.tsmAbrir.Name = "tsmAbrir";
            this.tsmAbrir.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.A)));
            this.tsmAbrir.Size = new System.Drawing.Size(159, 22);
            this.tsmAbrir.Text = "Abrir";
            this.tsmAbrir.Click += new System.EventHandler(this.tsmAbrir_Click);
            // 
            // tsmGuardar
            // 
            this.tsmGuardar.Image = global::UT2EJ5_Julio_F_Higuera.Properties.Resources.Save_6530;
            this.tsmGuardar.Name = "tsmGuardar";
            this.tsmGuardar.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.G)));
            this.tsmGuardar.Size = new System.Drawing.Size(159, 22);
            this.tsmGuardar.Text = "Guardar";
            this.tsmGuardar.Click += new System.EventHandler(this.tsmGuardar_Click);
            // 
            // tsmGuardarComo
            // 
            this.tsmGuardarComo.Name = "tsmGuardarComo";
            this.tsmGuardarComo.Size = new System.Drawing.Size(159, 22);
            this.tsmGuardarComo.Text = "Guardar como...";
            this.tsmGuardarComo.Click += new System.EventHandler(this.tsmGuardarComo_Click);
            // 
            // toolStripSeparator1
            // 
            this.toolStripSeparator1.Name = "toolStripSeparator1";
            this.toolStripSeparator1.Size = new System.Drawing.Size(156, 6);
            // 
            // tsmSalir
            // 
            this.tsmSalir.Name = "tsmSalir";
            this.tsmSalir.Size = new System.Drawing.Size(159, 22);
            this.tsmSalir.Text = "Salir";
            this.tsmSalir.Click += new System.EventHandler(this.tsmSalir_Click);
            // 
            // toolStripMenuItem2
            // 
            this.toolStripMenuItem2.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsmDeshacer,
            this.toolStripSeparator2,
            this.tsmCortar,
            this.tsmCopiar,
            this.tsmPegar,
            this.tsmEliminar,
            this.toolStripSeparator3,
            this.tsmBuscar,
            this.tsmBuscarSiguiente,
            this.toolStripSeparator4,
            this.tsmSeleccionarTodo});
            this.toolStripMenuItem2.Name = "toolStripMenuItem2";
            this.toolStripMenuItem2.Size = new System.Drawing.Size(58, 20);
            this.toolStripMenuItem2.Text = "Edición";
            // 
            // tsmDeshacer
            // 
            this.tsmDeshacer.Image = global::UT2EJ5_Julio_F_Higuera.Properties.Resources.Undo_16x;
            this.tsmDeshacer.Name = "tsmDeshacer";
            this.tsmDeshacer.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.Z)));
            this.tsmDeshacer.Size = new System.Drawing.Size(180, 22);
            this.tsmDeshacer.Text = "Deshacer";
            this.tsmDeshacer.Click += new System.EventHandler(this.tsmDeshacer_Click);
            // 
            // toolStripSeparator2
            // 
            this.toolStripSeparator2.Name = "toolStripSeparator2";
            this.toolStripSeparator2.Size = new System.Drawing.Size(177, 6);
            // 
            // tsmCortar
            // 
            this.tsmCortar.Image = global::UT2EJ5_Julio_F_Higuera.Properties.Resources.Cut_6523;
            this.tsmCortar.Name = "tsmCortar";
            this.tsmCortar.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.X)));
            this.tsmCortar.Size = new System.Drawing.Size(180, 22);
            this.tsmCortar.Text = "Cortar";
            this.tsmCortar.Click += new System.EventHandler(this.tsmCortar_Click);
            // 
            // tsmCopiar
            // 
            this.tsmCopiar.Image = global::UT2EJ5_Julio_F_Higuera.Properties.Resources.Copy_6524;
            this.tsmCopiar.Name = "tsmCopiar";
            this.tsmCopiar.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.C)));
            this.tsmCopiar.Size = new System.Drawing.Size(180, 22);
            this.tsmCopiar.Text = "Copiar";
            this.tsmCopiar.Click += new System.EventHandler(this.tsmCopiar_Click);
            // 
            // tsmPegar
            // 
            this.tsmPegar.Image = global::UT2EJ5_Julio_F_Higuera.Properties.Resources.Paste_6520;
            this.tsmPegar.Name = "tsmPegar";
            this.tsmPegar.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.V)));
            this.tsmPegar.Size = new System.Drawing.Size(180, 22);
            this.tsmPegar.Text = "Pegar";
            this.tsmPegar.Click += new System.EventHandler(this.tsmPegar_Click);
            // 
            // tsmEliminar
            // 
            this.tsmEliminar.Name = "tsmEliminar";
            this.tsmEliminar.ShortcutKeys = System.Windows.Forms.Keys.Delete;
            this.tsmEliminar.Size = new System.Drawing.Size(180, 22);
            this.tsmEliminar.Text = "Eliminar";
            this.tsmEliminar.Click += new System.EventHandler(this.tsmEliminar_Click);
            // 
            // toolStripSeparator3
            // 
            this.toolStripSeparator3.Name = "toolStripSeparator3";
            this.toolStripSeparator3.Size = new System.Drawing.Size(177, 6);
            // 
            // tsmBuscar
            // 
            this.tsmBuscar.Name = "tsmBuscar";
            this.tsmBuscar.Size = new System.Drawing.Size(180, 22);
            this.tsmBuscar.Text = "Buscar";
            this.tsmBuscar.Click += new System.EventHandler(this.tsmBuscar_Click);
            // 
            // tsmBuscarSiguiente
            // 
            this.tsmBuscarSiguiente.Name = "tsmBuscarSiguiente";
            this.tsmBuscarSiguiente.Size = new System.Drawing.Size(180, 22);
            this.tsmBuscarSiguiente.Text = "Buscar siguiente";
            this.tsmBuscarSiguiente.Click += new System.EventHandler(this.tsmBuscarSiguiente_Click);
            // 
            // toolStripSeparator4
            // 
            this.toolStripSeparator4.Name = "toolStripSeparator4";
            this.toolStripSeparator4.Size = new System.Drawing.Size(177, 6);
            // 
            // tsmSeleccionarTodo
            // 
            this.tsmSeleccionarTodo.Name = "tsmSeleccionarTodo";
            this.tsmSeleccionarTodo.Size = new System.Drawing.Size(180, 22);
            this.tsmSeleccionarTodo.Text = "Seleccionar todo";
            this.tsmSeleccionarTodo.Click += new System.EventHandler(this.tsmSeleccionarTodo_Click);
            // 
            // ayudaToolStripMenuItem
            // 
            this.ayudaToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsmAjusteDeLinea,
            this.tsmFuente});
            this.ayudaToolStripMenuItem.Name = "ayudaToolStripMenuItem";
            this.ayudaToolStripMenuItem.Size = new System.Drawing.Size(64, 20);
            this.ayudaToolStripMenuItem.Text = "Formato";
            // 
            // tsmAjusteDeLinea
            // 
            this.tsmAjusteDeLinea.CheckOnClick = true;
            this.tsmAjusteDeLinea.Name = "tsmAjusteDeLinea";
            this.tsmAjusteDeLinea.Size = new System.Drawing.Size(151, 22);
            this.tsmAjusteDeLinea.Text = "Ajuste de línea";
            this.tsmAjusteDeLinea.Click += new System.EventHandler(this.tsmAjusteDeLinea_Click);
            // 
            // tsmFuente
            // 
            this.tsmFuente.Name = "tsmFuente";
            this.tsmFuente.Size = new System.Drawing.Size(151, 22);
            this.tsmFuente.Text = "Fuente";
            this.tsmFuente.Click += new System.EventHandler(this.tsmFuente_Click);
            // 
            // ayudaToolStripMenuItem1
            // 
            this.ayudaToolStripMenuItem1.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsmAcercaDe});
            this.ayudaToolStripMenuItem1.Name = "ayudaToolStripMenuItem1";
            this.ayudaToolStripMenuItem1.Size = new System.Drawing.Size(53, 20);
            this.ayudaToolStripMenuItem1.Text = "Ayuda";
            // 
            // tsmAcercaDe
            // 
            this.tsmAcercaDe.Name = "tsmAcercaDe";
            this.tsmAcercaDe.Size = new System.Drawing.Size(135, 22);
            this.tsmAcercaDe.Text = "Acerca de...";
            this.tsmAcercaDe.Click += new System.EventHandler(this.tsmAcercaDe_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.txtTexto);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "Form1";
            this.Text = "Form1";
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox txtTexto;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem toolStripMenuItem1;
        private System.Windows.Forms.ToolStripMenuItem tsmNuevo;
        private System.Windows.Forms.ToolStripMenuItem toolStripMenuItem2;
        private System.Windows.Forms.ToolStripMenuItem ayudaToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem tsmAbrir;
        private System.Windows.Forms.ToolStripMenuItem tsmGuardar;
        private System.Windows.Forms.ToolStripMenuItem tsmGuardarComo;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator1;
        private System.Windows.Forms.ToolStripMenuItem tsmSalir;
        private System.Windows.Forms.ToolStripMenuItem tsmDeshacer;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator2;
        private System.Windows.Forms.ToolStripMenuItem tsmCortar;
        private System.Windows.Forms.ToolStripMenuItem tsmCopiar;
        private System.Windows.Forms.ToolStripMenuItem tsmPegar;
        private System.Windows.Forms.ToolStripMenuItem tsmEliminar;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator3;
        private System.Windows.Forms.ToolStripMenuItem tsmBuscar;
        private System.Windows.Forms.ToolStripMenuItem tsmBuscarSiguiente;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator4;
        private System.Windows.Forms.ToolStripMenuItem tsmSeleccionarTodo;
        private System.Windows.Forms.ToolStripMenuItem tsmAjusteDeLinea;
        private System.Windows.Forms.ToolStripMenuItem tsmFuente;
        private System.Windows.Forms.ToolStripMenuItem ayudaToolStripMenuItem1;
        private System.Windows.Forms.ToolStripMenuItem tsmAcercaDe;
    }
}

