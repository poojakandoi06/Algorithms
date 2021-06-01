package Encoding;

import java.util.Arrays;
import java.util.Scanner;

public class ECAUG201 {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			int t=s.nextInt();
			while(t-->0) {
				int n=s.nextInt();
				int m=s.nextInt();
				int[] parent=new int[n];
				int[] size=new int[n];
				Arrays.fill(size, 1);
				for(int i=0;i<n;i++)
					parent[i]=i;
				for(int i=0;i<m;i++) {
					int a=s.nextInt();
					int b=s.nextInt();
					union(a,b,parent,size);
				}
				int count=0;
				for(int i=0;i<n;i++) {
					if(parent[i]==i)
						count++;
				}
				System.out.println(count);
			}

		} catch (Exception e) {
			System.out.println(e);
			return;
		}


	}
	public static void union(int a, int b, int[] parent, int[] size) {
		int p=find(a,parent);
		int q=find(b,parent);
		if(p==q)
			return;
		if(size[p]>=size[q]) {
			parent[q]=p;
			size[p]+=size[q];
		}
		else {
			parent[p]=q;
			size[q]+=size[p];
			}
	}
	public static int find(int a, int[] parent) {
		while(parent[a]!=a)
			a=parent[a];
		return a;
	}

}
