import java.io.File;




import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Assign04 {

	Scanner input = new Scanner(System.in);
	Scanner fileInput = null;
	boolean ransack;
	public Node start, next, tail;
	public int itemAddition = 0;
	public static void main(String[] args) {
		new Assign04();
	}

	// This will act as our program switchboard
	public Assign04() {
		
		
		
		System.out.println("Welcome to the BlackStar Cargo Hold interface.");
		System.out.println("Please select a number from the options below");
		System.out.println("");

		while (true) {
			// Give the user a list of their options
			System.out.println("1: Add an item to the cargo hold.");
			System.out.println("2: Remove an item from the cargohold.");
			System.out.println("3: Sort the contents of the cargo hold.");
			System.out.println("4: Search for an item.");
			System.out.println("5: Display the items in the cargo hold.");
			System.out.println("6: Perform a partial search for an item.");
			System.out.println("7: Save data");
			System.out.println("8: Load from a previous file.");
			System.out.println("9: Ransack.");
			System.out.println("0: Exit the BlackStar Cargo Hold interface.");
			// Get the user input
			int userChoice = input.nextInt();
			input.nextLine();
			
			switch (userChoice) {
			case 1:
				addItem();
				break;
				
			case 2:
				removeItem();
				break;
			case 3:
				sortItems();
				break;
			case 4:
				searchItems();
				break;	
			case 5:
				displayItems();
				break;
			case 6:
				partialSearch();
				break;
			case 7:
				saveItems();
				break;
			case 8:
				loadItems();
				break;
			case 9:
				ransack();
				break;
			case 0:
				System.out.println("Thank you for using the BlackStar Cargo Hold interface. See you again soon!");
				System.exit(0);
			
			}
			
		}
	
	}

	private void ransack() {
		boolean ransackItem = true;
		boolean add = false;
		double sum = 0;
		while (ransackItem == true) {
			if(add == true) {
			input.nextLine();
			}
			add = true;
			boolean weapon = false;
			boolean consumable = false;
			boolean equipable = false;
			int heal = 0;
			int hurt = 0;
			

			System.out.println("Enter Item's name at Slot " + (itemAddition + 1) + ": ");
			String name = input.nextLine();

			System.out.println("Enter Item's weight at Slot " + (itemAddition + 1) + ": ");
			double weight = input.nextDouble();
			input.nextLine();

			System.out.println("Enter Item's ID at Slot " + (itemAddition + 1) + ": ");
			String iD = input.nextLine();

			System.out.println("Enter Item's value at Slot " + (itemAddition + 1) + ": ");
			int value = input.nextInt();

			System.out.println("Enter Item's durability at Slot " + (itemAddition + 1) + ": ");
			int durability = input.nextInt();

			System.out.println("1:Item is a weapon.");
			System.out.println("2:Item is a consumable.");
			System.out.println("3:Item is a equipable.");

			int itemChoice = input.nextInt();
			switch (itemChoice) {
			case 1:
				weapon = true;
				break;
			case 2:
				consumable = true;
				break;
			case 3:
				equipable = true;
				break;
			}
			if (weapon == true) {
				System.out.println("Strength needed to use weapon: ");
				int strengthNeeded = input.nextInt();
				System.out.println("Skill needed to use weapon: ");
				int skillNeeded = input.nextInt();
				System.out.println("Enter the weapon's damage: ");
				double damageWeapon = input.nextDouble();

				if(start != null) {
					next = new Node(new Weapon(name, iD, value, durability, weight, strengthNeeded, skillNeeded, damageWeapon), null);
					tail.setNext(next);
					tail = next;
					itemAddition += 1;
				}
				if(start == null) {
				start = new Node(new Weapon(name, iD, value, durability, weight, strengthNeeded, skillNeeded, damageWeapon), null);
				tail = start;
				itemAddition += 1;
				}

				System.out.println("Would you like to stop adding items?" + "\n" + "1:Yes" + "\n" + "2:No");
				int anwser = input.nextInt();

				if (anwser == 1) {
					ransackItem = false;
				}
			}

			if (consumable == true) {
				boolean toxic;
				System.out.println("Duration of consumable: ");
				double duration = input.nextDouble();
				System.out.println("Is the consumbale toxic?" + "\n" + "1: True" + "\n" + "2: False");
				int toxicInput = input.nextInt();
				switch (toxicInput) {
				case 1:
					toxic = true;
					break;
				case 2:
					toxic = false;
					break;
				default:
					return;
				}
				if (toxic == false) {
					System.out.println("How much health does the consumable replenish: ");
					int addHeal = input.nextInt();
					heal += addHeal;

				} else {
					System.out.println("How much health does the consumable deminish: ");
					int subHurt = input.nextInt();
					hurt += subHurt;
				}


				if(start != null) {
					next = new Node(new Consumable(name, iD, value, durability, weight, heal, hurt, duration, toxic), null);
					tail.setNext(next);
					tail = next;
					itemAddition += 1;
				}
				if(start == null) {
				start = new Node(new Consumable(name, iD, value, durability, weight, heal, hurt, duration, toxic), null);
				tail = start;
				itemAddition += 1;
				}

				System.out.println("Would you like to stop adding items?" + "\n" + "1:Yes" + "\n" + "2:No");
				int anwser = input.nextInt();

				if (anwser == 1) {
					ransackItem = false;
				}
			}

			if (equipable == true) {
				boolean throwable;
				int throwDistance = 0;
				String whyThrow = "Yes you can ";
				System.out.println("Range of equipable: ");
				int range = input.nextInt();
				System.out.println("Is equipable item throwable?" + "\n" + "1: True" + "\n" + "2: False");
				int throwableInput = input.nextInt();
				switch (throwableInput) {
				case 1:
					throwable = true;
					break;
				case 2:
					throwable = false;
					break;
				default:
					return;
				}
				if (throwable == true) {
					System.out.println("Distance you can throw the equipable: ");
					int throwDistance2 = input.nextInt();
					throwDistance += throwDistance2;

				} else {
					System.out.println("Why can't you throw the equipable?");
					input.nextLine();
					String whyNot = input.nextLine();
					whyThrow = whyNot;
				}

				if(start != null) {
					next = new Node(new Equipable(name, iD, value, durability, weight, throwable, range, throwDistance, whyThrow), null);
					tail.setNext(next);
					tail = next;
					itemAddition += 1;
				}
				if(start == null) {
				start = new Node(new Equipable(name, iD, value, durability, weight, throwable, range, throwDistance, whyThrow), null);
				tail = start;
				itemAddition += 1;
				}

				System.out.println("Would you like to stop adding items?" + "\n" + "1:Yes" + "\n" + "2:No");
				int anwser = input.nextInt();

				if (anwser == 1) {
					ransackItem = false;
				}
			}

		}
		
		
		Node del = start; Node prev = null;
		
		prev = del;
		
	while(del != null) {
		
			if (del.getItem().getWeight() > 25 && del == start) {
			
					start = start.getNext();
					itemAddition -= 1;
					del = del.getNext();
					
			}
				if(del != start && del.getItem().getWeight() > 25 ){
					
					prev.setNext(del.getNext());
					itemAddition -= 1;
					del = del.getNext();
				}
			 else {
				sum += del.getItem().getWeight();
				prev = del;
				del = del.getNext();
			}
		}
	
	
	Node p = start;
	Node j=p;
	
	while(p != null) {
		Item min = p.getItem();
		double score = 0;
		double highscore = 0;
		
			while(j != null) {
				double left = p.getItem().getValue() / p.getItem().getWeight();
				double right = j.getItem().getValue() / j.getItem().getWeight();
				score = right - left;
				
				if(highscore > score){
					
					min = j.getItem();
					highscore = score;
				}
				j = j.getNext();
				
			}
		
			Node l = start;
			
			while(l != null) {
				if(l.getItem() == min) {
					
					l.setItem(p.getItem());
					
				}
				l = l.getNext();
			}
			
		Item mem = p.getItem();
		
		
		p.setItem(min);
		
			
			p = p.getNext();
			j = p;
	}
	
				
				
		
	

		
		p = start;
		while(p != null && sum > 25) {
			
			System.out.println("Deleting: " + start.getItem().getName());
				start = start.getNext();
				
				
				
				double mem = p.getItem().getWeight();
				
				itemAddition -= 1;
				sum -= mem;
				
				p = p.getNext();
			}
		
		p = start;
		int loop = 0;
		while(p != null) {
			loop += 1;
			System.out.println("\n" + "Slot " + loop + ": " + p.getItem());
			p = p.getNext();
		}

	}

	private void saveItems() {

		PrintWriter pw = null;
		try {	
			File file = new File("node.data");
			FileOutputStream fos = new FileOutputStream(file);
			pw = new PrintWriter(fos);
		} catch (FileNotFoundException e) {
			System.out.println("Not a catch");
		}
		Node p = start;
		while(p != null) {
			String answer = input.nextLine();
			
			pw.print(p.getItem());
			
			p = p.getNext();
		}
		
		System.out.println("Items saved");
		pw.close();

	}

	private void loadItems() {
		boolean Weapon = false;
		boolean Equipable = false;
		boolean Consumable = false;
		boolean Continue = true;
		int addition = 0;
		LoadNode loadStart = null, loadNext = null, loadTail = null;
		int loop = 0;
		try {

			fileInput = new Scanner(new File("node.data"));

			while (fileInput.hasNextLine()) {
				start = null;
				tail = null;
				itemAddition = 0;
				

				String searchFile = fileInput.nextLine();
				String question = searchFile.substring(0, searchFile.indexOf(':') + 1);
				String anw = searchFile.substring(searchFile.indexOf(':') + 2);
				
				if (searchFile.contains("Weapon") || searchFile.contains("Consumable")
						|| searchFile.contains("Equipable")) {
					
					if(loadStart != null) {
						
						loadNext = new LoadNode(searchFile, null);
						
						loadTail.setNext(loadNext);
						loadTail = loadNext;
						loop += 1;
					}
					if(loadStart == null) {
						
					loadStart = new LoadNode(searchFile, null);
					
					
					
					loadTail = loadStart;
					loop += 1;
					}
					

				}
				if (searchFile.contains(":")) {
					if(loadStart != null) {
						loadNext = new LoadNode(anw, null);
						
						loadTail.setNext(loadNext);
						loadTail = loadNext;
						loop += 1;
					}
					if(loadStart == null) {
					loadStart = new LoadNode(anw, null);
					
					loadTail = loadStart;
					loop += 1;
					}

				}
			}
			LoadNode p = loadStart;
			
			
			while(p != null) {
				
				
		
				if (addition < loop + 1 && Continue == true) {
					
					if (p.getItem().contains("Weapon")) {
						Weapon = true;
						Continue = false;
						
					}
					if (p.getItem().contains("Equipable")) {
						Equipable = true;
						Continue = false;
					}
					if (p.getItem().contains("Consumable")) {
						Consumable = true;
						Continue = false;
					}
				}
				p = p.getNext();
				
				String name = p.getItem();
				
				p = p.getNext();
				
				String iD = p.getItem();
				p = p.getNext();
				
				int value = Integer.parseInt(p.getItem());
				p = p.getNext();
				int durability = Integer.parseInt(p.getItem());
				p = p.getNext();
				double weight = Double.parseDouble(p.getItem());
				p = p.getNext();
				if (Weapon == true) {

					int strengthNeeded = Integer.parseInt(p.getItem());
					p = p.getNext();
					int skillNeeded = Integer.parseInt(p.getItem());
					p = p.getNext();
					double damageWeapon = Double.parseDouble(p.getItem());
					p = p.getNext();
					
					if(start != null) {
						next = new Node(new Weapon(name, iD, value, durability, weight, strengthNeeded, skillNeeded, damageWeapon), null);
						tail.setNext(next);
						tail = next;
						itemAddition += 1;
						
					}
					if(start == null) {
					start = new Node(new Weapon(name, iD, value, durability, weight, strengthNeeded, skillNeeded, damageWeapon), null);
					tail = start;
					itemAddition += 1;
					}
					
				
					
					Weapon = false;
					Consumable = false;
					Equipable = false;
					Continue = true;
					if (loop - 1 == addition + 8) {
						System.out.println("File Loaded");
						break;
					} else {
						addition += 9;
						
					}
				}
				if (Equipable == true) {

					int range = Integer.parseInt(p.getItem());
					p = p.getNext();
					Boolean throwable = Boolean.parseBoolean(p.getItem());
					p = p.getNext();
					int throwDistance = Integer.parseInt(p.getItem());
					p = p.getNext();
					String whyThrow = p.getItem();
					p = p.getNext();
					
					if(start != null) {
						next = new Node(new Equipable(name, iD, value, durability, weight, throwable, range, throwDistance, whyThrow), null);
						tail.setNext(next);
						tail = next;
						itemAddition += 1;
						
					}
					if(start == null) {
					start = new Node(new Equipable(name, iD, value, durability, weight, throwable, range, throwDistance, whyThrow), null);
					tail = start;
					itemAddition += 1;
					}
					
					
					Weapon = false;
					Consumable = false;
					Equipable = false;
					Continue = true;
					if (loop - 1 == addition + 9) {
						System.out.println("File Loaded");
						break;
					} else {
						addition += 10;
					}
				}

				if (Consumable == true) {

					Boolean toxic = Boolean.parseBoolean(p.getItem());
					p = p.getNext();
					int heal = Integer.parseInt(p.getItem());
					p = p.getNext();
					int hurt = Integer.parseInt(p.getItem());
					p = p.getNext();
					double duration = Double.parseDouble(p.getItem());
					p = p.getNext();

					if(start != null) {
						next = new Node(new Consumable(name, iD, value, durability, weight, heal, hurt, duration, toxic), null);
						tail.setNext(next);
						tail = next;
						itemAddition += 1;
					}
					if(start == null) {
					start = new Node(new Consumable(name, iD, value, durability, weight, heal, hurt, duration, toxic), null);
					tail = start;
					itemAddition += 1;
					}
					

					
					
					Weapon = false;
					Consumable = false;
					Equipable = false;
					Continue = true;
					if (loop - 1 == addition + 9) {
						System.out.println("File Loaded");
						break;
					} else {
						addition += 10;
					}
				}

			}
		}

		catch (FileNotFoundException e) {
			System.out.println("File not found!");
			addItem();
		}

	}

	private void addItem() {
		
	
		boolean userHas = false;
		
		

		while(true) {
			boolean weapon = false;
			boolean consumable = false;
			boolean equipable = false;
			
			int heal = 0;
			int hurt = 0;
			double sum = 0;
			
			
			if(itemAddition > 0) {
			Node p = start;
			while(p != null) {
				sum += p.getItem().getWeight();
				p = p.getNext();
			}
			}
			
			
			
		

		if (sum < 25) {
			
			if(userHas == true) {
				System.out.println("Would you like to stop adding items?" +  "\n" + "1:Yes" + "\n" + "2:No");
				int anwser = input.nextInt();
				input.nextLine();
				if(anwser == 1) {
					Node p = start;
					break;
				}
				
				}
			System.out.println("Weight: " + sum);
			System.out.println("Enter Item's name at Slot " + (itemAddition + 1) + ": ");
			String name = input.nextLine();
			userHas = true;
			
			System.out.println("Enter Item's weight at Slot " + (itemAddition + 1) + ": ");
			double weight = input.nextDouble();
			input.nextLine();
			if(25 < weight) {
				System.out.println("Item is too big!");
				return;
			}
			if (sum + weight > 25 && weight < 25) {
				System.out.println("The cargohold is full!");
				return;
			}

			System.out.println("Enter Item's ID at Slot " + (itemAddition + 1) + ": ");
			String iD = input.nextLine();

			System.out.println("Enter Item's value at Slot " + (itemAddition + 1) + ": ");
			int value = input.nextInt();

			System.out.println("Enter Item's durability at Slot " + (itemAddition + 1) + ": ");
			int durability = input.nextInt();

			System.out.println("1:Item is a weapon.");
			System.out.println("2:Item is a consumable.");
			System.out.println("3:Item is a equipable.");

			int itemChoice = input.nextInt();
			switch (itemChoice) {
			case 1:
				weapon = true;
				break;
			case 2:
				consumable = true;
				break;
			case 3:
				equipable = true;
				break;
			}
			if (weapon == true) {
				System.out.println("Strength needed to use weapon: ");
				int strengthNeeded = input.nextInt();
				System.out.println("Skill needed to use weapon: ");
				int skillNeeded = input.nextInt();
				System.out.println("Enter the weapon's damage: ");
				double damageWeapon = input.nextDouble();

				if(start != null) {
					next = new Node(new Weapon(name, iD, value, durability, weight, strengthNeeded, skillNeeded, damageWeapon), null);
					tail.setNext(next);
					tail = next;
					itemAddition += 1;
				}
				if(start == null) {
				start = new Node(new Weapon(name, iD, value, durability, weight, strengthNeeded, skillNeeded, damageWeapon), null);
				tail = start;
				itemAddition += 1;
				}
				
				Node p = start;
				while(p != null) {
					System.out.println(p.getItem());
					p = p.getNext();
				}
			}

			if (consumable == true) {
				boolean toxic;
				System.out.println("Duration of consumable: ");
				double duration = input.nextDouble();
				System.out.println("Is the consumbale toxic?" + "\n" + "1: True" + "\n" + "2: False");
				int toxicInput = input.nextInt();
				switch (toxicInput) {
				case 1:
					toxic = true;
					break;
				case 2:
					toxic = false;
					break;
				default:
					return;
				}
				if (toxic == false) {
					System.out.println("How much health does the consumable replenish: ");
					int addHeal = input.nextInt();
					heal += addHeal;

				} else {
					System.out.println("How much health does the consumable deminish: ");
					int subHurt = input.nextInt();
					hurt += subHurt;
				}

				
				if(start != null) {
					next = new Node(new Consumable(name, iD, value, durability, weight, heal, hurt, duration, toxic), null);
					tail.setNext(next);
					tail = next;
					itemAddition += 1;
				}
				if(start == null) {
				start = new Node(new Consumable(name, iD, value, durability, weight, heal, hurt, duration, toxic), null);
				tail = start;
				itemAddition += 1;
				}
				
				Node p = start;
				while(p != null) {
					System.out.println(p.getItem());
					p = p.getNext();
				}
			}
			

			if (equipable == true) {
				boolean throwable;
				int throwDistance = 0;
				String whyThrow = "Yes you can ";
				System.out.println("Range of equipable: ");
				int range = input.nextInt();
				System.out.println("Is equipable item throwable?" + "\n" + "1: True" + "\n" + "2: False");
				int throwableInput = input.nextInt();
				switch (throwableInput) {
				case 1:
					throwable = true;
					break;
				case 2:
					throwable = false;
					break;
				default:
					return;
				}
				if (throwable == true) {
					System.out.println("Distance you can throw the equipable: ");
					int throwDistance2 = input.nextInt();
					throwDistance += throwDistance2;

				} else {
					System.out.println("Why can't you throw the equipable?");
					input.nextLine();
					String whyNot = input.nextLine();
					whyThrow = whyNot;
				}

				
				if(start != null) {
					next = new Node(new Equipable(name, iD, value, durability, weight, throwable, range, throwDistance, whyThrow), null);
					tail.setNext(next);
					tail = next;
					itemAddition += 1;
				}
				if(start == null) {
				start = new Node(new Equipable(name, iD, value, durability, weight, throwable, range, throwDistance, whyThrow), null);
				tail = start;
				itemAddition += 1;
				}
				
				Node p = start;
				while(p != null) {
					System.out.println(p.getItem());
					p = p.getNext();
				}
			}	
			}
			

		
	if (sum >= 25) {
		System.out.println("The cargohold is full!");
	  }
	}	}
	

	private void removeItem() {
		// TODO: Remove an item that is specified by the user
		int loop = 0;
		System.out.println("Enter the item's name you would like to remove: ");
		String removeItem = input.nextLine();
		
		Node del = start; Node prev = null;
		
		
		
		while(del != null && removeItem.equalsIgnoreCase(del.getItem().getName())) {
		
			prev = del;
			del = del.getNext();
			loop += 1;
		}
		if(del == null) {
			System.out.println("Item was not found");
		}else {
			if(del == start) {
				start = start.getNext();
				System.out.println("Item was removed at Slot: 1");
				itemAddition -= 1;
			}else {
				prev.setNext(del.getNext());
				System.out.println("Item was removed Slot: " + (loop + 1));
				itemAddition -= 1;
			}
		}
		
		
	}
		
		
	
	
	private void sortItems() {
		Node p = start;
		Node j=p;
		
		while(p != null) {
			Item min = p.getItem();
			int score = 0;
			
			
				while(j != null) {
					
					if((p.getItem().getName().compareToIgnoreCase(j.getItem().getName()) > score)) {
						
						min = j.getItem();
						score = p.getItem().getName().compareToIgnoreCase(j.getItem().getName());
					}
					j = j.getNext();
					
				}
				
				Node l = start;
				
				while(l != null) {
					if(l.getItem() == min) {
						
						l.setItem(p.getItem());
						
					}
					l = l.getNext();
				}
				
			Item mem = p.getItem();
			
			
			p.setItem(min);
			
				
				p = p.getNext();
				j = p;
		}
		
		
	}
	
		


	

	private void searchItems() {
		int loop = 0;
		System.out.println("Enter the item's name: ");
		String searchName = input.nextLine();
		System.out.println("Enter the item's ID: ");
		String searchID = input.nextLine();
		Node p;
		p = start;
		
		while(p != null) {
			
			String name = p.getItem().getName();
			String IDen = p.getItem().getID();
			
			if(name.equals(searchName) && IDen.equals(searchID)) {
				break;
			}
			p = p.getNext();
			loop += 1;
		}
		if(p != null) {
			
			System.out.println("Item Found at Slot: " + (loop + 1));
			
		}else {
			System.out.println("Item Not Found");
		}

	}

	private void displayItems() {
		
		
		Node p = start;
		while(p != null) {
			System.out.println(p.getItem());
			p = p.getNext();
		}
	}
	

	private void partialSearch() {
		System.out.println("Filter list through the beginning letter: ");
		String filter = input.nextLine();
		Node p = start;
		int loop = 0;
		while(p != null) {
			loop += 1;
			if (p.getItem().getName().startsWith(filter)) {
				
				System.out.println("\n" + "Slot " + loop + ": " +p.getItem());
				
			}
			p = p.getNext();
		}
	}
}
