package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Search_function {
	// class to store the item attributes
	public static class item{
		String name;
		int price;
		int discount;
		public item(String name, int price, int discount) {
			this.name=name;
			this.price=price;
			this.discount=discount;
		}
	}

	public static void main(String[] args) {
		//scanner class to take the input from the user
		Scanner s=new Scanner(System.in);
		// list of items available on the shopping website
		ArrayList<item> list=new ArrayList<item>();

			list.add(new item("A",10,10));
			list.add(new item("B",20,30));
			list.add(new item("C",30,20));
			list.add(new item("D",40,10));
			list.add(new item("E",50,10));
			list.add(new item("F",60,20));
			list.add(new item("G",70,10));
			list.add(new item("H",80,50));
			list.add(new item("I",90,30));
			list.add(new item("J",100,30));
			
			// name of the item user wants to know the price of
			String input=s.next();
			if(search(input,list)==null) { // if item is not available on the site
				System.out.println("Item not found");
			}
			else
			{   // if found, get the actual price user has to pay and print it.
				item item=search(input,list);
				int Quantity=s.nextInt();
				double total_price=(double)Quantity*item.price*1.0*(1-(double)item.discount/100*1.0);
				System.out.println(total_price);
			}
			
	}
	// function to search for the required item in the list of items available
	public static item search(String name, ArrayList<item> list) {
		for(item item:list) {
			if(item.equals(name))
				return item;
		}
		return null;
	}

}

