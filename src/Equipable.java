public class Equipable extends Item{
	boolean throwable;
	int range,throwDistance;
	String whyThrow;
	
	public Equipable() {
		
	}

	public Equipable(String name, String iD, int value, int durability, double weight, boolean throwable, int range, int throwDistance, String whyThrow) {
		super(name, iD, value, durability, weight);
		// TODO Auto-generated constructor stub
		this.throwable = throwable;
		this.range = range;
		this.throwDistance = throwDistance;
		this.whyThrow = whyThrow;
	}

	public boolean isThrowable() {
		return throwable;
	}

	public void setThrowable(boolean throwable) {
		this.throwable = throwable;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getThrowDistance() {
		return throwDistance;
	}

	public void setThrowDistance(int throwDistance) {
		this.throwDistance = throwDistance;
	}

	public String getWhyThrow() {
		return whyThrow;
	}

	public void setWhyThrow(String whyThrow) {
		this.whyThrow = whyThrow;
	}

	public String toString() {
		// TODO Auto-generated method stub
		return "Equipable "+"\n"+"Name: "+ getName() +"\n" +"ID: "+ getID() +"\n"+"Value: "+ getValue() +"\n"+"Durability: "+ getDurability() +"\n"+ "Weight: "+ getWeight() + "\n" + "Range: " + range + "\n" + "Throwable: "+ throwable + "\n" + 
				"Throw distance: " + throwDistance + "\n" +"Why can't you throw this item: "+ whyThrow + "\n" ;
	}
	
}
