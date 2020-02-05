using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Threading;
using System.Drawing.Drawing2D;

namespace WindowsFormsApp2
{
    //Bank Form, Creates threads of frmATM and creates the array of accounts used by the ATM's
    public partial class frmBank : Form
    {
        // array of accounts used by the ATM's
        private Account[] ac = new Account[3];
        

        // Constructor for frmBank, instantiates 3 accounts within the Account array
        public frmBank()
        {
            InitializeComponent();
            ac[0] = new Account(300, 1111, 111111);
            ac[1] = new Account(750, 2222, 222222);
            ac[2] = new Account(3000, 3333, 333333);



        }

        private void frmBank_Load(object sender, EventArgs e)
        {
            

        }


        // Creates an atm object and passing in the Account array and a number representing what
        // version of atm code to run, then shows the form
        private void ThreadProc(int x) {
            frmATM atm = new frmATM(ac, x);
            atm.ShowDialog();


        }
        // Timer used to display all three accounts current balance on screen so
        // we can keep track of it
        private void tmr_status_Tick(object sender, EventArgs e)
        {
            // string function to string converts integer to string, so we can display it in the text box, same for all 3 boxes
            string x = ac[0].getBalance().ToString();
            txtAtm1.Text = x;
            string y = ac[1].getBalance().ToString();
            txtAtm2.Text = y;
            string z = ac[2].getBalance().ToString();
            txtAtm3.Text = z;
        }


        // creates 2 ATM threads  and sends in a '1', which tells them to create standard ATM's
        private void button2_Click(object sender, EventArgs e)
        {
            // creates a new Thread called ATM1 and calls Threadproc for the thread
            Thread ATM1 = new Thread(() => ThreadProc(1));
            ATM1.Start();
            Thread ATM2 = new Thread(() => ThreadProc(1));
            ATM2.Start();



        }


        // creates 2 ATM threads  and sends in a '2', which tells them to create ATM's with the data race problem
        private void button1_Click(object sender, EventArgs e)
        {
            // creates a new Thread called ATM1 and calls Threadproc for the thread
            Thread ATM1 = new Thread(() => ThreadProc(2));
            ATM1.Start();
            Thread ATM2 = new Thread(() => ThreadProc(2));
            ATM2.Start();
        }


        // creates 2 ATM threads  and sends in a '3', which tells them to create ATM's with the data race solution
        private void button3_Click(object sender, EventArgs e)
        {
            // creates a new Thread called ATM1 and calls Threadproc for the thread
            Thread ATM1 = new Thread(() => ThreadProc(3));
            ATM1.Start();
            Thread ATM2 = new Thread(() => ThreadProc(3));
            ATM2.Start();
            threadLocking(ATM1);
        }


        private void threadLocking(Thread ATM1) {


            // if transaction is happening
                lock(ATM1) {
                        //wait
                 }
            


        }
    }
}
