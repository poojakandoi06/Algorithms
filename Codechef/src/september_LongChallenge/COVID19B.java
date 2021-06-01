package september_LongChallenge;

import java.util.Arrays;
import java.util.Scanner;

public class COVID19B {
	public static void union(int i, int j, int[] parent, int[] s) {
		int p=find(i,parent);
		int q=find(j,parent);
		if(p==q)
			return;
		if(s[p]>=s[q]) {
			parent[q]=p;
			s[p]+=s[q];
		}
		else {
			parent[p]=q;
			s[q]+=s[p];
		}
	}
	public static int find(int i, int[] parent) {
		while(i!=parent[i])
			i=parent[i];
		return i;
	}

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			int t=s.nextInt();
			while(t-->0) {
				int n=s.nextInt();
				int[] arr=new int[n];
				for(int i=0;i<n;i++)
					arr[i]=s.nextInt();
				int[] parent=new int[n];
				int[] size=new int[n];
				Arrays.fill(size, 1);
				for(int i=0;i<n;i++)
					parent[i]=i;
				for(int i=0;i<n;i++) {
					for(int j=i+1;j<n;j++) {
						if(arr[i]!=arr[j]) {
						double val=(j-i)/(1.0*(arr[i]-arr[j]));
						System.out.println(val);
						if(val>=0) {
							union(i,j,parent,size);
						}
						}
					}
				}
				int min=Integer.MAX_VALUE;
				int max=Integer.MIN_VALUE;
				for(int i=0;i<n;i++) {
					if(parent[i]==i) {
					max=Math.max(max, size[i]);
					min=Math.min(min, size[i]);
					}
				}
			System.out.println(min+" "+max);
			}

		} catch (Exception e) {
			System.out.println(e);
			return;
		}


	}

}
