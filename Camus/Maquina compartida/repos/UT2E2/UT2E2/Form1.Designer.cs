namespace UT2E2
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
            this.label1 = new System.Windows.Forms.Label();
            this.txtNombre = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.dtpNacimiento = new System.Windows.Forms.DateTimePicker();
            this.label3 = new System.Windows.Forms.Label();
            this.rbHombre = new System.Windows.Forms.RadioButton();
            this.rbMujer = new System.Windows.Forms.RadioButton();
            this.rbNB = new System.Windows.Forms.RadioButton();
            this.gBox = new System.Windows.Forms.GroupBox();
            this.ckDeportes = new System.Windows.Forms.CheckBox();
            this.ckMusica = new System.Windows.Forms.CheckBox();
            this.ckLectura = new System.Windows.Forms.CheckBox();
            this.ckOtras = new System.Windows.Forms.CheckBox();
            this.txtAficiones = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.cbSituacion = new System.Windows.Forms.ComboBox();
            this.btnAceptar = new System.Windows.Forms.Button();
            this.btnReiniciar = new System.Windows.Forms.Button();
            this.gBox.SuspendLayout();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(13, 13);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(44, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Nombre";
            // 
            // txtNombre
            // 
            this.txtNombre.Location = new System.Drawing.Point(64, 13);
            this.txtNombre.Name = "txtNombre";
            this.txtNombre.Size = new System.Drawing.Size(238, 20);
            this.txtNombre.TabIndex = 1;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(12, 41);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(60, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "Nacimiento";
            // 
            // dtpNacimiento
            // 
            this.dtpNacimiento.Format = System.Windows.Forms.DateTimePickerFormat.Short;
            this.dtpNacimiento.Location = new System.Drawing.Point(78, 41);
            this.dtpNacimiento.MaxDate = new System.DateTime(2022, 10, 7, 0, 0, 0, 0);
            this.dtpNacimiento.MinDate = new System.DateTime(1900, 1, 1, 0, 0, 0, 0);
            this.dtpNacimiento.Name = "dtpNacimiento";
            this.dtpNacimiento.Size = new System.Drawing.Size(148, 20);
            this.dtpNacimiento.TabIndex = 4;
            this.dtpNacimiento.Value = new System.DateTime(2022, 10, 7, 0, 0, 0, 0);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(13, 76);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(42, 13);
            this.label3.TabIndex = 5;
            this.label3.Text = "Genero";
            // 
            // rbHombre
            // 
            this.rbHombre.AutoSize = true;
            this.rbHombre.Checked = true;
            this.rbHombre.Location = new System.Drawing.Point(62, 76);
            this.rbHombre.Name = "rbHombre";
            this.rbHombre.Size = new System.Drawing.Size(62, 17);
            this.rbHombre.TabIndex = 6;
            this.rbHombre.TabStop = true;
            this.rbHombre.Text = "Hombre";
            this.rbHombre.UseVisualStyleBackColor = true;
            // 
            // rbMujer
            // 
            this.rbMujer.AutoSize = true;
            this.rbMujer.Location = new System.Drawing.Point(129, 76);
            this.rbMujer.Name = "rbMujer";
            this.rbMujer.Size = new System.Drawing.Size(51, 17);
            this.rbMujer.TabIndex = 7;
            this.rbMujer.Text = "Mujer";
            this.rbMujer.UseVisualStyleBackColor = true;
            // 
            // rbNB
            // 
            this.rbNB.AutoSize = true;
            this.rbNB.Location = new System.Drawing.Point(187, 76);
            this.rbNB.Name = "rbNB";
            this.rbNB.Size = new System.Drawing.Size(73, 17);
            this.rbNB.TabIndex = 8;
            this.rbNB.Text = "No binario";
            this.rbNB.UseVisualStyleBackColor = true;
            // 
            // gBox
            // 
            this.gBox.Controls.Add(this.txtAficiones);
            this.gBox.Controls.Add(this.ckOtras);
            this.gBox.Controls.Add(this.ckLectura);
            this.gBox.Controls.Add(this.ckMusica);
            this.gBox.Controls.Add(this.ckDeportes);
            this.gBox.Location = new System.Drawing.Point(16, 93);
            this.gBox.Name = "gBox";
            this.gBox.Size = new System.Drawing.Size(281, 141);
            this.gBox.TabIndex = 9;
            this.gBox.TabStop = false;
            this.gBox.Text = "Aficiones";
            // 
            // ckDeportes
            // 
            this.ckDeportes.AutoSize = true;
            this.ckDeportes.Location = new System.Drawing.Point(7, 20);
            this.ckDeportes.Name = "ckDeportes";
            this.ckDeportes.Size = new System.Drawing.Size(69, 17);
            this.ckDeportes.TabIndex = 0;
            this.ckDeportes.Text = "Deportes";
            this.ckDeportes.UseVisualStyleBackColor = true;
            // 
            // ckMusica
            // 
            this.ckMusica.AutoSize = true;
            this.ckMusica.Location = new System.Drawing.Point(83, 20);
            this.ckMusica.Name = "ckMusica";
            this.ckMusica.Size = new System.Drawing.Size(60, 17);
            this.ckMusica.TabIndex = 1;
            this.ckMusica.Text = "Musica";
            this.ckMusica.UseVisualStyleBackColor = true;
            // 
            // ckLectura
            // 
            this.ckLectura.AutoSize = true;
            this.ckLectura.Location = new System.Drawing.Point(149, 20);
            this.ckLectura.Name = "ckLectura";
            this.ckLectura.Size = new System.Drawing.Size(62, 17);
            this.ckLectura.TabIndex = 2;
            this.ckLectura.Text = "Lectura";
            this.ckLectura.UseVisualStyleBackColor = true;
            // 
            // ckOtras
            // 
            this.ckOtras.AutoSize = true;
            this.ckOtras.Location = new System.Drawing.Point(218, 20);
            this.ckOtras.Name = "ckOtras";
            this.ckOtras.Size = new System.Drawing.Size(51, 17);
            this.ckOtras.TabIndex = 3;
            this.ckOtras.Text = "Otras";
            this.ckOtras.UseVisualStyleBackColor = true;
            this.ckOtras.CheckedChanged += new System.EventHandler(this.ckOtras_CheckedChanged);
            // 
            // txtAficiones
            // 
            this.txtAficiones.Enabled = false;
            this.txtAficiones.Location = new System.Drawing.Point(7, 44);
            this.txtAficiones.Multiline = true;
            this.txtAficiones.Name = "txtAficiones";
            this.txtAficiones.Size = new System.Drawing.Size(262, 91);
            this.txtAficiones.TabIndex = 4;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(24, 244);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(51, 13);
            this.label4.TabIndex = 10;
            this.label4.Text = "Situación";
            // 
            // cbSituacion
            // 
            this.cbSituacion.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbSituacion.FormattingEnabled = true;
            this.cbSituacion.Items.AddRange(new object[] {
            "Becario",
            "Empleado",
            "Excedencia",
            "Jubilado"});
            this.cbSituacion.Location = new System.Drawing.Point(81, 241);
            this.cbSituacion.Name = "cbSituacion";
            this.cbSituacion.Size = new System.Drawing.Size(204, 21);
            this.cbSituacion.TabIndex = 11;
            this.cbSituacion.SelectedIndexChanged += new System.EventHandler(this.cbSituacion_SelectedIndexChanged);
            // 
            // btnAceptar
            // 
            this.btnAceptar.Location = new System.Drawing.Point(209, 269);
            this.btnAceptar.Name = "btnAceptar";
            this.btnAceptar.Size = new System.Drawing.Size(75, 23);
            this.btnAceptar.TabIndex = 12;
            this.btnAceptar.Text = "Aceptar";
            this.btnAceptar.UseVisualStyleBackColor = true;
            // 
            // btnReiniciar
            // 
            this.btnReiniciar.Location = new System.Drawing.Point(128, 268);
            this.btnReiniciar.Name = "btnReiniciar";
            this.btnReiniciar.Size = new System.Drawing.Size(75, 23);
            this.btnReiniciar.TabIndex = 13;
            this.btnReiniciar.Text = "Reiniciar";
            this.btnReiniciar.UseVisualStyleBackColor = true;
            this.btnReiniciar.Click += new System.EventHandler(this.btnReiniciar_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(309, 299);
            this.Controls.Add(this.btnReiniciar);
            this.Controls.Add(this.btnAceptar);
            this.Controls.Add(this.cbSituacion);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.gBox);
            this.Controls.Add(this.rbNB);
            this.Controls.Add(this.rbMujer);
            this.Controls.Add(this.rbHombre);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.dtpNacimiento);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.txtNombre);
            this.Controls.Add(this.label1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.Name = "Form1";
            this.Text = "Form1";
            this.gBox.ResumeLayout(false);
            this.gBox.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtNombre;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.DateTimePicker dtpNacimiento;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.RadioButton rbHombre;
        private System.Windows.Forms.RadioButton rbMujer;
        private System.Windows.Forms.RadioButton rbNB;
        private System.Windows.Forms.GroupBox gBox;
        private System.Windows.Forms.TextBox txtAficiones;
        private System.Windows.Forms.CheckBox ckOtras;
        private System.Windows.Forms.CheckBox ckLectura;
        private System.Windows.Forms.CheckBox ckMusica;
        private System.Windows.Forms.CheckBox ckDeportes;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.ComboBox cbSituacion;
        private System.Windows.Forms.Button btnAceptar;
        private System.Windows.Forms.Button btnReiniciar;
    }
}

