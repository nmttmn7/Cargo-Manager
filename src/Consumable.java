public class Consumable extends Item{
	int heal,hurt;	
	double duration;
	boolean toxic;
	
public Consumable(){
	
}

public Consumable(String name, String iD, int value, int durability, double weight, int heal, int hurt, double duration, boolean toxic) {
	super(name, iD, value, durability, weight);
	this.heal = heal;
	this.hurt = hurt;
	this.duration = duration;
	this.toxic = toxic;
}



public int getHeal() {
	return heal;
}

public void setHeal(int heal) {
	this.heal = heal;
}

public int getHurt() {
	return hurt;
}

public void setHurt(int hurt) {
	this.hurt = hurt;
}

public double getDuration() {
	return duration;
}

public void setDuration(double duration) {
	this.duration = duration;
}

public boolean isToxic() {
	return toxic;
}

public void setToxic(boolean toxic) {
	this.toxic = toxic;
}

public String toString() {
	// TODO Auto-generated method stub
	return "Consumable "+"\n"+"Name: "+ getName() +"\n" + "ID: "+ getID() +"\n"+"Value: "+ getValue() +"\n"+"Durability: "+ getDurability() +"\n"+ "Weight: "+ getWeight() + "\n" + 
			"Harmful: " + toxic + "\n" + "Health provided: "+ heal + "\n" + 
			"Damage dealt: " + hurt + "\n" + "Duration: "+ duration +"\n";
}


}


	
