package dpandgreedy;

import java.util.*;

public class _70BillBoard {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = scn.nextInt();
		int heightboard = tallestBillboard(arr);
		System.out.println(heightboard);
	}

	public static int tallestBillboard(int[] rods) {
		int n = rods.length;
		int sum = 0 ;
		for(int i = 0 ; i < rods.length; i++) {
			sum += rods[i];
		}
		int[][] dp = new int[n  +1][(2 * sum) + 1];
		
		return 0;
	}
}
