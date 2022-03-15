package mru.tsc.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import mru.tsc.model.Animals;
import mru.tsc.model.BoardGames;
import mru.tsc.model.Figures;
import mru.tsc.model.Puzzles;
import mru.tsc.model.Toys;
import mru.tsc.view.AppMenu;

public class ToyManager {
	
	static String FILE_PATH = "res/toys.txt";
	Scanner input;
	ArrayList<Toys> tList;
	AppMenu appMen;
	
	
	public ToyManager() throws IOException {
		input = new Scanner(System.in);
		tList = new ArrayList<>();
		appMen = new AppMenu();
		loadToys(tList, FILE_PATH);
		launchApplication();
	}

	private void launchApplication() throws IOException{
		//Creating a loop whereby the program will keep running as long as the user wants, menu of this is in appMenu(showMainMenu)
		boolean flag = true;
		int option;
		
		
		appMen.welcomeMsg();
		
		while(flag) {
			option = appMen.showMainMenu();
			
			switch(option) {
			case 1:
				Search();
				break;
			case 2:
				addToy(tList, input);
				break;
			case 3:
				removeToy(tList, input);
				break;
			case 4:
				appMen.closeMsg();
				saveChanges(tList, FILE_PATH);
				System.out.println("Changes saved successfully");
				flag = false;
				System.exit(0);				//ending the program
			}
		}
		
	}
	
	public void addToy(ArrayList<Toys> tList, Scanner input) {
		//making variables to hold each of the values used in the text doc
		String SN;
		String name;
		String brand;
		double price;
		int available;
		int ageAppropriate;
		int option;
		
		
		option = appMen.addToySubMenu();
		
		//making case selections for types of toys
		switch(option) {
		
		case 1:
			char classification;
			
			System.out.println("Enter Serial Number:");
			SN = input.next();
			System.out.println("Enter Toy Name:");
			name = input.next();
			System.out.println("Enter Toy Brand:");
			brand = input.next();
			System.out.println("Enter Toy Price:");
			price = input.nextDouble();
			System.out.println("Enter Available Count:");
			available = input.nextInt();
			System.out.println("Enter Appropriate Age:");
			ageAppropriate = input.nextInt();
			System.out.println("Enter Classification of Figure:");
			classification = input.next().toUpperCase().charAt(0);
			
			tList.add(new Figures(SN, name, brand, price, available, ageAppropriate, classification)); //adding to array in format of text doc
			System.out.println("Toy added successfully!");
			break;
		case 2:
			String material;
			char size;
			
			System.out.println("Enter Serial Number:");
			SN = input.next();
			System.out.println("Enter Toy Name:");
			name = input.next();
			System.out.println("Enter Toy Brand:");
			brand = input.next();
			System.out.println("Enter Toy Price:");
			price = input.nextDouble();
			System.out.println("Enter Available Count:");
			available = input.nextInt();
			System.out.println("Enter Appropriate Age:");
			ageAppropriate = input.nextInt();
			System.out.println("Enter Material of Animal Toy:");
			material = input.next();
			System.out.println("Enter Size of Toy:");
			size = input.next().toUpperCase().charAt(0);
			
			tList.add(new Animals(SN, name, brand, price, available, ageAppropriate, material, size));
			System.out.println("Toy added successfully!");
			break;
		case 3:
			char type;
			
			System.out.println("Enter Serial Number:");
			SN = input.next();
			System.out.println("Enter Toy Name:");
			name = input.next();
			System.out.println("Enter Toy Brand:");
			brand = input.next();
			System.out.println("Enter Toy Price:");
			price = input.nextDouble();
			System.out.println("Enter Available Count:");
			available = input.nextInt();
			System.out.println("Enter Appropriate Age:");
			ageAppropriate = input.nextInt();
			System.out.println("Enter Type of Puzzle:");
			type = input.next().toUpperCase().charAt(0);
			
			tList.add(new Puzzles(SN, name, brand, price, available, ageAppropriate, type));
			System.out.println("Toy added successfully!");
			break;
		case 4:
			String min;
			String max;
			String numOfPlayers;
			String designer;
			
			System.out.println("Enter Serial Number:");
			SN = input.next();
			System.out.println("Enter Toy Name:");
			name = input.next();
			System.out.println("Enter Toy Brand:");
			brand = input.next();
			System.out.println("Enter Toy Price:");
			price = input.nextDouble();
			System.out.println("Enter Available Count:");
			available = input.nextInt();
			System.out.println("Enter Appropriate Age:");
			ageAppropriate = input.nextInt();
			System.out.println("Enter Minimum amount of players of Board Game:");
			min = input.next();
			System.out.println("Enter Maximum amount of players of Board Game:");
			max = input.next();
			
			numOfPlayers = min + "-" + max;
			
			System.out.println("Enter Name of Designer of Board Game:");
			designer = input.next();
			
			tList.add(new BoardGames(SN, name, brand, price, available, ageAppropriate, numOfPlayers, designer));
			System.out.println("Toy added successfully!");
			break;
		}
	}

