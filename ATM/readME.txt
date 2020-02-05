On launch Bank system menu shows up with 3 buttons for 3 options.

Option 1: Run 2 standard ATM's.

Option 2: Run 2 ATM's with "data race" problem enabled.
	To simulate the data race problem, login to both ATM's using the same account details.
	Click withdraw button on both ATM's
	Select a withdraw value on one ATM then the same value on the Other.
	It would then display the same balance on both ATM's even though it used the same account
 	illustrating the data race.

Option 3: Run 2 ATM's with "data race" solution enables.
	To simulate the data race solution, login to both ATM's using the same account details.
	Click withdraw button on both ATM's
	Select a withdraw value on one ATM then the same value on the Other.
	It would then display a different balance on both ATM's even though it used the same account
 	illustrating the data race is solved.

The text-box on the right side display the balance of that account.	Account 1
									Account 2
									Account 3


Account details to be used to login
(Account num, Pin Num, Balance):
	111111,1111,300
	222222,2222,750
	333333,3333,3000