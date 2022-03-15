package mru.tsc.model;

public abstract class Toys {

	public String serialNumber;
	public String name;
	public String brand;
	public double price;
	public int available;
	public int ageAppropriate;

	public Toys(String SN, String name, String brand, double price, int available, int ageAppropriate) {
		this.serialNumber = SN;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.available = available;
		this.ageAppropriate = ageAppropriate;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public int getAgeAppropriate() {
		return ageAppropriate;
	}

	public void setAgeAppropriate(int ageAppropriate) {
		this.ageAppropriate = ageAppropriate;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public abstract String printToSave();
	}