	private void Search() throws IOException {
		//creating case selection for types of searching
		int option = appMen.showSubMenu();
		
		switch (option) {
		case 1:
			searchToysBySN(tList, input);
			break;
		case 2:
			searchToysByName(tList, input);
			break;
		case 3:
			searchToysByType(tList, input);
			break;
		case 4:
			launchApplication();		//reseting the program to main menu
			break;
		}
	}

	public static void loadToys(ArrayList<Toys> tList, String fileLocation) throws IOException {
		//initializing the array to read everything in the document
		File file = new File(fileLocation);
		Scanner inputFile = new Scanner(file);
		
		while(inputFile.hasNext()) {
			String str = inputFile.nextLine();
			String[] temp = str.split(";");
			
			String SN = temp[0];
			char firstSN = temp[0].charAt(0);
			
			//reading the first number of the serial number which then sorts the items to the other classes
			if((firstSN == '0') || (firstSN == '1')) {
				Toys toyTemp = new Figures(SN, temp[1], temp[2], Double.parseDouble(temp[3]), Integer.parseInt(temp[4]), Integer.parseInt(temp[5]), (temp[6].charAt(0)));
				tList.add(toyTemp);
			}
			if((firstSN == '2') || (firstSN == '3')) {
				Toys toyTemp = new Animals(SN, temp[1], temp[2], Double.parseDouble(temp[3]), Integer.parseInt(temp[4]), Integer.parseInt(temp[5]), temp[6], (temp[7].charAt(0)));
				tList.add(toyTemp);
			}
			if((firstSN == '4') || (firstSN == '5') || (firstSN == '6')) {
				Toys toyTemp = new Puzzles(SN, temp[1], temp[2], Double.parseDouble(temp[3]), Integer.parseInt(temp[4]), Integer.parseInt(temp[5]),(temp[6].charAt(0)));
				tList.add(toyTemp);
			}
			if((firstSN == '7') || (firstSN == '8') || (firstSN == '9')) {
				Toys toyTemp = new BoardGames(SN, temp[1], temp[2], Double.parseDouble(temp[3]), Integer.parseInt(temp[4]), Integer.parseInt(temp[5]), temp[6], temp[7]);
				tList.add(toyTemp);
			}
		}
		inputFile.close();
	}
	
	public static void removeToy(ArrayList<Toys> tList, Scanner input) throws IOException {
		System.out.print("Enter the serial number of toy: ");
		String SN = input.next();
		
		//finding the array size and making the array smaller to compensate toy removal
		for(int i = 0; i < tList.size(); i++) {
			final Toys t = tList.get(i);
			if(t.getSerialNumber().equals(SN)) {
				System.out.println(tList.get(i));
				
				char choice;
				System.out.println("Do you want to remove it (Y/N)? ");
				choice = input.next().toUpperCase().charAt(0);
				
				if(choice == 'Y') {
					System.out.println("Item Removed!");
					tList.remove(i--);
				}			
			}
		}
	}
	
	public static void saveChanges(ArrayList<Toys> tList, String fileLocation) throws IOException{
		//reads the document and writes into document
		PrintWriter pw = new PrintWriter(fileLocation);
		for(Toys t : tList) {
			pw.println(t.printToSave());
		}
		pw.close();
	}
	
