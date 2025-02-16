public class Node{
	Item item;
	Node next;
	String string = "";
	public Node() { 
       
		item = new Item();
		next = null;
	}
	
	public Node(Item item, Node next) {
		this.item  = item;
		this.next = next;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	public String toString() {
		string = item.getName();
		return string;
	}
}
