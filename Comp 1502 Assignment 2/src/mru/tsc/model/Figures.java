package mru.tsc.model;

public class Figures extends Toys{
	
	public char classification;

	public Figures(long SN, String name, String brand, double price, int available, int ageAppropriate, char classification) {
		super(SN, name, brand, price, available, ageAppropriate);
		this.classification = classification;
	}

	public char getClassification() {
		return classification;
	}
	
	public String printToSave() {
		return serialNumber + ";" + name + ";" + brand + ";" + price + ";" + available + ";" + ageAppropriate + ";" + classification; 
	}
	
	@Override
	public String toString() {
		String fullFormat = "";
		if(classification == 'A') {fullFormat = "Action";}
		if(classification == 'D') {fullFormat = "Doll";}
		if(classification == 'H') {fullFormat = "Historic";}
		
		return "Category: Figures, " + "Serial Number: " + serialNumber + ", " + "Name: " + name + ", " + "Brand: " + brand + ", " + "Price: " + price + ", " + "Available Count: " + available + ", " + "Age Appropriate: " + ageAppropriate + ", " + "Classification: " + fullFormat;
	}
}
