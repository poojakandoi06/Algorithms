package Educational_round_88;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0)
		{
			int n=s.nextInt();
			int m=s.nextInt();
			int k=s.nextInt();
			int card=n/k;
			int maxjoker=Math.min(card, m);
			int remain=m-maxjoker;
			if(remain==0)
				System.out.println(maxjoker);
			else {
				int secmax=(remain%(k-1)==0)?remain/(k-1):remain/(k-1)+1;
				System.out.println((int)(maxjoker-secmax));
			}
		}

	}

}
