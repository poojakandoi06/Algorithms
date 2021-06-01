package Div2_666;

import java.util.Scanner;

public class C {
	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			int n=s.nextInt();
			long[] arr=new long[n];
			for(int i=0;i<n;i++)
				arr[i]=s.nextLong();
			System.out.println(1+" "+(n));
			for(int i=0;i<n;i++) {
				System.out.print(-1*arr[i]*n+" ");
			}
			System.out.println();
			if(n==1) {
				System.out.println(1+" "+1);
				System.out.println(0);
				System.out.println(1+" "+1);
				System.out.println(0);
				
			}
			else {
			System.out.println(1+" "+(n-1));
			for(int i=0;i<n-1;i++) {
				System.out.print(arr[i]*(n-1)+" ");
			}
			System.out.println();
			System.out.println(n+" "+n);
			System.out.println(arr[n-1]*(n-1));
			}

		} catch (Exception e) {
			System.out.println(e);
			return;
		}


	}
}
