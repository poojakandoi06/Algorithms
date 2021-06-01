package september_LongChallenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class TREE2 {
	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			int t=s.nextInt();
			while(t-->0) {
				int n=s.nextInt();
				long[] arr=new long[n];
				for(int i=0;i<n;i++) {
					arr[i]=s.nextLong();
				}
				int count=0;
				Arrays.sort(arr);
				for(int i=0;i<arr.length-1;i++) {
					if(arr[i]!=arr[i+1])
						count++;
				}
				if(arr[0]!=0)
				System.out.println(count+1);
				else
				System.out.println(count);
			}
			

		} catch (Exception e) {
			System.out.println(e);
			return;
		}

	}

}
