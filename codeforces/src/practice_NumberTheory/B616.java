package practice_NumberTheory;

import java.util.Scanner;

public class B616 {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			int n=s.nextInt();
			int m=s.nextInt();
			int max=0;
			for(int i=0;i<n;i++) {
				int min=Integer.MAX_VALUE;
				for(int j=0;j<m;j++) {
					int a=s.nextInt();
					min=Math.min(min, a);
				}
				max=Math.max(max, min);
				
			}
			System.out.println(max);

		} catch (Exception e) {
			System.out.println(e);
			return;
		}


	}

}
