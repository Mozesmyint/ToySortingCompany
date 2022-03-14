package mru.tsc.view;

import java.util.Scanner;

public class AppMenu {
	
	Scanner input;
	
	public AppMenu() {
		input = new Scanner(System.in);
		
	}
	
	public void welcomeMsg() {
		System.out.println("************************************************************************************\n"
				+          "***                         WELCOME TO TOY STORE COMPANY                         ***\n"
				+          "************************************************************************************\n");
	}
	
	public void closeMsg() {
		System.out.println("************************************************************************************\n"
				+          "***                            THANK YOU FOR VISITING                            ***\n"
				+          "************************************************************************************\n");
	}
	
	public int showMainMenu() {
		System.out.println("How We May Help You?\n");
		System.out.println("\t1. Search Inventory and Purchase Toy");
		System.out.println("\t2. Add New Toy");
		System.out.println("\t3. Remove Toy");
		System.out.println("\t4. Save and Exit\n");
		System.out.print("Enter Option: ");
		
		String option = input.next();
		
		while(!option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4")) {			//general user validation of input
			System.out.print("Invalid response, Please enter a number here: ");
			option = input.next();
			
		}
		return Integer.parseInt(option);
	}
	
	public int showSubMenu() {
		System.out.println("Find Toys With:\n");
		System.out.println("\t1. Serial Number(SN)");
		System.out.println("\t2. Toy Name");
		System.out.println("\t3. Type");
		System.out.println("\t4. Back to Main Menu\n");
		System.out.print("Enter Option: ");
		
		String option = input.next();
		
		while(!option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4")) {			//general user validation of input
			System.out.print("Invalid response, Please enter a number here: ");
			option = input.next();
			
		}
		return Integer.parseInt(option);
	}
	
	public String newToyMenu() {
		String newToy = "";
		
		System.out.println("Enter Serial Number:");
		String serialNumber = input.next();
		System.out.println("Enter Toy Name:");
		String toyName = input.next();
		System.out.println("Enter Toy Brand:");
		String toyBrand = input.next();
		System.out.println("Enter Toy Price:");
		String price = input.next();
		System.out.println("Enter Available Count:");
		String count = input.next();
		System.out.println("Enter Appropriate Age:");
		String age = input.next();
		System.out.println("Enter Minimum Number of Players:");
		String minPlayers = input.next();
		System.out.println("Enter Maximum Number of Players:");
		String maxPlayers = input.next();
		System.out.println("Enter Designer Names(Use ',' to separate the names if there is more than one):");
		String names = input.next();

		newToy = serialNumber + ", " + toyName + ", " + toyBrand + ", " + price + ", " + count + ", " +
		age + ", " + minPlayers + ", " + maxPlayers + ", " + names;
		
		return newToy;
	}
	
	public int addToySubMenu() {
		System.out.println("What type of toy would you like to add?: ");
		System.out.println("\t1. Figures");
		System.out.println("\t2. Animals");
		System.out.println("\t3. Puzzles");
		System.out.println("\t4. Board Games");
		System.out.print("Enter Option: ");
		
		int type = input.nextInt();
		
		return type;
		
	}
	
	
	public String searchBySNSubMenu() {
		
		System.out.println("Enter the Toy Serial Number:");
		String SN = input.next();
		return SN;
	}
	
	public String searchByNameSubMenu() {
		
		System.out.println("Enter The Toy Name:");
		String name = input.next();
		return name;
	}
	
	public int searchByTypeSubMenu() {
		
		System.out.println("Select The Toy Type");
		System.out.println("\t1. Figures");
		System.out.println("\t2. Animals");
		System.out.println("\t3. Puzzles");
		System.out.println("\t4. Board Games");
		System.out.print("Enter Option: ");
		
		int type = input.nextInt();
		
		return type;
	}

	public char figureSubMenu() {
		System.out.println("A for Action Figure");
		System.out.println("D for Doll");
		System.out.println("H for Historical Figure");
		System.out.print("Enter Option: ");
		
		char classification = input.next().toUpperCase().charAt(0);
		
		return classification;
	}

	public char animalSubMenu() {
		System.out.println("S for size Small");
		System.out.println("M for size Medium");
		System.out.println("L for size Large");
		System.out.print("Enter Option: ");
		
		char size = input.next().toUpperCase().charAt(0);
		
		return size;
	}
	
	public char puzzleSubMenu() {
		System.out.println("M for Mechanical");
		System.out.println("C for Cryptic");
		System.out.println("L for Logic");
		System.out.println("T for Trivia");
		System.out.println("R for Riddle");
		System.out.print("Enter Option: ");
		
		char type = input.next().toUpperCase().charAt(0);
		
		return type;
	}

	public String boardgamesSubMenu() {
		System.out.println("Minimum players?: ");
		int min = input.nextInt();
		
		System.out.println("Maximum players?: ");
		int max = input.nextInt();

		String numOfPlayers = min + "-" + max; 
		
		return numOfPlayers;
	}
	
}
