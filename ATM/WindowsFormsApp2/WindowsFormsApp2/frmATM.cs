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
    public partial class frmATM : Form
    {
        // account array to store any number of accounts for the atm system
        private Account[] ac;
        // boolean to check if account fully logged in
        private Boolean login;
        // boolean to check if an account number has been logged in
        private Boolean accountLog;
        // string to check the pin inputted by the user
        private string pinInput;
        // holds an active account once user has logged in
        private Account activeAccount = null;
        // boolean to run standard ATM's
        public bool standard = false;
        // boolean to run data race ATM's
        public bool race = false;
        // boolean to run solution to data race
        public bool sol = false;
        // integer to store the number passed in the constructor
        public int atmType = 0;
        // static boolean to check if a transaction is taking place
        public static bool tranValid = true;




        // constructor for frmATM, sets the account array inputted to the empty array in the program
        // sets the inputted number to the atmType variable, which allows the program to know what version
        // to run
        public frmATM(Account[] ac1, int x)
        {
            atmType = x;
            ac = ac1;
            InitializeComponent();

        }

        
        // When the form load, run the function atmMain
        private void Form1_Load(object sender, EventArgs e)
        {
            
            atmMain();
        }




        // call the initialse variables function and then loginDisplay, to display login GUI
        private void atmMain() {
            initialseVariables();
            loginDisplay();

        }



        // resets the form, then displays buttons relevant to logging in, and changes the text displayed
        private void loginDisplay() {
            resetForm();
            tboxInstructions.Text = "Please Enter Account Number";
            tboxDisplay.Visible = true;
            tboxInstructions.Visible = true;
        }


        // resets the form, then displays buttons relevant to the ATM menu, and changes the text displayed
        private void menuDisplay() {
            resetForm();
            tboxInstructions.Visible = true;
            txtBal.Visible = true;
            txtExit.Visible = true;
            txtWith.Visible = true;
            btnExit.Visible = true;
            btnWith.Visible = true;
            btnBal.Visible = true;
            tboxInstructions.Text = "Please Select One Of The Following Options";

        }

        // resets the form, then displays buttons relevant to withdrawling money
        private void withlDisplay() {
            resetForm();
            btn50.Visible = true;
            btn10.Visible = true;
            btn500.Visible = true;
            txt10.Visible = true;
            txt50.Visible = true;
            txt500.Visible = true;
            txtExit.Visible = true;
            btnExit.Visible = true;
            tboxInstructions.Visible = true;



        }

        // sets all GUI objects on form relevant to the atm screen as not visible
        private void resetForm() {
            tboxDisplay.Text = "";
            tboxInstructions.Text = "";
            tboxDisplay.Visible = false;
            tboxInstructions.Visible = false;
            txtBal.Visible = false;
            txtExit.Visible = false;
            txtWith.Visible = false;
            btn50.Visible = false;
            btn10.Visible = false;
            btn500.Visible = false;
            txt50.Visible = false;
            txt10.Visible = false;
            txt500.Visible = false;
            btnWith.Visible = false;
            btnBal.Visible = false;
            btnExit.Visible = false;


        }


        // initialsed varaibles used within the ATM
        private void initialseVariables() {
            pinInput = null;
            accountLog = false;
            login = false;
        }


        // function to search the account array for the account inputted by the user
        // then sets the active account to the account found
        private Account findAccount( )
        {
            // converts string to integer
            int x = Int32.Parse(tboxDisplay.Text);
            int input = x;


            // loops untill the account inputted matches an account in the array
            // then sets active account to that account
            for (int i = 0; i < this.ac.Length; i++)
            {
                // when accounthas been found, display ask for pin
                if (ac[i].getAccountNum() == input)
                {
                    tboxInstructions.Text = "Please Enter Pin Number";
                    accountLog = true;
                    tboxDisplay.Text = "";
                    return ac[i];
                }
            }
            return null;
        }



        // when clicked check if user is at account login, or pin
        // if at account login, call findaccount method with inputted account
        // if at pin login, send the inputted pin to checkpin
        private void btnEnter_Click(object sender, EventArgs e)
        {
            while (login == false)
            {

                if (accountLog == false)
                {
                    activeAccount = this.findAccount();
                    break;
                }

                int x = Int32.Parse(tboxDisplay.Text);
                if (activeAccount.checkPin(x) == true)
                {
                    login = true;
                    tboxInstructions.Text = "Welcome";
                    tmrDelay.Enabled = true;

                    
                    tboxDisplay.Visible = false;

                }
                else {
                    break;
                }
                
            }
            
        }


        // event handler to display 1 on tboxDisplay
        private void btnOne_Click(object sender, EventArgs e)
        {
            displayNumber(btnOne.Text);
        }

        // sets the inputted string to the tboxdisplay
        private void displayNumber(String input) {

            tboxDisplay.Text = tboxDisplay.Text + input;
        }

        // event handler to display 2 on tboxDisplay
        private void btnTwo_Click(object sender, EventArgs e)
        {
            displayNumber(btnTwo.Text);
        }

        // event handler to display 3 on tboxDisplay
        private void btnThree_Click(object sender, EventArgs e)
        {
            displayNumber(btnThree.Text);
        }

        // event handler to display 4 on tboxDisplay
        private void btnFour_Click(object sender, EventArgs e)
        {
            displayNumber(btnFour.Text);
        }

        // event handler to display 5 on tboxDisplay
        private void btnFive_Click(object sender, EventArgs e)
        {
            displayNumber(btnFive.Text);
        }

        // event handler to display 6 on tboxDisplay
        private void btnSix_Click(object sender, EventArgs e)
        {
            displayNumber(btnSix.Text);
        }

        // event handler to display 7 on tboxDisplay
        private void btnSeven_Click(object sender, EventArgs e)
        {
            displayNumber(btnSeven.Text);
        }

        // event handler to display 8 on tboxDisplay
        private void btnEight_Click(object sender, EventArgs e)
        {
            displayNumber(btnEight.Text);
        }

        // event handler to display 9 on tboxDisplay
        private void btnNine_Click(object sender, EventArgs e)
        {
            displayNumber(btnNine.Text);
        }

        // event handler to display 0 on tboxDisplay
        private void btnZero_Click(object sender, EventArgs e)
        {
            displayNumber(btnZero.Text);
        }

        // event handler to Clear tboxDisplay
        private void btnClear_Click(object sender, EventArgs e)
        {
            tboxDisplay.Text = "";
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

        // delay for 5 seconds and then disable itself
        private void tmrDelay_Tick(object sender, EventArgs e)
        {

            menuDisplay();
            tmrDelay.Enabled = false;
   
        }

        // calls withlDisplay, display withdrawl GUI
        private void btnWith_Click(object sender, EventArgs e)
        {
            withlDisplay();
        }

        // if currently on withdrawl GUI, return to menu
        // if on menu, log user out and return to login GUI
        private void btnExit_Click(object sender, EventArgs e)
        {
            if (btn50.Visible == true || tboxInstructions.Text == "Balance Below")
            {
                menuDisplay();
            }
            else
            {
                
                loginDisplay();
                login = false;
                accountLog = false;
            }

        }


        // gets the active account balance and displays it on the form
        private void btnBal_Click(object sender, EventArgs e)
        {
    
            int x = activeAccount.getBalance();
            string y = x.ToString();
            tboxInstructions.Text = "Current Balance = £" + y;
        }



        // checks if the current accounts balance can afford the money getting taken out
        // if it cant, return false, if it can, retur true
        private bool balValid(int x) {

            if (activeAccount.getBalance() < x) {
                return false;
            }
            else { 

            return true;

                }

        }


        // button for withdrawing £10
        private void btn10_Click(object sender, EventArgs e)
        {

            // first checks if user can take out money
            if (balValid(10) == true)
            {

                // if atm type is 1, run the standard withdrawl code
                // sets up GUI, then takes out 10 from the active account
                if (atmType == 1)
                {
                    displayNewBal();
                    activeAccount.setBalance(activeAccount.getBalance() - 10);

                }
                // if atm is type 2, run data race code
                // first gets the balance then delays for 5 seconds, this allows user to press other button to withdrawl on other form
                // simulates 2 at the same time as both atm's asked for the balance so they both have an unmodified balance
                else if (atmType == 2)
                {
                    displayNewBal();
                    int z = activeAccount.getBalance();
                    int pauseTime = 5000;
                    System.Threading.Thread.Sleep(pauseTime);
                    activeAccount.setBalance(z - 10);


                }

                // if atm is type 2, run solution code
                // before the type 2 code is run, check if another atm is withdrawling
                //if it is, then stall withdrawl untill the other atm is done
                // then set tranvalid back to true
                else if (atmType == 3)
                {
                    displayNewBal();

                    while (tranValid == false)
                    {
                        int count = activeAccount.getBalance();
                        int pauseTime2 = 5000;
                        System.Threading.Thread.Sleep(pauseTime2);
                        activeAccount.setBalance(count - 10);
                    }




                    tranValid = false;
                    int z = activeAccount.getBalance();
                    int pauseTime = 5000;
                    System.Threading.Thread.Sleep(pauseTime);
                    activeAccount.setBalance(z - 10);
                    tranValid = true;
                }
                int x = activeAccount.getBalance();
                string y = x.ToString();
                tboxInstructions.Text = "New Balance = £" + y;
            }
            // if cannot withdrwal due to not enough money, then display to user
            else
            {
                tboxInstructions.Text = "Insufficent Funds";
            }
        }

        // button for withdrawing £10
        private void btn50_Click(object sender, EventArgs e)
        {
            // first checks if user can take out money
            if (balValid(50) == true)
            {

                // if atm type is 1, run the standard withdrawl code
                // sets up GUI, then takes out 50 from the active account
                if (atmType == 1)
                {
                    displayNewBal();
                    activeAccount.setBalance(activeAccount.getBalance() - 50);

                }
                // if atm is type 2, run data race code
                // first gets the balance then delays for 5 seconds, this allows user to press other button to withdrawl on other form
                // simulates 2 at the same time as both atm's asked for the balance so they both have an unmodified balance
                else if (atmType == 2)
                {
                    displayNewBal();
                    int z = activeAccount.getBalance();
                    int pauseTime = 5000;
                    System.Threading.Thread.Sleep(pauseTime);
                    activeAccount.setBalance(z - 50);


                }

                // if atm is type 2, run solution code
                // before the type 2 code is run, check if another atm is withdrawling
                //if it is, then stall withdrawl untill the other atm is done
                // then set tranvalid back to true
                else if (atmType == 3)
                {
                    displayNewBal();

                    while (tranValid == false)
                    {
                        int count = activeAccount.getBalance();
                        int pauseTime2 = 5000;
                        System.Threading.Thread.Sleep(pauseTime2);
                        activeAccount.setBalance(count - 50);
                    }




                    tranValid = false;
                    int z = activeAccount.getBalance();
                    int pauseTime = 5000;
                    System.Threading.Thread.Sleep(pauseTime);
                    activeAccount.setBalance(z - 50);
                    tranValid = true;
                }
                int x = activeAccount.getBalance();
                string y = x.ToString();
                tboxInstructions.Text = "New Balance = £" + y;
            }
            // if cannot withdrwal due to not enough money, then display to user
            else
            {
                tboxInstructions.Text = "Insufficent Funds";
            }
        }

        private void btn500_Click(object sender, EventArgs e)
        {
            // first checks if user can take out money
            if (balValid(10) == true)
            {

                // if atm type is 1, run the standard withdrawl code
                // sets up GUI, then takes out 500 from the active account
                if (atmType == 1)
                {
                    displayNewBal();
                    activeAccount.setBalance(activeAccount.getBalance() - 500);

                }
                // if atm is type 2, run data race code
                // first gets the balance then delays for 5 seconds, this allows user to press other button to withdrawl on other form
                // simulates 2 at the same time as both atm's asked for the balance so they both have an unmodified balance
                else if (atmType == 2)
                {
                    displayNewBal();
                    int z = activeAccount.getBalance();
                    int pauseTime = 5000;
                    System.Threading.Thread.Sleep(pauseTime);
                    activeAccount.setBalance(z - 500);


                }

                // if atm is type 2, run solution code
                // before the type 2 code is run, check if another atm is withdrawling
                //if it is, then stall withdrawl untill the other atm is done
                // then set tranvalid back to true
                else if (atmType == 3)
                {
                    displayNewBal();

                    while (tranValid == false)
                    {
                        int count = activeAccount.getBalance();
                        int pauseTime2 = 5000;
                        System.Threading.Thread.Sleep(pauseTime2);
                        activeAccount.setBalance(count - 500);
                    }




                    tranValid = false;
                    int z = activeAccount.getBalance();
                    int pauseTime = 5000;
                    System.Threading.Thread.Sleep(pauseTime);
                    activeAccount.setBalance(z - 500);
                    tranValid = true;
                }
                int x = activeAccount.getBalance();
                string y = x.ToString();
                tboxInstructions.Text = "New Balance = £" + y;
            }
            // if cannot withdrwal due to not enough money, then display to user
            else
            {
                tboxInstructions.Text = "Insufficent Funds";
            }
        }


        // displays GUI to show balance
        private void displayNewBal() {
            resetForm();
            tboxInstructions.Visible = true;
            tmrBalDelay.Enabled = true;

        }


        // timer for testing
        private void tmr_test_Tick(object sender, EventArgs e)
        {
            this.Enabled = false;

        }


        // timer for logging in
        private void tmrBalDelay_Tick(object sender, EventArgs e)
        {
            loginDisplay();
            login = false;
            accountLog = false;
            tmrBalDelay.Enabled = false;
        }
    }

   
 











}