	public void searchToysBySN(ArrayList<Toys> tList, Scanner input) throws IOException {
		
		boolean found = false;
		
		System.out.println("Enter a serial number to search for: ");
		String search = input.next();
		for(Toys t : tList) {
			if(t.getSerialNumber().equals(search)) {			//checking if user input matches something in the document which then displays the line
				if(t.getAvailable() > 0) {
					System.out.println(t);
					char choice;
					System.out.println("Would you like to purchase this toy (Y/N)? ");
					choice = input.next().toUpperCase().charAt(0);
					
					if(choice == 'Y') {
						t.setAvailable(t.getAvailable() - 1);
						System.out.println("The toy " + t.getName() + " has been purchased");
					}	else {
						Search();
					}		
					found = true;
				} else {
					System.out.println("Toy not available");
					found = true;
				}
			}
		}
		if(!found || (search).length()!= 10) { 		//if the serial number is too long then error trap
			System.out.println("Incorrect/Not Valid Serial Number");
		}
	}
	
	public void searchToysByName(ArrayList<Toys> tList, Scanner input) throws IOException {
		
		boolean found = false;
		
		System.out.println("Enter a Name to search for: ");
		String search = input.next();
		for (Toys t: tList) {
			if (t.getName().toLowerCase().contains(search.toLowerCase())) {		//matching to document if the user input contains something similar
				if(t.getAvailable() > 0) {
					System.out.println(t);
					char choice;
					System.out.println("Would you like to purchase this toy (Y/N)? ");
					choice = input.next().toUpperCase().charAt(0);
					if(choice == 'Y') {
						t.setAvailable(t.getAvailable() - 1);
						System.out.println("The toy " + t.getName() + " has been purchased");

					} else {
						Search();
					}			
					found = true;
				} else {
					System.out.println("Toy not available");
					found = true;
				}
			}
		}
		if(!found) {
			System.out.println("Incorrect Name");
		}
	}
	
	public void searchToysByType(ArrayList<Toys> tList, Scanner input) throws IOException {		//making cases for each of the types of toys which then asks the toy specific variable
		
		int option = appMen.searchByTypeSubMenu();
		switch (option) {
		case 1:
			System.out.println("Enter a Classification: ");
			 char classification = appMen.figureSubMenu();
			 for(Toys t : tList) {
				 if (t instanceof Figures) {
					 if(((Figures) t).getClassification() == classification){		//asking for figure specific variable
						 System.out.println(t);
						 char choice;
							System.out.println("Would you like to purchase this toy (Y/N)? ");
							choice = input.next().toUpperCase().charAt(0);
							if(choice == 'Y') {
								t.setAvailable(t.getAvailable() - 1);
								System.out.println("The toy " + t.getName() + " has been purchased");
							} else {
								Search();
							}
					 }
				 }
			 }
			break;
		case 2:
			System.out.println("Enter a Size: ");
			 char size = appMen.animalSubMenu();
			 for(Toys t : tList) {
				 if (t instanceof Animals) {
					 if(((Animals) t).getSize() == size){		//asking for animal specific variable
						 System.out.println(t);
						 char choice;
							System.out.println("Would you like to purchase this toy (Y/N)? ");
							choice = input.next().toUpperCase().charAt(0);
							if(choice == 'Y') {
								t.setAvailable(t.getAvailable() - 1);
								System.out.println("The toy " + t.getName() + " has been purchased");
							} else {
								Search();
							}
					 }
				 }
			 }
			break;
		case 3:
			System.out.println("Enter a Type: ");
			 char type = appMen.puzzleSubMenu();
			 for(Toys t : tList) {
				 if (t instanceof Puzzles) {
					 if(((Puzzles) t).getPuzzleType() == type){		//asking for puzzle specific variable
						 System.out.println(t);
						 char choice;
							System.out.println("Would you like to purchase this toy (Y/N)? ");
							choice = input.next().toUpperCase().charAt(0);
							if(choice == 'Y') {
								t.setAvailable(t.getAvailable() - 1);
								System.out.println("The toy " + t.getName() + " has been purchased");
							} else {
								Search();
							}
					 }
				 }
			 }
			break;
		case 4:
			System.out.println("Enter a range of players: ");
			 String numOfPlayers = appMen.boardgamesSubMenu();
			 for(Toys t : tList) {
				 if (t instanceof BoardGames) {
					 if(((BoardGames) t).getNumOfPlayers() == numOfPlayers){		//asking for board game specific variable
						 System.out.println(t);
						 char choice;
							System.out.println("Would you like to purchase this toy (Y/N)? ");
							choice = input.next().toUpperCase().charAt(0);
							if(choice == 'Y') {
								t.setAvailable(t.getAvailable() - 1);
								System.out.println("The toy " + t.getName() + " has been purchased");
							} else {
								Search();
							}
					 }
				 }
			 }
			break;
		}
	}
}
