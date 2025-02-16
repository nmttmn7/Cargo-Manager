class Weapon extends Item {
	int strengthNeeded, skillNeeded;
	double damageWeapon;

	public Weapon() {

	}

	public Weapon(String name, String iD, int value, int durability, double weight, int strengthNeeded, int skillNeeded,
			double damageWeapon) {
		super(name, iD, value, durability, weight);

		this.strengthNeeded = strengthNeeded;
		this.skillNeeded = skillNeeded;
		this.damageWeapon = damageWeapon;
	}

	public int getStrengthNeeded() {
		return strengthNeeded;
	}

	public void setStrengthNeeded(int strengthNeeded) {
		this.strengthNeeded = strengthNeeded;
	}

	public int getSkillNeeded() {
		return skillNeeded;
	}

	public void setSkillNeeded(int skillNeeded) {
		this.skillNeeded = skillNeeded;
	}

	public double getdamageWeapon() {
		return damageWeapon;
	}

	public void setdamageWeapon(int damageWeapon) {
		this.damageWeapon = damageWeapon;
	}

	public String toString() {
		// TODO Auto-generated method stub
		return "Weapon " + "\n" + "Name: " + getName() + "\n" + "ID: " + getID()
				+ "\n" + "Value: " + getValue() + "\n" + "Durability: " + getDurability() + "\n" + "Weight: "
				+ getWeight() + "\n" + "Strength needed: " + strengthNeeded + "\n"
				+ "Skill needed: " + skillNeeded + "\n" + "Damage output: " + damageWeapon + "\n";
	}
}
