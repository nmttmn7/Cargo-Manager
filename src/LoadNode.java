
public class LoadNode{
	String item;
	LoadNode Loadnext;
	String string = " ";
	
	
	public LoadNode(String item, LoadNode next) {
		super();
		this.item = item;
		this.Loadnext = next;
	}
	
	public String getItem() {
		return item;
	}
	public LoadNode getLoadnext() {
		return Loadnext;
	}

	public void setLoadnext(LoadNode loadnext) {
		Loadnext = loadnext;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public void setItem(String item) {
		this.item = item;
	}
	public LoadNode getNext() {
		return Loadnext;
	}
	public void setNext(LoadNode next) {
		this.Loadnext = next;
	}
	
	public String toString() {
		string = item;
		return string;
	}
}
