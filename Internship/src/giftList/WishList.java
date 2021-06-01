package giftList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WishList {

	private ArrayList<Item> items; // list to store all the gift items information
	private int total_price; // total price of all the items in the list

	public WishList() {
		this.items = new ArrayList<Item>();
	}

	// function to add the item into list, function also verifies for the duplicate
	// item and ask the user if he wants to add the duplicate item
	public void add_item_to_wishlist(Item item) {

		if (isDuplicate(item)) {
			System.out.println("The Item is already added to the list. Do you want to add it again?");
			String reply = ask(new Scanner(System.in));
			if (reply.equals("yes")) {
				this.items.add(item);
			} else
				return;
		}
	}
	
	// Search for a particular item by providing all the information
	public boolean search(Item item) {
		return isDuplicate(item);
	}

	// Search for the item by name of the item only
	public boolean search_by_name(String name) {
		for (Item item : items) {
			if (item.item_Name.equals(name)) {
				return true;
			}

		}
		return false;
	}

	// function to check if duplicate item is being asked to add to the list.
	public boolean isDuplicate(Item item) {
		if (items.contains(item))
			return true;
		else
			return false;
	}

	// function to take user input
	public String ask(Scanner s) {
		return s.next();
	}

	// delete an item from the list
	public void delete_item(Item item) {
		if (items.contains(item))
			items.remove(item);
	}

	// function which provides a sorted list of items according to the item names
	public ArrayList<Item> sorted_Items() {
		ArrayList<Item> sorted_list = new ArrayList<>(items);
		Collections.sort(sorted_list, (a, b) -> a.item_Name.compareTo(b.item_Name));
		return sorted_list;
	}

	// Get the total price of all the items in the list
	public int get_Total_price() {
		int total = 0;
		for (Item item : items) {
			total = item.price;
		}
		return total;
	}

}
