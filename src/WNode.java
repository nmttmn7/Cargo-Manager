class WNode {
	private Weapon item;
	private WNode next;
	public WNode(Weapon item, WNode next) {
		
		this.item = item;
		this.next = next;
	}
	public Weapon getItem() {
		return item;
	}
	public void setItem(Weapon item) {
		this.item = item;
	}
	public WNode getNext() {
		return next;
	}
	public void setNext(WNode next) {
		this.next = next;
	}
	
	
}
