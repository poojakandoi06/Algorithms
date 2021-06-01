package giftList;

public class Item {
	String item_Name;  
	String item_description;  
	String recipient;
	String buy_from;
	int price;

	//constructor 
	public Item(String name, String desc, String seller, String recipient, int price) {
		this.item_Name = name;
		this.item_description = desc;
		this.buy_from = seller;
		this.recipient = recipient;
		this.price = price;
	}

}
