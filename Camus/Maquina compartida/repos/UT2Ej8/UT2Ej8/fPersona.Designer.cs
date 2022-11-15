namespace UT2Ej8
{
    partial class fPersona
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
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.txtNombre = new System.Windows.Forms.TextBox();
            this.txtTelefono = new System.Windows.Forms.TextBox();
            this.btnGuardar = new System.Windows.Forms.Button();
            this.btnSalir = new System.Windows.Forms.Button();
            this.tcPestanas = new System.Windows.Forms.TabControl();
            this.tpCitas = new System.Windows.Forms.TabPage();
            this.tpInformes = new System.Windows.Forms.TabPage();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.txtAlergias = new System.Windows.Forms.TextBox();
            this.dtpFecha = new System.Windows.Forms.DateTimePicker();
            this.txtObservaciones = new System.Windows.Forms.TextBox();
            this.splitContainer1 = new System.Windows.Forms.SplitContainer();
            this.btnNuevaCita = new System.Windows.Forms.Button();
            this.lvCitas = new System.Windows.Forms.ListView();
            this.clFecha = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.tcPestanas.SuspendLayout();
            this.tpCitas.SuspendLayout();
            this.tpInformes.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer1)).BeginInit();
            this.splitContainer1.Panel1.SuspendLayout();
            this.splitContainer1.Panel2.SuspendLayout();
            this.splitContainer1.SuspendLayout();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 16);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(44, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Nombre";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(13, 46);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(49, 13);
            this.label2.TabIndex = 1;
            this.label2.Text = "Telefono";
            // 
            // txtNombre
            // 
            this.txtNombre.Location = new System.Drawing.Point(72, 13);
            this.txtNombre.Name = "txtNombre";
            this.txtNombre.Size = new System.Drawing.Size(296, 20);
            this.txtNombre.TabIndex = 2;
            // 
            // txtTelefono
            // 
            this.txtTelefono.Location = new System.Drawing.Point(72, 43);
            this.txtTelefono.Name = "txtTelefono";
            this.txtTelefono.Size = new System.Drawing.Size(129, 20);
            this.txtTelefono.TabIndex = 3;
            // 
            // btnGuardar
            // 
            this.btnGuardar.Location = new System.Drawing.Point(393, 13);
            this.btnGuardar.Name = "btnGuardar";
            this.btnGuardar.Size = new System.Drawing.Size(75, 23);
            this.btnGuardar.TabIndex = 4;
            this.btnGuardar.Text = "Guardar";
            this.btnGuardar.UseVisualStyleBackColor = true;
            // 
            // btnSalir
            // 
            this.btnSalir.Location = new System.Drawing.Point(475, 13);
            this.btnSalir.Name = "btnSalir";
            this.btnSalir.Size = new System.Drawing.Size(75, 23);
            this.btnSalir.TabIndex = 5;
            this.btnSalir.Text = "Salir";
            this.btnSalir.UseVisualStyleBackColor = true;
            // 
            // tcPestanas
            // 
            this.tcPestanas.Controls.Add(this.tpCitas);
            this.tcPestanas.Controls.Add(this.tpInformes);
            this.tcPestanas.Location = new System.Drawing.Point(12, 69);
            this.tcPestanas.Name = "tcPestanas";
            this.tcPestanas.SelectedIndex = 0;
            this.tcPestanas.Size = new System.Drawing.Size(536, 350);
            this.tcPestanas.TabIndex = 6;
            // 
            // tpCitas
            // 
            this.tpCitas.Controls.Add(this.splitContainer1);
            this.tpCitas.Location = new System.Drawing.Point(4, 22);
            this.tpCitas.Name = "tpCitas";
            this.tpCitas.Padding = new System.Windows.Forms.Padding(3);
            this.tpCitas.Size = new System.Drawing.Size(528, 324);
            this.tpCitas.TabIndex = 0;
            this.tpCitas.Text = "Citas";
            this.tpCitas.UseVisualStyleBackColor = true;
            // 
            // tpInformes
            // 
            this.tpInformes.Controls.Add(this.txtObservaciones);
            this.tpInformes.Controls.Add(this.dtpFecha);
            this.tpInformes.Controls.Add(this.txtAlergias);
            this.tpInformes.Controls.Add(this.label5);
            this.tpInformes.Controls.Add(this.label4);
            this.tpInformes.Controls.Add(this.label3);
            this.tpInformes.Location = new System.Drawing.Point(4, 22);
            this.tpInformes.Name = "tpInformes";
            this.tpInformes.Padding = new System.Windows.Forms.Padding(3);
            this.tpInformes.Size = new System.Drawing.Size(528, 324);
            this.tpInformes.TabIndex = 1;
            this.tpInformes.Text = "Informes";
            this.tpInformes.UseVisualStyleBackColor = true;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(31, 20);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(93, 13);
            this.label3.TabIndex = 0;
            this.label3.Text = "Fecha Nacimiento";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(31, 49);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(44, 13);
            this.label4.TabIndex = 1;
            this.label4.Text = "Alergias";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(31, 95);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(78, 13);
            this.label5.TabIndex = 2;
            this.label5.Text = "Observaciones";
            // 
            // txtAlergias
            // 
            this.txtAlergias.Location = new System.Drawing.Point(142, 46);
            this.txtAlergias.Name = "txtAlergias";
            this.txtAlergias.Size = new System.Drawing.Size(310, 20);
            this.txtAlergias.TabIndex = 4;
            // 
            // dtpFecha
            // 
            this.dtpFecha.Format = System.Windows.Forms.DateTimePickerFormat.Short;
            this.dtpFecha.Location = new System.Drawing.Point(142, 14);
            this.dtpFecha.Name = "dtpFecha";
            this.dtpFecha.Size = new System.Drawing.Size(100, 20);
            this.dtpFecha.TabIndex = 5;
            // 
            // txtObservaciones
            // 
            this.txtObservaciones.Location = new System.Drawing.Point(34, 123);
            this.txtObservaciones.Multiline = true;
            this.txtObservaciones.Name = "txtObservaciones";
            this.txtObservaciones.Size = new System.Drawing.Size(461, 195);
            this.txtObservaciones.TabIndex = 6;
            // 
            // splitContainer1
            // 
            this.splitContainer1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.splitContainer1.Location = new System.Drawing.Point(3, 3);
            this.splitContainer1.Name = "splitContainer1";
            this.splitContainer1.Orientation = System.Windows.Forms.Orientation.Horizontal;
            // 
            // splitContainer1.Panel1
            // 
            this.splitContainer1.Panel1.Controls.Add(this.btnNuevaCita);
            // 
            // splitContainer1.Panel2
            // 
            this.splitContainer1.Panel2.Controls.Add(this.lvCitas);
            this.splitContainer1.Size = new System.Drawing.Size(522, 318);
            this.splitContainer1.SplitterDistance = 36;
            this.splitContainer1.TabIndex = 0;
            // 
            // btnNuevaCita
            // 
            this.btnNuevaCita.Location = new System.Drawing.Point(401, 3);
            this.btnNuevaCita.Name = "btnNuevaCita";
            this.btnNuevaCita.Size = new System.Drawing.Size(118, 30);
            this.btnNuevaCita.TabIndex = 0;
            this.btnNuevaCita.Text = "Nueva cita";
            this.btnNuevaCita.UseVisualStyleBackColor = true;
            // 
            // lvCitas
            // 
            this.lvCitas.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.clFecha});
            this.lvCitas.Dock = System.Windows.Forms.DockStyle.Fill;
            this.lvCitas.GridLines = true;
            this.lvCitas.HideSelection = false;
            this.lvCitas.Location = new System.Drawing.Point(0, 0);
            this.lvCitas.MultiSelect = false;
            this.lvCitas.Name = "lvCitas";
            this.lvCitas.Size = new System.Drawing.Size(522, 278);
            this.lvCitas.TabIndex = 0;
            this.lvCitas.UseCompatibleStateImageBehavior = false;
            this.lvCitas.View = System.Windows.Forms.View.Details;
            // 
            // clFecha
            // 
            this.clFecha.Text = "Fecha";
            this.clFecha.Width = 304;
            // 
            // fPersona
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(560, 431);
            this.Controls.Add(this.tcPestanas);
            this.Controls.Add(this.btnSalir);
            this.Controls.Add(this.btnGuardar);
            this.Controls.Add(this.txtTelefono);
            this.Controls.Add(this.txtNombre);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Name = "fPersona";
            this.Text = "Persona";
            this.tcPestanas.ResumeLayout(false);
            this.tpCitas.ResumeLayout(false);
            this.tpInformes.ResumeLayout(false);
            this.tpInformes.PerformLayout();
            this.splitContainer1.Panel1.ResumeLayout(false);
            this.splitContainer1.Panel2.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer1)).EndInit();
            this.splitContainer1.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txtNombre;
        private System.Windows.Forms.TextBox txtTelefono;
        private System.Windows.Forms.Button btnGuardar;
        private System.Windows.Forms.Button btnSalir;
        private System.Windows.Forms.TabControl tcPestanas;
        private System.Windows.Forms.TabPage tpCitas;
        private System.Windows.Forms.TabPage tpInformes;
        private System.Windows.Forms.TextBox txtObservaciones;
        private System.Windows.Forms.DateTimePicker dtpFecha;
        private System.Windows.Forms.TextBox txtAlergias;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.SplitContainer splitContainer1;
        private System.Windows.Forms.Button btnNuevaCita;
        private System.Windows.Forms.ListView lvCitas;
        private System.Windows.Forms.ColumnHeader clFecha;
    }
}