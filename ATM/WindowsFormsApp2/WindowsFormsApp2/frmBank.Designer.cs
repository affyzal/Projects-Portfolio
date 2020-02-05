namespace WindowsFormsApp2
{
    partial class frmBank
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
            this.button1 = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.button3 = new System.Windows.Forms.Button();
            this.txtAtm1 = new System.Windows.Forms.TextBox();
            this.txtAtm2 = new System.Windows.Forms.TextBox();
            this.tmr_status = new System.Windows.Forms.Timer(this.components);
            this.txtAtm3 = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(42, 82);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(124, 40);
            this.button1.TabIndex = 0;
            this.button1.Text = "Simulate Data Race Problem";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(44, 17);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(122, 37);
            this.button2.TabIndex = 1;
            this.button2.Text = "Simulate Standard ATM\'s";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // button3
            // 
            this.button3.Location = new System.Drawing.Point(42, 146);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(124, 39);
            this.button3.TabIndex = 2;
            this.button3.Text = "Simulate Data Race Solution";
            this.button3.UseVisualStyleBackColor = true;
            this.button3.Click += new System.EventHandler(this.button3_Click);
            // 
            // txtAtm1
            // 
            this.txtAtm1.Location = new System.Drawing.Point(401, 17);
            this.txtAtm1.Name = "txtAtm1";
            this.txtAtm1.Size = new System.Drawing.Size(125, 20);
            this.txtAtm1.TabIndex = 3;
            // 
            // txtAtm2
            // 
            this.txtAtm2.Location = new System.Drawing.Point(401, 57);
            this.txtAtm2.Name = "txtAtm2";
            this.txtAtm2.Size = new System.Drawing.Size(125, 20);
            this.txtAtm2.TabIndex = 4;
            // 
            // tmr_status
            // 
            this.tmr_status.Enabled = true;
            this.tmr_status.Interval = 10;
            this.tmr_status.Tick += new System.EventHandler(this.tmr_status_Tick);
            // 
            // txtAtm3
            // 
            this.txtAtm3.Location = new System.Drawing.Point(401, 93);
            this.txtAtm3.Name = "txtAtm3";
            this.txtAtm3.Size = new System.Drawing.Size(125, 20);
            this.txtAtm3.TabIndex = 5;
            // 
            // frmBank
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(583, 248);
            this.Controls.Add(this.txtAtm3);
            this.Controls.Add(this.txtAtm2);
            this.Controls.Add(this.txtAtm1);
            this.Controls.Add(this.button3);
            this.Controls.Add(this.button2);
            this.Controls.Add(this.button1);
            this.Name = "frmBank";
            this.Text = "frmBank";
            this.Load += new System.EventHandler(this.frmBank_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.TextBox txtAtm1;
        private System.Windows.Forms.TextBox txtAtm2;
        private System.Windows.Forms.Timer tmr_status;
        private System.Windows.Forms.TextBox txtAtm3;
    }
}