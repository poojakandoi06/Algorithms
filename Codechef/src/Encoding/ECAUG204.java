package Encoding;

import java.util.HashSet;
import java.util.Scanner;

public class ECAUG204 {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			int t=s.nextInt();
			while(t-->0) {
				int n=s.nextInt();
				int[] arr=new int[n];
				HashSet<Integer> set=new HashSet<>();
				boolean dup=false;
				for(int i=0;i<n;i++) {
					arr[i]=s.nextInt();
					if(set.contains(arr[i]) && dup==false) {
						dup=true;
					}
					set.add(arr[i]);
				}
				if(dup==true) {
					System.out.println("No");
				}
				else {
					System.out.println("Yes");
				}
			}

		} catch (Exception e) {
			System.out.println(e);
			return;
		}


	}

}
