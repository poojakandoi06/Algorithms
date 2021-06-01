package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
	static int[] arr;
	public static void main(String[] args) {
		FastScanner s = new FastScanner();
			int n=s.nextInt();
			 arr=new int[n];
			for(int i=0;i<n;i++)
				arr[i]=s.nextInt();
			long res=dfs(0,n-1);
			System.out.println(res);

	}
	public static int dfs(int i, int j) {
		if(i>j)
			return 0;
		if(i==j)
			return 1;
		
		int min=j-i+1;
		int minval=Integer.MAX_VALUE;
		for(int k=i;k<=j;k++) {
			minval=Math.min(minval, arr[k]);
		}
		for(int k=i;k<=j;k++)
			arr[k]-=minval;
		int curr=minval;
		int last=i;
		for(int k=i;k<=j;k++) {
			if(arr[k]==0) {
				curr+=dfs(last,k-1);
				last=k+1;
			}
		}
		curr+=dfs(last,j);
		min=Math.min(min, curr);
		return min;
	}

}
