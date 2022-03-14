package mru.tsc.model;

public class Puzzles extends Toys{
	
	public char puzzleType;

	public Puzzles(long SN, String name, String brand, double price, int available, int ageAppropriate, char puzzleType) {
		super(SN, name, brand, price, available, ageAppropriate);
		this.puzzleType = puzzleType;
	}

	public char getPuzzleType() {
		return puzzleType;
	}
	
	public String printToSave() {
		return serialNumber + ";" + name + ";" + brand + ";" + price + ";" + available + ";" + ageAppropriate + ";" + puzzleType; 
	}

	@Override
	public String toString() {
		String fullFormat = "";
		if(puzzleType == 'M') {fullFormat = "Mechanical";}
		if(puzzleType == 'C') {fullFormat = "Cryptic";}
		if(puzzleType == 'L') {fullFormat = "Logic";}
		if(puzzleType == 'T') {fullFormat = "Trivia";}
		if(puzzleType == 'R') {fullFormat = "Riddle";}
		
		return "Category: Puzzle, " + "Serial Number: " + serialNumber + ", " + "Name: " + name + ", " + "Brand: " + brand + ", " + "Price: " + price + ", " + "Available Count: " + available + ", " + "Age Appropriate: " + ageAppropriate + ", " + "Puzzle type: " + fullFormat;
	}
}
