package Encoding;

import java.util.Scanner;

public class ECAUG202 {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			int t=s.nextInt();
			while(t-->0) {
				int n=s.nextInt();
				int even=0;
				for(int i=0;i<n;i++) {
					int a=s.nextInt();
					if(a%2==0)
						even+=a;
				}
				System.out.println(even);
			}

		} catch (Exception e) {
			System.out.println(e);
			return;
		}


	}

}
