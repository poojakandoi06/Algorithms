package practice_NumberTheory;

import java.util.Arrays;
import java.util.Scanner;

public class B841 {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			int n=s.nextInt();
			int[] arr=new int[n];
			int odd=0;
			for(int i=0;i<n;i++) {
				arr[i]=s.nextInt();
				if(arr[i]%2==1)
					odd++;
			}
			int sum=Arrays.stream(arr).sum();
			if(sum%2==1) {
				System.out.println("First");
			}
			else {
				if(odd>0)
					System.out.println("First");
				else
					System.out.println("Second");
			}

		} catch (Exception e) {
			System.out.println(e);
			return;
		}


	}

}
