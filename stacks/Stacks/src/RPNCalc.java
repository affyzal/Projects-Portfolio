import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RPNCalc {

	public static Stack nums;
	
	public RPNCalc() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * function to carry out main procedures
	 * @param args
	 */
	public static void main(String[] args) {
		int menu = 0;
		while (menu >= 0) {
			System.out.print("1.Calculator");
			System.out.print("2.instructions");
			System.out.print("3.Exit");
			if (menu == 1) {
		// TODO Auto-generated method stub
				
		Scanner s1 = new Scanner(System.in);
		String line;
		System.out.println("Enter the calc string\n>>>");
		line = s1.nextLine();
		String[] splitlist = line.split(",");
		
		String num;
		boolean tokens = true;
		
		while(tokens == true) {
			int x = 0;
			num = splitlist[x];
			x += 1;
			
			boolean type = true;
			
			try {
				
				int num1 = Integer.parseInt(num);
				
			} catch(NumberFormatException e) {
				type = false;
			
}
			if(type==true) {
				//value is a number
				int num1 = Integer.parseInt(num);
				nums.push(num1);
		}
			else {
				//value is an operator
				
				/**
				 * addition
				 */
				if(splitlist[x].equals("+")) {
					int num1 = nums.stack.head.getNum();
					nums.pop(nums.stack);
					
					int num2 = nums.stack.head.getNum();
					nums.pop(nums.stack);
					
					int number = (num1 + num2);
					System.out.print(number);
					nums.push(number);
				}
				/**
				 * subtraction
				 */
				if(splitlist[x].equals("-")) {
					int num1 = nums.stack.head.getNum();
					nums.pop(nums.stack);
				
					int num2 = nums.stack.head.getNum();
					nums.pop(nums.stack);
				
					int number = (num1 - num2);
					System.out.print(number);
					nums.push(number);
			}
				/**
				 * multiplication operator
				 */
				if(splitlist[x].equals("*")) {
					int num1 = nums.stack.head.getNum();
					nums.pop(nums.stack);
				
					int num2 = nums.stack.head.getNum();
					nums.pop(nums.stack);
				
					int number = (num1 * num2);
					System.out.print(number);
					nums.push(number);
			}
				/**
				 * division operstor
				 */
				if(splitlist[x].equals("/")) {
					int num1 = nums.stack.head.getNum();
					nums.pop(nums.stack);
				
					int num2 = nums.stack.head.getNum();
					nums.pop(nums.stack);
				
					int number = (num1 / num2);
					System.out.print(number);
					nums.push(number);
			}
		
		}
		}
		}
		if (menu == 2) {
			System.out.print("Enter the input as an RPN input. e.g 10,2,3,+,4,5,-");
		}
		if (menu == 3) {
			return;
		}
		
		
	}

}
}
