package practice_NumberTheory;

import java.util.Scanner;

public class B1373 {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			int t=s.nextInt();
			while(t-->0)
			{
				String str=s.next();
				int one=0;
				for(char c:str.toCharArray()) {
					one+=(int)(c-'0');
				}
				int zero=str.length()-one;
				int moves=zero>=one?one:zero;
				if(moves%2==0) {
					System.out.println("NET");
				}
				else {
					System.out.println("DA");
				}
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
			return;
		}


	}

}
