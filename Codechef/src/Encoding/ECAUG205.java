package Encoding;

import java.util.Arrays;
import java.util.Scanner;

public class ECAUG205 {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			int t=s.nextInt();
			while(t-->0) {
				int n=s.nextInt();
				int k=s.nextInt();
				int[] arr=new int[n];
				for(int i=0;i<n;i++) {
					arr[i]=s.nextInt();
				}
				int ans=0;
				int l=1;
				int r=Arrays.stream(arr).max().getAsInt();
				while(l<=r) {
					int mid=(l+r)/2;
					int res=check(mid,arr,k);
					if(res>=k) {
						l=mid+1;
						ans=mid;
					}
					else {
						r=mid-1;
					}
				}
				System.out.println(ans);
			}

		} catch (Exception e) {
			System.out.println(e);
			return;
		}


	}
	public static int check(int n, int[] arr, int k) {
		int count=0;
		for(int i=0;i<arr.length;i++) {
			count+=(arr[i]/n);
		}
		return count;
	}

}
