package January_long;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FAIRELCT {

	public static void main(String[] args) {
		try {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t=s.nextInt();
		while(t-->0) {
			int n=s.nextInt();
			int m=s.nextInt();
			int[] a=new int[n];
			int[] b=new int[m];
			int s1=0;
			int s2=0;
			for(int i=0;i<n;i++) {
				a[i]=s.nextInt();
				s1+=a[i];
			}
			for(int i=0;i<m;i++) {
				b[i]=s.nextInt();
				s2+=b[i];
			}
			if(s1>s2) {
				out.println(0);
				
			}
			else {
				int diff=s2-s1;
				Arrays.sort(a);
				Arrays.sort(b);
				int count=0;
				int i=0;
				int j=m-1;
				while(diff>=0 && i<n && j>=0) {
					s1=s1-a[i]+b[j];
					s2=s2-b[j]+a[i];
					i++;
					j--;
					diff=s2-s1;
					count++;
				}
				if(diff>=0) {
					out.println(-1);
				}
				else {
				out.println(count);
				}
			}
		}
		
		
		out.close();
		}catch(Exception e) {
			System.out.println(e);
			return ;
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

}
