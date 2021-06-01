package september_LongChallenge;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FINXOR {
    static int[] tt;
	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t=s.nextInt();
		while(t-->0) {
			int n=s.nextInt();
		    tt=new int[] {1,2,3,4};
			int[] arr=new int[20];
			int ss=query1((int)Math.pow(2, 20), s);
			int sum=ss-n*(int)Math.pow(2, 20);
			//System.out.println(sum);
			for(int i=19;i>=1;i--) {
				int val=query1((int)Math.pow(2, i), s);
				val=sum-val;
				int num=Math.abs(val)/(int)Math.pow(2, i);
				// if val is neg that mean zero zyada h else one zyada h
				//System.out.println((val)/(int)Math.pow(2, i));
				if(val<0) {
				int zero=num+(n-num)/2;
				int one=(n-num)/2;
				arr[i]=one;
				}
				else {
					int one=num+(n-num)/2;
					int zero=(n-num)/2;
					arr[i]=one;
				}
			}
//			for(int i=0;i<=19;i++) {
//				System.out.print(arr[i]+" ");
//			}
//			System.out.println();
			int ts=0;
			for(int i=1;i<=19;i++) {
				ts+=(arr[i]*(int)Math.pow(2, i));
			}
			//System.out.println(ts);
			arr[0]=sum-ts;
//			for(int i=0;i<=19;i++) {
//				System.out.print(arr[i]+" ");
//			}
//			for(int i=0;i<=19;i++) {
//				System.out.println(arr[i]+" ");
//			}
			int xor=0;
			for(int i=0;i<=19;i++) {
				if(arr[i]%2==1) {
					xor=xor+(int)Math.pow(2, i);
				}
			}
			boolean res=query2(xor, s);
			if(!res)
				break;
			else
				continue;
			
			
			
		}
		out.flush();
		out.close();
	}
	public static int query1(int k, MyScanner s) {
		System.out.println(1+" "+k);
		int res=s.nextInt();
		return res;
//		int res=0;
//		for(int i=0;i<tt.length;i++) {
//			res+=(tt[i]^k);
//		}
//		return res;
	}
	public static boolean query2(int x, MyScanner s) {
		System.out.println(2+" "+x);
		int res=s.nextInt();
		if(res==1)
			return true;
		else
			return false;
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
