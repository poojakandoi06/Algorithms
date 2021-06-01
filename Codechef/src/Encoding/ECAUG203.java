package Encoding;

import java.util.Scanner;

public class ECAUG203 {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			int t=s.nextInt();
			while(t-->0) {
				long n=s.nextLong();
				int count=0;
				for(int i=1;i<=n;i++) {
					int val=i/2;
					if(val==0 || i%2==1)
						continue;
					double root=Math.sqrt(val);
					if(root==(int)root)
						count++;
					
				}
				System.out.println(count*2);
				
			}

		} catch (Exception e) {
			System.out.println(e);
			return;
		}


	}
	

}
