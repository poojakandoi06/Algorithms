package Div2_684;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class C {

	public static void main(String[] args) {
		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t=s.nextInt();
		while(t-->0) {
			int n=s.nextInt();
			int m=s.nextInt();
			int[][] arr=new int[n][m];
			for(int i=0;i<n;i++) {
				String str=s.next();
				for(int j=0;j<str.length();j++) {
					arr[i][j]=(str.charAt(i)-'0');
				}
			}
			int i=0;
			int j=0;
			ArrayList<int[]> list=new ArrayList<int[]>();
			int count=0;
			while(i<n && j<m) {
				if(arr[i][j]==0) {
					j++;
				}
				else {
					arr[i][j]=0;
					count++;
					if(i!=n-1) {
					if(j==0) {
						int a=arr[i+1][j];
						int b=arr[i+1][j+1];
						list.add(new int[] {i,j,i+1,j,i+1,j+1});
						arr[i][j]=0;
						if(a==1 && b==1) {
							arr[i+1][j]=0;
							arr[i+1][j+1]=0;
							j++;
						}
						else if(a==0 && b==1) {
							arr[i+1][j+1]=0;
							arr[i+1][j]=1;
							j++;
						}
						else {
							arr[i+1][j]=0;
							arr[i+1][j+1]=1;
							j++;
						}
					}
					else {
						int a=arr[i+1][j-1];
						int b=arr[i+1][j];
						list.add(new int[] {i,j,i+1,j-1,i+1,j});
						arr[i][j]=0;
						if(a==1 && b==1) {
							arr[i+1][j-1]=0;
							arr[i+1][j]=0;
							j++;
						}
						else if(a==0 && b==1) {
							arr[i+1][j-1]=1;
							arr[i+1][j]=0;
							j++;
						}
						else {
							arr[i+1][j-1]=0;
							arr[i+1][j]=1;
							j++;
						}
					}}
					else {
						if(j==0) {
							int a=arr[i-1][j];
							int b=arr[i-1][j+1];
							list.add(new int[] {i,j,i-1,j,i-1,j+1});
							arr[i][j]=0;
							if(a==1 && b==1) {
								arr[i-1][j]=0;
								arr[i-1][j+1]=0;
								j++;
							}
							else if(a==0 && b==1) {
								arr[i-1][j+1]=0;
								arr[i-1][j]=1;
								i--;
							}
							else {
								arr[i-1][j]=0;
								arr[i-1][j+1]=1;
								i--;
								j++;
							}
						}
						else {
							int a=arr[i-1][j-1];
							int b=arr[i-1][j];
							list.add(new int[] {i,j,i-1,j-1,i-1,j});
							arr[i][j]=0;
							if(a==1 && b==1) {
								arr[i-1][j-1]=0;
								arr[i-1][j]=0;
								j++;
							}
							else if(a==0 && b==1) {
								arr[i-1][j-1]=1;
								arr[i-1][j]=0;
								i--;
								j--;
							}
							else {
								arr[i-1][j-1]=0;
								arr[i-1][j]=1;
								i--;
								
							}
						}
					}
				}
				if(j==m) {
					i++;
					j=0;
				}
				
			}
			System.out.println(count);
			for(int k=0;k<list.size();k++) {
				for(int d=0;d<6;d++) {
					System.out.print(list.get(k)[d]+" ");
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
