package practice_Random;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B1304 {
	public static String func(String str) {
		StringBuilder sb=new StringBuilder();
		for(char c:str.toCharArray()) {
			sb.insert(0, c);
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
			int n=s.nextInt();
			int m=s.nextInt();
			String[] arr=new String[n];
	        String[] reverse=new String[n];
	        for(int i=0;i<n;i++) {
	        	arr[i]=s.next();
	        	reverse[i]=func(arr[i]);
	        }
	        int[] matchIndex=new int[n];
	        Arrays.fill(matchIndex, -1);
	        int center=-1;
	        for(int i=0;i<n;i++) {
	        	if(matchIndex[i]==-1) {
	        		for(int j=i+1;j<n;j++) {
	        			if(arr[i].equals(reverse[j])) {
	        				matchIndex[i]=j;
	        				matchIndex[j]=i;
	        			}
	        		}
	        		if(matchIndex[i]==-1 && arr[i].equals(reverse[i])) {
	        			center=i;
	        		}
	        	}
	        }
	        String res="";
	        if(center!=-1) {
	        	res=res+arr[center];
	        }
	        for(int i=0;i<n;i++) {
	        	if(matchIndex[i]>i) {
	        		res=arr[i]+res+reverse[i];
	        	}
	        }
	        System.out.println(res.length());
	        System.out.println(res);
			
		
		
		
		out.close();
	}
	public static boolean palin(String str) {
		for(int i=0;i<str.length()/2;i++) {
			if(str.charAt(i)!=str.charAt(str.length()-1-i))
				return false;
		}
		return true;
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
