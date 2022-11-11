namespace HolaMundo
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
            this.btnNoFiesta = new System.Windows.Forms.Button();
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            this.btnFiesta = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // btnNoFiesta
            // 
            this.btnNoFiesta.Location = new System.Drawing.Point(318, 59);
            this.btnNoFiesta.Name = "btnNoFiesta";
            this.btnNoFiesta.Size = new System.Drawing.Size(75, 23);
            this.btnNoFiesta.TabIndex = 3;
            this.btnNoFiesta.Text = "No fiesta";
            this.btnNoFiesta.UseVisualStyleBackColor = true;
            this.btnNoFiesta.Click += new System.EventHandler(this.btnNoFiesta_Click);
            // 
            // timer1
            // 
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // btnFiesta
            // 
            this.btnFiesta.Location = new System.Drawing.Point(13, 59);
            this.btnFiesta.Name = "btnFiesta";
            this.btnFiesta.Size = new System.Drawing.Size(75, 23);
            this.btnFiesta.TabIndex = 4;
            this.btnFiesta.Text = "Fiesta";
            this.btnFiesta.UseVisualStyleBackColor = true;
            this.btnFiesta.Click += new System.EventHandler(this.btnFiesta_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.Control;
            this.ClientSize = new System.Drawing.Size(405, 148);
            this.Controls.Add(this.btnFiesta);
            this.Controls.Add(this.btnNoFiesta);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Name = "Form1";
            this.Text = "Hola buenas tardes";
            this.ResumeLayout(false);

        }

        #endregion
        private System.Windows.Forms.Button btnNoFiesta;
        private System.Windows.Forms.Timer timer1;
        private System.Windows.Forms.Button btnFiesta;
    }
}

