package Placement_week1;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ANITGUY1 {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t=s.nextInt();
		while(t-->0) {
			int k=s.nextInt();
			int n=s.nextInt();
			HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
			int[] arr=new int[n];
			for(int i=0;i<n;i++)
			{
				arr[i]=s.nextInt();
				map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
			}
			int count=0;
			for(int i=0;i<n;i++) {
				if(map.containsKey(arr[i]) && map.get(arr[i])>0) {
					int req=k-arr[i];
					if(req==arr[i]) {
						if(map.get(arr[i])>1) {
							count++;
							map.put(arr[i],map.get(arr[i])-2);
						}
					}
					else {
					if(map.containsKey(req) && map.get(req)>0) {
						count++;
						map.put(req,map.get(req)-1);
						map.put(arr[i],map.get(arr[i])-1);
					}
					}
				}
			}
			out.println(count);
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

}
