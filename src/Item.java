public class Item {
	// Declare attributes here
	String name, ID;
	int value, durability;
	double weight;
	
	public Item() {

	}
	public Item(String name, String iD, int value, int durability, double weight) {
		this.name = name;
		ID = iD;
		this.value = value;
		this.durability = durability;
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getDurability() {
		return durability;
	}
	public void setDurability(int durability) {
		this.durability = durability;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
//	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name: "+ name +"\n"+"ID: "+ ID +"\n"+"Value: "+ value +"\n"+"Durability: "+ durability +"\n" + "Weight: "+ weight;
	}
	
}


