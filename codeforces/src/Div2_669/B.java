package Div2_669;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B {
	public static int gcd(int a, int b) {
		if(b==0)
			return a;
		return gcd(b,a%b);
	}

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t=s.nextInt();
		while(t-->0) {
			int n=s.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++)
				arr[i]=s.nextInt();
			Arrays.sort(arr);
		    int gcd=arr[n-1];
		    arr[n-1]=0;
		    ArrayList<Integer> list=new ArrayList<Integer>();
		    list.add(gcd);
		    for(int i=1;i<n;i++) {
		    	int max=Integer.MIN_VALUE;
		    	int idx=-1;
		    for(int j=0;j<n;j++) {
		    	if(arr[j]==0)
		    		continue;
		    	int val=gcd(arr[j],gcd);
		    	if(val>max) {
		    		max=val;
		    		idx=j;
		    	}
		    	
		    }
		    list.add(arr[idx]);
		    arr[idx]=0;
		    gcd=max;
		    }
		    StringBuilder sb=new StringBuilder();
		    for(int i=0;i<n;i++) {
		    	sb.append(list.get(i)+" ");
		    }
		    out.println(sb.toString());
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
