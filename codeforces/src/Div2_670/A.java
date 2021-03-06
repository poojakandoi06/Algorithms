package Div2_670;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class A {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t=s.nextInt();
		while(t-->0) {
			int n=s.nextInt();
			HashMap<Integer,Integer> map=new HashMap<>();
			for(int i=0;i<n;i++) {
				int x=s.nextInt();
				map.put(x,map.getOrDefault(x, 0)+1);
			}
			
			int one=-1;
			for(int i=0;i<n;i++) {
				if(!map.containsKey(i)) {
					one=i;
					break;
				}
				else {
					map.put(i,map.get(i)-1);
					if(map.get(i)==0)
						map.remove(i);
					}
			}
			if(one==-1)
				one=n;
			int two=-1;
			for(int i=0;i<n;i++) {
				if(!map.containsKey(i)) {
					two=i;
					break;
				}
				else {
					map.put(i,map.get(i)-1);
					if(map.get(i)==0)
						map.remove(i);
					}
			}
			if(two==-1)
				two=n;
			System.out.println(Math.max(one,one+two));
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
