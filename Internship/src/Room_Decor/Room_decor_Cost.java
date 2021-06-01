package Room_Decor;

import java.util.Scanner;

public class Room_decor_Cost {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the length, width and height of the room");
		int length = s.nextInt();
		int width = s.nextInt();
		int height = s.nextInt();
		dimension dimension = new dimension(length, width, height);

		System.out.println("Enter the dimention of the door");
		int d_length = s.nextInt();
		int d_width = s.nextInt();
		int door_area = d_length * d_width;

		System.out.println("Enter the dimention of the window");
		int w_length = s.nextInt();
		int w_width = s.nextInt();
		int window_area = 2 * w_length * w_width;

		System.out.println("Enter the dimention of the bookshelf");
		int b_length = s.nextInt();
		int b_width = s.nextInt();
		int bookshelf_area = b_length * b_width;

		Room room = new Room(door_area, window_area, bookshelf_area, dimension);

		System.out.println("Enter the cost to paint the wall per square feet");
		int cost_to_paint = s.nextInt();
		int total_cost = room.get_cost_to_paint(cost_to_paint);

		System.out.println("Total cost to paint the walls of the room: " + total_cost);

		System.out.println("Enter the cost to install the carpet per square feet");
		int cost_to_install_the_carpet = s.nextInt();
		int total_cost_Installing_carpet = room.get_cost_of_installing_carpet(cost_to_install_the_carpet);

		System.out.println("Total cost to install the carpet: " + total_cost_Installing_carpet);

	}

}
