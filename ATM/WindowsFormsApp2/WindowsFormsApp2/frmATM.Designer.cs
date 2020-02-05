namespace WindowsFormsApp2
{
    partial class frmATM
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(frmATM));
            this.btnOne = new System.Windows.Forms.Button();
            this.btnTwo = new System.Windows.Forms.Button();
            this.btnThree = new System.Windows.Forms.Button();
            this.btnFour = new System.Windows.Forms.Button();
            this.btnFive = new System.Windows.Forms.Button();
            this.btnSix = new System.Windows.Forms.Button();
            this.btnSeven = new System.Windows.Forms.Button();
            this.btnEight = new System.Windows.Forms.Button();
            this.btnNine = new System.Windows.Forms.Button();
            this.btnZero = new System.Windows.Forms.Button();
            this.btnEnter = new System.Windows.Forms.Button();
            this.btnClear = new System.Windows.Forms.Button();
            this.tboxDisplay = new System.Windows.Forms.TextBox();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.tboxInstructions = new System.Windows.Forms.TextBox();
            this.txtWith = new System.Windows.Forms.TextBox();
            this.txtBal = new System.Windows.Forms.TextBox();
            this.txtExit = new System.Windows.Forms.TextBox();
            this.btnWith = new System.Windows.Forms.Button();
            this.btnBal = new System.Windows.Forms.Button();
            this.btnExit = new System.Windows.Forms.Button();
            this.tmrDelay = new System.Windows.Forms.Timer(this.components);
            this.txt10 = new System.Windows.Forms.TextBox();
            this.txt50 = new System.Windows.Forms.TextBox();
            this.txt500 = new System.Windows.Forms.TextBox();
            this.btn10 = new System.Windows.Forms.Button();
            this.btn50 = new System.Windows.Forms.Button();
            this.btn500 = new System.Windows.Forms.Button();
            this.tmrBalDelay = new System.Windows.Forms.Timer(this.components);
            this.tmr_test = new System.Windows.Forms.Timer(this.components);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // btnOne
            // 
            this.btnOne.Location = new System.Drawing.Point(66, 298);
            this.btnOne.Name = "btnOne";
            this.btnOne.Size = new System.Drawing.Size(40, 40);
            this.btnOne.TabIndex = 0;
            this.btnOne.Text = "1";
            this.btnOne.UseVisualStyleBackColor = true;
            this.btnOne.Click += new System.EventHandler(this.btnOne_Click);
            // 
            // btnTwo
            // 
            this.btnTwo.Location = new System.Drawing.Point(116, 298);
            this.btnTwo.Name = "btnTwo";
            this.btnTwo.Size = new System.Drawing.Size(40, 40);
            this.btnTwo.TabIndex = 1;
            this.btnTwo.Text = "2";
            this.btnTwo.UseVisualStyleBackColor = true;
            this.btnTwo.Click += new System.EventHandler(this.btnTwo_Click);
            // 
            // btnThree
            // 
            this.btnThree.Location = new System.Drawing.Point(166, 298);
            this.btnThree.Name = "btnThree";
            this.btnThree.Size = new System.Drawing.Size(40, 40);
            this.btnThree.TabIndex = 2;
            this.btnThree.Text = "3";
            this.btnThree.UseVisualStyleBackColor = true;
            this.btnThree.Click += new System.EventHandler(this.btnThree_Click);
            // 
            // btnFour
            // 
            this.btnFour.Location = new System.Drawing.Point(66, 348);
            this.btnFour.Name = "btnFour";
            this.btnFour.Size = new System.Drawing.Size(40, 40);
            this.btnFour.TabIndex = 3;
            this.btnFour.Text = "4";
            this.btnFour.UseVisualStyleBackColor = true;
            this.btnFour.Click += new System.EventHandler(this.btnFour_Click);
            // 
            // btnFive
            // 
            this.btnFive.Location = new System.Drawing.Point(116, 348);
            this.btnFive.Name = "btnFive";
            this.btnFive.Size = new System.Drawing.Size(40, 40);
            this.btnFive.TabIndex = 4;
            this.btnFive.Text = "5";
            this.btnFive.UseVisualStyleBackColor = true;
            this.btnFive.Click += new System.EventHandler(this.btnFive_Click);
            // 
            // btnSix
            // 
            this.btnSix.Location = new System.Drawing.Point(166, 348);
            this.btnSix.Name = "btnSix";
            this.btnSix.Size = new System.Drawing.Size(40, 40);
            this.btnSix.TabIndex = 5;
            this.btnSix.Text = "6";
            this.btnSix.UseVisualStyleBackColor = true;
            this.btnSix.Click += new System.EventHandler(this.btnSix_Click);
            // 
            // btnSeven
            // 
            this.btnSeven.Location = new System.Drawing.Point(66, 398);
            this.btnSeven.Name = "btnSeven";
            this.btnSeven.Size = new System.Drawing.Size(40, 40);
            this.btnSeven.TabIndex = 6;
            this.btnSeven.Text = "7";
            this.btnSeven.UseVisualStyleBackColor = true;
            this.btnSeven.Click += new System.EventHandler(this.btnSeven_Click);
            // 
            // btnEight
            // 
            this.btnEight.Location = new System.Drawing.Point(116, 398);
            this.btnEight.Name = "btnEight";
            this.btnEight.Size = new System.Drawing.Size(40, 40);
            this.btnEight.TabIndex = 7;
            this.btnEight.Text = "8";
            this.btnEight.UseVisualStyleBackColor = true;
            this.btnEight.Click += new System.EventHandler(this.btnEight_Click);
            // 
            // btnNine
            // 
            this.btnNine.Location = new System.Drawing.Point(166, 398);
            this.btnNine.Name = "btnNine";
            this.btnNine.Size = new System.Drawing.Size(40, 40);
            this.btnNine.TabIndex = 8;
            this.btnNine.Text = "9";
            this.btnNine.UseVisualStyleBackColor = true;
            this.btnNine.Click += new System.EventHandler(this.btnNine_Click);
            // 
            // btnZero
            // 
            this.btnZero.Location = new System.Drawing.Point(65, 448);
            this.btnZero.Name = "btnZero";
            this.btnZero.Size = new System.Drawing.Size(40, 40);
            this.btnZero.TabIndex = 9;
            this.btnZero.Text = "0";
            this.btnZero.UseVisualStyleBackColor = true;
            this.btnZero.Click += new System.EventHandler(this.btnZero_Click);
            // 
            // btnEnter
            // 
            this.btnEnter.Location = new System.Drawing.Point(115, 448);
            this.btnEnter.Name = "btnEnter";
            this.btnEnter.Size = new System.Drawing.Size(40, 40);
            this.btnEnter.TabIndex = 10;
            this.btnEnter.Text = "Enter";
            this.btnEnter.UseVisualStyleBackColor = true;
            this.btnEnter.Click += new System.EventHandler(this.btnEnter_Click);
            // 
            // btnClear
            // 
            this.btnClear.Location = new System.Drawing.Point(166, 448);
            this.btnClear.Name = "btnClear";
            this.btnClear.Size = new System.Drawing.Size(40, 40);
            this.btnClear.TabIndex = 11;
            this.btnClear.Text = "Clear";
            this.btnClear.UseVisualStyleBackColor = true;
            this.btnClear.Click += new System.EventHandler(this.btnClear_Click);
            // 
            // tboxDisplay
            // 
            this.tboxDisplay.Enabled = false;
            this.tboxDisplay.Font = new System.Drawing.Font("Berlin Sans FB", 24F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tboxDisplay.Location = new System.Drawing.Point(66, 193);
            this.tboxDisplay.Multiline = true;
            this.tboxDisplay.Name = "tboxDisplay";
            this.tboxDisplay.Size = new System.Drawing.Size(140, 33);
            this.tboxDisplay.TabIndex = 12;
            this.tboxDisplay.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            // 
            // pictureBox1
            // 
            this.pictureBox1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox1.BackgroundImage")));
            this.pictureBox1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.pictureBox1.Location = new System.Drawing.Point(0, -2);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(272, 253);
            this.pictureBox1.TabIndex = 13;
            this.pictureBox1.TabStop = false;
            this.pictureBox1.Click += new System.EventHandler(this.pictureBox1_Click);
            // 
            // tboxInstructions
            // 
            this.tboxInstructions.Location = new System.Drawing.Point(67, 37);
            this.tboxInstructions.Multiline = true;
            this.tboxInstructions.Name = "tboxInstructions";
            this.tboxInstructions.Size = new System.Drawing.Size(139, 35);
            this.tboxInstructions.TabIndex = 14;
            this.tboxInstructions.Text = "Please Enter Your Account Number";
            // 
            // txtWith
            // 
            this.txtWith.Location = new System.Drawing.Point(35, 94);
            this.txtWith.Name = "txtWith";
            this.txtWith.Size = new System.Drawing.Size(53, 20);
            this.txtWith.TabIndex = 15;
            this.txtWith.Text = "Withdraw";
            this.txtWith.Visible = false;
            // 
            // txtBal
            // 
            this.txtBal.Location = new System.Drawing.Point(35, 132);
            this.txtBal.Name = "txtBal";
            this.txtBal.Size = new System.Drawing.Size(53, 20);
            this.txtBal.TabIndex = 16;
            this.txtBal.Text = "Balance";
            this.txtBal.Visible = false;
            // 
            // txtExit
            // 
            this.txtExit.Location = new System.Drawing.Point(35, 167);
            this.txtExit.Name = "txtExit";
            this.txtExit.Size = new System.Drawing.Size(53, 20);
            this.txtExit.TabIndex = 17;
            this.txtExit.Text = "Exit";
            this.txtExit.Visible = false;
            // 
            // btnWith
            // 
            this.btnWith.Location = new System.Drawing.Point(12, 95);
            this.btnWith.Name = "btnWith";
            this.btnWith.Size = new System.Drawing.Size(15, 20);
            this.btnWith.TabIndex = 18;
            this.btnWith.Text = ">";
            this.btnWith.UseVisualStyleBackColor = true;
            this.btnWith.Click += new System.EventHandler(this.btnWith_Click);
            // 
            // btnBal
            // 
            this.btnBal.Location = new System.Drawing.Point(12, 132);
            this.btnBal.Name = "btnBal";
            this.btnBal.Size = new System.Drawing.Size(15, 20);
            this.btnBal.TabIndex = 19;
            this.btnBal.Text = ">";
            this.btnBal.UseVisualStyleBackColor = true;
            this.btnBal.Click += new System.EventHandler(this.btnBal_Click);
            // 
            // btnExit
            // 
            this.btnExit.Location = new System.Drawing.Point(12, 167);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(15, 20);
            this.btnExit.TabIndex = 20;
            this.btnExit.Text = ">";
            this.btnExit.UseVisualStyleBackColor = true;
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // tmrDelay
            // 
            this.tmrDelay.Interval = 1000;
            this.tmrDelay.Tick += new System.EventHandler(this.tmrDelay_Tick);
            // 
            // txt10
            // 
            this.txt10.Location = new System.Drawing.Point(184, 95);
            this.txt10.Name = "txt10";
            this.txt10.Size = new System.Drawing.Size(53, 20);
            this.txt10.TabIndex = 21;
            this.txt10.Text = "10";
            // 
            // txt50
            // 
            this.txt50.Location = new System.Drawing.Point(184, 133);
            this.txt50.Name = "txt50";
            this.txt50.Size = new System.Drawing.Size(53, 20);
            this.txt50.TabIndex = 22;
            this.txt50.Text = "50";
            // 
            // txt500
            // 
            this.txt500.Location = new System.Drawing.Point(184, 168);
            this.txt500.Name = "txt500";
            this.txt500.Size = new System.Drawing.Size(53, 20);
            this.txt500.TabIndex = 23;
            this.txt500.Text = "500";
            // 
            // btn10
            // 
            this.btn10.Location = new System.Drawing.Point(247, 95);
            this.btn10.Name = "btn10";
            this.btn10.Size = new System.Drawing.Size(15, 20);
            this.btn10.TabIndex = 24;
            this.btn10.Text = "<";
            this.btn10.UseVisualStyleBackColor = true;
            this.btn10.Click += new System.EventHandler(this.btn10_Click);
            // 
            // btn50
            // 
            this.btn50.Location = new System.Drawing.Point(247, 133);
            this.btn50.Name = "btn50";
            this.btn50.Size = new System.Drawing.Size(15, 20);
            this.btn50.TabIndex = 25;
            this.btn50.Text = "<";
            this.btn50.UseVisualStyleBackColor = true;
            this.btn50.Click += new System.EventHandler(this.btn50_Click);
            // 
            // btn500
            // 
            this.btn500.Location = new System.Drawing.Point(247, 168);
            this.btn500.Name = "btn500";
            this.btn500.Size = new System.Drawing.Size(15, 20);
            this.btn500.TabIndex = 26;
            this.btn500.Text = "<";
            this.btn500.UseVisualStyleBackColor = true;
            this.btn500.Click += new System.EventHandler(this.btn500_Click);
            // 
            // tmrBalDelay
            // 
            this.tmrBalDelay.Interval = 15000;
            this.tmrBalDelay.Tick += new System.EventHandler(this.tmrBalDelay_Tick);
            // 
            // tmr_test
            // 
            this.tmr_test.Interval = 6000;
            this.tmr_test.Tick += new System.EventHandler(this.tmr_test_Tick);
            // 
            // frmATM
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ActiveBorder;
            this.ClientSize = new System.Drawing.Size(268, 515);
            this.Controls.Add(this.btn500);
            this.Controls.Add(this.btn50);
            this.Controls.Add(this.btn10);
            this.Controls.Add(this.txt500);
            this.Controls.Add(this.txt50);
            this.Controls.Add(this.txt10);
            this.Controls.Add(this.btnExit);
            this.Controls.Add(this.btnBal);
            this.Controls.Add(this.btnWith);
            this.Controls.Add(this.txtExit);
            this.Controls.Add(this.txtBal);
            this.Controls.Add(this.txtWith);
            this.Controls.Add(this.tboxInstructions);
            this.Controls.Add(this.tboxDisplay);
            this.Controls.Add(this.btnClear);
            this.Controls.Add(this.btnEnter);
            this.Controls.Add(this.btnZero);
            this.Controls.Add(this.btnNine);
            this.Controls.Add(this.btnEight);
            this.Controls.Add(this.btnSeven);
            this.Controls.Add(this.btnSix);
            this.Controls.Add(this.btnFive);
            this.Controls.Add(this.btnFour);
            this.Controls.Add(this.btnThree);
            this.Controls.Add(this.btnTwo);
            this.Controls.Add(this.btnOne);
            this.Controls.Add(this.pictureBox1);
            this.Name = "frmATM";
            this.Text = "frmATM";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnOne;
        private System.Windows.Forms.Button btnTwo;
        private System.Windows.Forms.Button btnThree;
        private System.Windows.Forms.Button btnFour;
        private System.Windows.Forms.Button btnFive;
        private System.Windows.Forms.Button btnSix;
        private System.Windows.Forms.Button btnSeven;
        private System.Windows.Forms.Button btnEight;
        private System.Windows.Forms.Button btnNine;
        private System.Windows.Forms.Button btnZero;
        private System.Windows.Forms.Button btnEnter;
        private System.Windows.Forms.Button btnClear;
        private System.Windows.Forms.TextBox tboxDisplay;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.TextBox tboxInstructions;
        private System.Windows.Forms.TextBox txtWith;
        private System.Windows.Forms.TextBox txtBal;
        private System.Windows.Forms.TextBox txtExit;
        private System.Windows.Forms.Button btnWith;
        private System.Windows.Forms.Button btnBal;
        private System.Windows.Forms.Button btnExit;
        private System.Windows.Forms.Timer tmrDelay;
        private System.Windows.Forms.TextBox txt10;
        private System.Windows.Forms.TextBox txt50;
        private System.Windows.Forms.TextBox txt500;
        private System.Windows.Forms.Button btn10;
        private System.Windows.Forms.Button btn50;
        private System.Windows.Forms.Button btn500;
        private System.Windows.Forms.Timer tmrBalDelay;
        private System.Windows.Forms.Timer tmr_test;
    }
}

