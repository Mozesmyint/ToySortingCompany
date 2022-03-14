package mru.tsc.model;

public class Animals extends Toys{

	public String material;
	public char size;
	
	public Animals(long SN, String name, String brand, double price, int available, int ageAppropriate, String material, char size) {
		super(SN, name, brand, price, available, ageAppropriate);
		this.material = material;
		this.size = size;
	}
	
	public String getMaterial() {
		return material;
	}
	
	public char getSize() {
		return size;
	}
	
	public String printToSave() {
		return serialNumber + ";" + name + ";" + brand + ";" + price + ";" + available + ";" + ageAppropriate + ";" + material + ";" + size; 
	}
	
	@Override
	public String toString() {
		String fullFormat = "";
		if(size == 'S') {fullFormat = "Small";}
		if(size == 'M') {fullFormat = "Medium";}
		if(size == 'L') {fullFormat = "Large";}
		
		return "Category: Animal, " + "Serial Number: " + serialNumber + ", " + "Name: " + name + ", " + "Brand: " + brand + ", " + "Price: " + price + ", " + "Available Count: " + available + ", " + "Age Appropriate: " + ageAppropriate + ", " + "Material: " + material + ", " + "Size: " + fullFormat; 
	}
}
