package Educational_99;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t=s.nextInt();
		while(t-->0) {
			int n=s.nextInt();
			int x=s.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=s.nextInt();
			}
			int found=0;
			int count=0;
			if(check(arr)) {
				found=1;
			}
			for(int i=0;i<n && found==0;i++) {
				if(arr[i]>x) {
					int temp=arr[i];
					arr[i]=x;
					x=temp;
					count++;
					if(check(arr)) {
						found=1;
						break;
					}
					
				}
			}
			if(found==1)
			out.println(count);
			else
			out.println(-1);	
		}
		
		
		out.close();
	}
	public static boolean check(int[] arr) {
		for(int i=1;i<arr.length;i++) {
			if(arr[i]<arr[i-1])
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

}
