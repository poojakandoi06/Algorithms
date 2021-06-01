package Room_Decor;

import Room_Decor.*;
public class Room {
	
	int door_area;  // area covered by the door
	int windows_area;   // area covered by 2 windows
	int bookshelf_area; // area covered by the bookshelf
	dimension dimension; // dimension of the room
	
	public Room(int doorArea, int windowArea, int bookshelfArea, dimension dimension) {
		this.door_area=doorArea;
		this.windows_area=windowArea;
		this.bookshelf_area=bookshelfArea;
		this.dimension=dimension;
	}
	
	
	//function to get the area of the floor
	public int get_floor_area() {
		return dimension.length*dimension.width;
	}
	//function to get the area of all the 4 walls combined
	public int get_wall_area() {
		int total_area=2*(dimension.length*dimension.width)*dimension.height;
		int occupied_area=door_area+windows_area+bookshelf_area;
		int required_area=total_area-occupied_area;
		return required_area;
	}
	
	// function to get the cost of paining the walls
	public int get_cost_to_paint(int cost_per_square_feet) {
		return cost_per_square_feet*get_wall_area();
	}
	// function to get the cost of installing a carpet in the room
	public int get_cost_of_installing_carpet(int cost_per_square_feet) {
		return cost_per_square_feet*get_floor_area();
	}

}
