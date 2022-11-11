namespace PruebaArbol
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
            this.scContenedor = new System.Windows.Forms.SplitContainer();
            this.tvArbol = new System.Windows.Forms.TreeView();
            this.txTexto = new System.Windows.Forms.TextBox();
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
            this.scContenedor.Orientation = System.Windows.Forms.Orientation.Horizontal;
            // 
            // scContenedor.Panel1
            // 
            this.scContenedor.Panel1.Controls.Add(this.tvArbol);
            // 
            // scContenedor.Panel2
            // 
            this.scContenedor.Panel2.Controls.Add(this.txTexto);
            this.scContenedor.Size = new System.Drawing.Size(800, 450);
            this.scContenedor.SplitterDistance = 266;
            this.scContenedor.TabIndex = 0;
            // 
            // tvArbol
            // 
            this.tvArbol.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tvArbol.Location = new System.Drawing.Point(0, 0);
            this.tvArbol.Name = "tvArbol";
            this.tvArbol.Size = new System.Drawing.Size(800, 266);
            this.tvArbol.TabIndex = 0;
            this.tvArbol.BeforeExpand += new System.Windows.Forms.TreeViewCancelEventHandler(this.tvArbol_BeforeExpand);
            this.tvArbol.AfterSelect += new System.Windows.Forms.TreeViewEventHandler(this.tvArbol_AfterSelect);
            // 
            // txTexto
            // 
            this.txTexto.Dock = System.Windows.Forms.DockStyle.Fill;
            this.txTexto.Location = new System.Drawing.Point(0, 0);
            this.txTexto.Multiline = true;
            this.txTexto.Name = "txTexto";
            this.txTexto.Size = new System.Drawing.Size(800, 180);
            this.txTexto.TabIndex = 0;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.scContenedor);
            this.Name = "Form1";
            this.Text = "Form1";
            this.scContenedor.Panel1.ResumeLayout(false);
            this.scContenedor.Panel2.ResumeLayout(false);
            this.scContenedor.Panel2.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.scContenedor)).EndInit();
            this.scContenedor.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.SplitContainer scContenedor;
        private System.Windows.Forms.TreeView tvArbol;
        private System.Windows.Forms.TextBox txTexto;
    }
}

