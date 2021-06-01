package Educational_round_95;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t=s.nextInt();
		while(t-->0) {
			int n=s.nextInt();
			int[] arr=new int[n];
			int[] lock=new int[n];
			long sum=0;
			for(int i=0;i<n;i++)
			{
				arr[i]=s.nextInt();
				sum+=arr[i];
			}
			for(int i=0;i<n;i++)
				lock[i]=s.nextInt();
			if(sum<0) {
				for(int i=0;i<n;i++) {
					System.out.print(arr[i]+" ");
				}
				System.out.println();
			}
			else {
				ArrayList<Integer> list=new ArrayList<>();
				for(int i=0;i<n;i++) {
					if(lock[i]==0)
						list.add(arr[i]);
				}
				int id=0;
				Collections.sort(list);
				for(int i=n-1;i>=0;i--) {
					if(lock[i]==0) {
						arr[i]=list.get(id++);
					}
				}
				for(int i=0;i<n;i++) {
					System.out.print(arr[i]+" ");
				}
				System.out.println();
			}
		}
		
		out.close();
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
