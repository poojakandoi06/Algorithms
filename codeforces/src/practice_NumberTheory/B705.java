package practice_NumberTheory;

import java.util.Scanner;

public class B705 {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			int n=s.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=s.nextInt();
			}
			

		} catch (Exception e) {
			System.out.println(e);
			return;
		}


	}

}
