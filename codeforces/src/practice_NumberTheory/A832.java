package practice_NumberTheory;

import java.util.Scanner;

public class A832 {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			long n=s.nextLong();
			long k=s.nextLong();
			long val=n/k;
			if(val%2!=0) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}

		} catch (Exception e) {
			System.out.println(e);
			return;
		}

	}

}
