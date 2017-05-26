import java.util.Scanner;

public class SalesRecords {

	/*

	IPO:

	INPUTS:
		customer number
		name
		sales amount
		tax code
		
	PROCESSES:
		prompts for inputs
		assign tax value based on tax code
		calculate tax
		calculate total
		prints results
		loop until user chooses to exit
		
	OUTPUTS:
		results to screen

	*************************

	PSEUDOCODE:
		INITIATE name, tax code, tax, taxPercent, custNumber, salesAmount, salesTotal, repeat = 'Y'

		WHILE repeat = 'Y'
			PROMPT name ASSIGN to name
			PROMPT custNumber ASSIGN to custNumber
			PROMPT salesAmount ASSIGN to salesAmount
			PROMPT taxCode ASSIGN to taxCode
			
			ASSIGN taxPercent based on taxCode
			ASSIGN taxPercent * salesAmount to tax
			ASSIGN tax + salesAmmount to salesTotal
			
			DISPLAY results
			PROMPT repeat ASSIGN to repeat

	*/
	
	public static void main(String[] args) {
		String taxCode;
		int custNumber;
		String name;
		double salesAmount;
		double taxPercent = 0;
		double tax;
		double salesTotal;
		char repeat = 'Y';
		Scanner scan = new Scanner(System.in);
		
		//loops until user decides they are done
		while (repeat == 'Y' || repeat == 'y'){
			
			//get user's name
			do {
				System.out.println("Please enter your name: ");
				name = scan.nextLine();
				if (name.length() < 1) System.out.println("Your name much be at lease one character and no more than 20!");
			} while (name.length() < 1 || name.length() > 20);
			
			//get custNumber
			System.out.println("please enter your customer number: ");
			while (!scan.hasNextInt()){
				System.out.println("You must enter a number!");
				scan.next();
			}
			custNumber = scan.nextInt();
			
			//get taxCode
			do {
				System.out.println("Please enter your 3 letter tax code(NRM, NPF or BIZ): ");
				taxCode = scan.next().toUpperCase();
			} while (!taxCode.equals("NRM") && !taxCode.equals("NPF") && !taxCode.equals("BIZ"));
	
			//convert taxCode to taxPercent
			switch(taxCode){
				case "NRM": taxPercent = .06; break;
				case "NPF": taxPercent = 0; break;
				case "BIZ": taxPercent = .045; break;
			}
			
			//get salesAmount
			System.out.println("Please enter your sales amount: ");
			while (!scan.hasNextDouble()){
				System.out.println("you must enter a number!");
				scan.next();
			}
			salesAmount = scan.nextDouble();
			
			//calculate tax and total
			tax = salesAmount * taxPercent;
			salesTotal = tax + salesAmount;
			
			//display results
			System.out.println("*******************************");
			System.out.println("Customer number: " + custNumber);
			System.out.println("Customer name: " + name);
			System.out.println("Sales amount: $" + roundToTwoDec(salesAmount));
			System.out.println("Tax code: " + taxCode);
			System.out.println("Tax percent: " + taxPercent * 100 + "%");
			System.out.println("Tax amount: $" + roundToTwoDec(tax));
			System.out.println("Total amount due: $" + roundToTwoDec(salesTotal));
			System.out.println("*******************************");
			
			//prompt for repeat
			System.out.println("do you want to enter another record? (y/n): ");
			repeat = scan.next().charAt(0);
		}
		//be nice
		System.out.println("Thank you for using the SalesRecords program, have a nice day.");
		scan.close();
	}
	
	//function to round to 2 dec places
	public static double roundToTwoDec(double d)  
	{   
	   int temp = (int)(d * Math.pow(10 , 2));  
	   return ((double)temp)/Math.pow(10 , 2);  
	}

}


