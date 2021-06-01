package giftList;

import java.util.Scanner;

public class Form {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		while(true) {
			// Initialising an empty wishlist
			WishList wishlist=new WishList();
			System.out.println("Do you want to add an item to your Giftlist?");
			if(s.next().equals("yes")) {
				System.out.println("Enter the name of the gift");
				String name=s.next();
				while(name.equals(" "))
				{
					System.out.println("Name can't be empty");
					name=s.next();
				}
				System.out.println("Enter the description");
				String desc=s.next();
				while(desc.equals(" "))
				{
					System.out.println("Name can't be empty");
					desc=s.next();
				}
				System.out.println("Enter the seller information");
				String seller=s.next();
				while(seller.equals(" "))
				{
					System.out.println("Name can't be empty");
					seller=s.next();
				}
				System.out.println("Enter the recipient's name");
				String recipient=s.next();
				while(recipient.equals(" "))
				{
					System.out.println("Name can't be empty");
					recipient=s.next();
				}
				System.out.println("Enter the price");
				int price=s.nextInt();
				
				//Add item to the wishlist
				wishlist.add_item_to_wishlist(new Item(name,desc,seller,recipient,price));
				
				// Get total price of the items
				int total_price=wishlist.get_Total_price();
				
				// Print total price of the items
				System.out.println(total_price);
			}
		}

	}

}
