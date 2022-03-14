package mru.tsc.model;

public class BoardGames extends Toys{
	
	public String numOfPlayers;
	public String designer;

	public BoardGames(long SN, String name, String brand, double price, int available, int ageAppropriate, String numOfPlayers, String designer) {
		super(SN, name, brand, price, available, ageAppropriate);
		this.numOfPlayers = numOfPlayers;
		this.designer = designer;
	}
	
	public String getNumOfPlayers() {
		return numOfPlayers;
	}
	
	public String getDesigner() {
		return designer;
	}

	public String printToSave() {
		return serialNumber + ";" +name + ";"+ brand + ";" + price + ";" + available + ";" + ageAppropriate +  ";" + numOfPlayers + ";" + designer;					
	}
	
	@Override
	public String toString() {
		return "Category: Board Game, " + "Serial Number: " + serialNumber + ", " + "Name: " + name + ", " + "Brand: " + brand + ", " + "Price: " + price + ", " + "Available Count: " + available + ", " + "Age Appropriate: " + ageAppropriate +  ", " + "Number of Players: " + numOfPlayers + "Designer: " + designer;
	}
	
}
