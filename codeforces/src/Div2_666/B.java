package Div2_666;

import java.util.Arrays;
import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		try {
			Scanner s=new Scanner(System.in);
			int n=s.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++)
				arr[i]=s.nextInt();
			Arrays.sort(arr);
			long max=Long.MAX_VALUE;
			long p=1;
			while(true) {
				long sum=0;
				for(int i=0;i<n;i++) {
					sum+=Math.abs((Math.pow(p, i)-arr[i]));
				}
				if(sum>=max)
					break;
				max=sum;
				p++;
			}
			
			System.out.println(max);
			
			
		}catch(Exception e) {
			System.out.println(e);
			return;
		}


	}
	public static long check(int mid, int[] arr,int sum) {
		long res=0;
		if(mid==1) {
			return Math.abs(arr.length-sum);
		}
		long num=(long) Math.pow(mid, arr.length);
		long deno=mid-1;
		res=Math.abs(num/deno-sum-arr.length);
		return res;
		
	}
}
