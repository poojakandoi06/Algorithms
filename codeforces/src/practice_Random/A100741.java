package practice_Random;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A100741 {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int n=s.nextInt();
		int m=s.nextInt();
		int[] arr=new int[n];
		long[][] bit=new long[n+1][m];
		for(int i=0;i<n;i++) {
			arr[i]=s.nextInt();
			int index=arr[i]%m;
			update(bit,index,i+1,arr[i]);
		}
		int q=s.nextInt();
		while(q-->0) {
			String[] str=s.nextLine().split(" ");
			//System.out.println(str.length);
			if(str.length==3) {
				int index=Integer.valueOf(str[1])-1;
				int val=Integer.valueOf(str[2]);
				int mm=arr[index]%m;
				if(str[0].equals("+")) {
					update(bit,mm,index+1,-arr[index]);
					arr[index]+=val;
					mm=arr[index]%m;
					update(bit,mm,index+1,arr[index]);
				}
				else {
					update(bit,mm,index+1,-arr[index]);
					if(arr[index]-val>=0)
					arr[index]-=val;
					mm=arr[index]%m;
					update(bit,mm,index+1,arr[index]);
				}
				System.out.println(arr[index]);
			}
			else {
				int l=Integer.valueOf(str[1])-1;
				int r=Integer.valueOf(str[2])-1;
				int mod=Integer.valueOf(str[3]);
				//System.out.println(l+" "+r+" "+mod);
				mod=mod%m;
				long val=get(bit,r+1,mod)-get(bit,l,mod);
				System.out.println(val);
				
			}
		}
		
		
		
		
		out.close();
	}
	public static long get(long[][] bit, int i, int m) {
		long count=0;
		while(i>0) {
			count+=bit[i][m];
			i-=i&-i;
		}
		return count;
	}
	public static void update(long[][] bit,int m, int i, long val) {
		while(i<bit.length) {
			bit[i][m]+=val;
			i+=i&-i;
		}
	}
	
	public static PrintWriter out;
	
	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		
		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
		
	}
	public static class FastScanner {
		BufferedReader br;
		StringTokenizer st;
		
		public FastScanner(String s) {
			try {
				br = new BufferedReader(new FileReader(s));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String nextToken() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(nextToken());
		}
		
		long nextLong() {
			return Long.parseLong(nextToken());
		}
		
		double nextDouble() {
			return Double.parseDouble(nextToken());
		}

	}

}
