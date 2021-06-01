package practice_NumberTheory;

import java.util.Scanner;

public class A1270 {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			int t=s.nextInt();
			while(t-->0) {
				int n=s.nextInt();
				int k1=s.nextInt();
				int k2=s.nextInt();
				int max1=0;
				for(int i=0;i<k1;i++) {
					int a=s.nextInt();
					max1=Math.max(max1, a);
				}
				int max2=0;
				for(int i=0;i<k2;i++) {
					int b=s.nextInt();
					max2=Math.max(max2, b);
				}
				if(max1>max2) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}

		} catch (Exception e) {
			System.out.println(e);
			return;
		}


	}

}
