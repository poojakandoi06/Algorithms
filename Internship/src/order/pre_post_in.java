package order;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class pre_post_in {

	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<>();
		File file=new File("txtfile");
		try {
		Scanner s = new Scanner(file);
		    while (s.hasNext()) {
		        arr.add(s.nextLine());
		    }
		}
		catch(Exception e) {
			System.out.println(e);
		}

		System.out.println("Preorder: ");
		System.out.println();
		preorder(arr, 0, 40);
		System.out.println();
		
		System.out.println("PostOrder: ");
		System.out.println();
		postorder(arr, 0, 40);
		System.out.println();
		
		System.out.println("Inorder: ");
		System.out.println();
		inorder(arr, 0, 40);
		System.out.println();

	}

	public static void preorder(ArrayList<String> arr, int left, int right) {
		if (left > right)
			return;
		int mid = (left + right) / 2;
		System.out.println(arr.get(mid));
		preorder(arr, left, mid - 1);
		preorder(arr, mid + 1, right);
	}

	public static void postorder(ArrayList<String> arr, int left, int right) {
		if (left > right)
			return;
		int mid = (left + right) / 2;
		postorder(arr, left, mid - 1);
		postorder(arr, mid + 1, right);
		System.out.println(arr.get(mid));
	}

	public static void inorder(ArrayList<String> arr, int left, int right) {
		if (left > right)
			return;
		int mid = (left + right) / 2;
		inorder(arr, left, mid - 1);
		System.out.println(arr.get(mid));
		inorder(arr, mid + 1, right);
	}

}
