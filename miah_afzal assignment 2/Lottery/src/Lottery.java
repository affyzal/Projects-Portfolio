import java.util.*;  

  
public class Lottery { 
	
	public static int lottery_max = 6;
	
	public static int lottery_min = 0;
	
/**
 * 	
 * @param args
 */
public static void main(String[] args) {  
	System.out.println("1. Play the Lottery");
	System.out.println("2. Set Lottery range");
	System.out.println("3. Quit\n>>>");
	
	Scanner s2 = new Scanner(System.in);
	int menu = s2.nextInt();
	
	//menu = 1, run the lottery
	while (menu == 1) {
		System.out.println("How many weeks of lottery draws would you like to do\n>>>");
		Scanner s6 = new Scanner(System.in);
		int numdraws = s6.nextInt();
		
		//run the loterry for how many draws entered
		for (int x = 0; x < numdraws; x++) {
		
		HashSet<Integer> nums = new HashSet<Integer>();  
		System.out.println("USER 1");
		for(int y = 0; y < 6; y++) {
    	//get user input to choose their numbers
			Scanner s1 = new Scanner(System.in)	;
			System.out.println("Enter the number\n>>>");
			int num = 0;
			num = s1.nextInt();
			//validate input
			while(num < lottery_min || num > lottery_max) {
				System.out.println("INVALID INPUT!!!");
				System.out.println("Enter the number\n>>>");
				num = s1.nextInt();
			}


			nums.add(num);
    	
		}
		
		HashSet<Integer> nums2 = new HashSet<Integer>();  
		System.out.println("USER 2");
		for(int y = 0; y < 6; y++) {
    	//get user input to choose their numbers
			Scanner s1 = new Scanner(System.in)	;
			System.out.println("Enter the number\n>>>");
			int num = 0;
			num = s1.nextInt();
			//validate input
			while(num < lottery_min || num > lottery_max) {
				System.out.println("INVALID INPUT!!!");
				System.out.println("Enter the number\n>>>");
				num = s1.nextInt();
			}


			nums2.add(num);
    	
		}
		
		HashSet<Integer> nums3 = new HashSet<Integer>();  
		System.out.println("USER 3");
		for(int y = 0; y < 6; y++) {
    	//get user input to choose their numbers
			Scanner s1 = new Scanner(System.in)	;
			System.out.println("Enter the number\n>>>");
			int num = 0;
			num = s1.nextInt();
			//validate input
			while(num < lottery_min || num > lottery_max) {
				System.out.println("INVALID INPUT!!!");
				System.out.println("Enter the number\n>>>");
				num = s1.nextInt();
			}


			nums3.add(num);
    	
		}
    
		HashSet<Integer> lottery = new HashSet<Integer>();
    
		//create duplicate set for checking sets
		HashSet<Integer> checking = new HashSet<Integer>(lottery);
    
		int matching = 0;
    
    //generate lottery numbers using random
		for(int z = 0; z < 6; z++) {
			Random randNum = new Random();
			int rnum;
			rnum = (randNum.nextInt(lottery_max)) + lottery_min;
			lottery.add(rnum);

    }
    
    
 //create iterator to check sets
		Iterator<Integer> iterator = nums.iterator();
    //run through lotto nums comparing to user lotto nums
		while (iterator.hasNext()) {
			if(lottery.contains(iterator.next())){
				matching = matching + 1;
			}
		}
		
		//check winner and output to user
		System.out.println("On week " + (x+1) + "User 1 " );
		CheckWinner(matching);
		matching = 0;
		
		
		
		 //create iterator to check sets
		Iterator<Integer> iterator2 = nums.iterator();
    //run through lotto nums comparing to user lotto nums
		while (iterator2.hasNext()) {
			if(lottery.contains(iterator2.next())){
				matching = matching + 1;
			}
		}
		
		//check winner and output to user
		System.out.println("On week " + (x+1)+ "User 2 ");
		CheckWinner(matching);
		matching = 0;
		
		
		 //create iterator to check sets
		Iterator<Integer> iterator3 = nums.iterator();
    //run through lotto nums comparing to user lotto nums
		while (iterator3.hasNext()) {
			if(lottery.contains(iterator3.next())){
				matching = matching + 1;
			}
		}
		
		//check winner and output to user
		System.out.println("On week " + (x+1) + "User 3 ");
		CheckWinner(matching);
		
		}
    
		System.out.println("1. Play the Lottery");
		System.out.println("2. Set Lottery range");
		System.out.println("3. Quit\n>>>");
		Scanner s4 = new Scanner(System.in);
		menu = s4.nextInt();
		
		}
	//2, allows for user to set upper and lower boundary for the lotto
    	while(menu==2) {
    		System.out.println("Enter the lower boundary for the range\n>>>");
    		Scanner s3 = new Scanner(System.in);
    	
    		lottery_min = s3.nextInt();
    	
    		System.out.println("Enter the upper boundary for the range\n>>>");
    		lottery_max = s3.nextInt();
    	
    		System.out.println("1. Play the Lottery");
    		System.out.println("2. Set Lottery range");
    		System.out.println("3. Quit\n>>>");
    		Scanner s5 = new Scanner(System.in);
    		menu = s5.nextInt();
    	}
    

    	
}  

/**
 * function to calculate/notify user of winnings
 * @param matches - number of matches user numbers has with lotto numbers
 */
public static void CheckWinner(int matches) {
	if(matches < 3) {
		System.out.println(" You have not won any money!");
	}
	else {
		if(matches == 3) {
			System.out.println("You have won £25!");
		}
		if(matches == 4) {
			System.out.println("You have won £100");
		}
		if(matches == 5) {
			System.out.println("You have won £1000");
		}
		if(matches == 6) {
			System.out.println("You have won the JACKPOT OF £1000000");
		}
	}
}

}