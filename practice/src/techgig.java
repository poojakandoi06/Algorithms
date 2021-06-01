import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class techgig {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int n=s.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=s.nextInt();
		int t=s.nextInt();
		int f=-1;
		int last=-1;
		int l=0;
		int r=n-1;
		while(l<=r) {
			int mid=(l+r)/2;
			if(arr[mid]>t) {
				r=mid-1;
			}
			else if(arr[mid]<t) {
				l=mid+1;
			}
			else {
				f=mid;
				r=mid-1;
			}
		}
		l=0;
		r=n-1;
		while(l<=r) {
			int mid=(l+r)/2;
			if(arr[mid]>t) {
				r=mid-1;
			}
			else if(arr[mid]<t) {
				l=mid+1;
			}
			else {
				last=mid;
				System.out.print(last);
				l=mid+1;
			}
		}
		System.out.println(f+" "+last);
		
		
			
		
		out.close();
	}
	public static long func2(long n, long p) {
		PriorityQueue<pair> pq=new PriorityQueue<pair>((a,b)->a.compareTo(b));
		p=p-2;
		pq.add(new pair(2,n-1,n-2));
		long res=n;
		while(p-->0) {
			pair poll=pq.poll();
			long mid=(poll.s+poll.e)/2;
			res=mid;
			System.out.println(res+"sdfgbh");
			pq.add(new pair(poll.s,mid-1,mid-1-poll.s+1));
			pq.add(new pair(mid+1,poll.e,poll.e-mid));
		}
		return res;
		
	}
	public static class pair implements Comparable<pair>{
		long s;
		long e;
		long d;
		public pair(long s, long e, long d) {
			this.s=s;
			this.e=e;
			this.d=d;
		}
		public int compareTo(pair p) {
			if(p.d==this.d) {
				if(p.s<=this.s)
					return 1;
				else
					return -1;
			}
			else if(p.d>this.d)
				return 1;
			else
				return -1;
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
