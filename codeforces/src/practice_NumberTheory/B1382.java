package practice_NumberTheory;

import java.util.Scanner;

public class B1382 {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			int t=s.nextInt();
			while(t-->0) {
				int n=s.nextInt();
				int[] arr=new int[n];
				for(int i=0;i<n;i++) {
					arr[i]=s.nextInt();
				}
				arr[n-1]=2;
				int i=0;
				for(i=0;i<n;i++) {
					if(arr[i]>1)
						break;
				}
				if(i%2==0) {
					System.out.println("First");
				}
				else {
					System.out.println("Second");
				}
			}

		} catch (Exception e) {
			System.out.println(e);
			return;
		}


	}

}
