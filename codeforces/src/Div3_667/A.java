package Div3_667;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			int t=s.nextInt();
			while(t-->0) {
				int a=s.nextInt();
				int b=s.nextInt();
				int diff=Math.abs(a-b);
				int moves=diff/10;
				if(diff%10!=0) {
					moves++;
				}
				System.out.println(moves);
			}

		} catch (Exception e) {
			System.out.println(e);
			return;
		}


	}

}
