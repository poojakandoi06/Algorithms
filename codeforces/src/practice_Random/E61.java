package practice_Random;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class E61 {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int n=s.nextInt();
		int[] arr=new int[n];
		int[] inc=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=s.nextInt();
			inc[i]=arr[i];
		}
		Arrays.sort(inc);
		
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<n;i++) {
			map.put(inc[i],i);
		}
		
		int[] bit1=new int[n+1];
		int[] bit2=new int[n+1];
		long count=0;
		TreeMap<Integer,Long> left=new TreeMap<>();
		TreeMap<Integer,Long> right=new TreeMap<>();
		for(int i=0;i<n;i++) {
			int index=(n-1-map.get(arr[i]))+1;
			update(bit1,index,1);
			left.put(i,get(bit1,index-1));
		}
		for(int i=n-1;i>=0;i--) {
			int index=map.get(arr[i])+1;
			update(bit2,index,1);
			right.put(i,get(bit2,index-1));
		}
		for(int i=0;i<n;i++) {
			count+=(left.get(i)*right.get(i));
		}
		out.println(count);
		
		
		
		out.close();
	}
	public static void update(int[] bit, int i, int val) {
		while (i < bit.length) {
			bit[i] += val;
			i += i & -i;
		}
	}

	public static long get(int[] bit, int i) {
		long sum = 0;
		while (i > 0) {
			sum += bit[i];
			i -= i & -i;
		}
		return sum;
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

}
