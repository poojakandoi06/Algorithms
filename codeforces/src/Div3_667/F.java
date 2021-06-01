package Div3_667;

import java.util.Arrays;
import java.util.Scanner;

public class F {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			int n=s.nextInt();
			int k=s.nextInt();
			String str=s.next();
			char[] st=s.next().toCharArray();
			if(st[0]==st[1]) {
				int count=0;
				for(char c:str.toCharArray()) {
					if(c==st[0])
						count++;
				}
				count=Math.min(count+k, str.length());
				int res=(count*(count-1))/2;
				System.out.println(res);
			}
			else {
				long[][][] dp=new long[str.length()+1][str.length()+1][str.length()+1];
				for(int i=0;i<dp.length;i++) {
					for(int j=0;j<dp[0].length;j++)
						Arrays.fill(dp[i][j], -1);
				}
				int val=(int)dfs(str.toCharArray(),0,0,k,dp,st[0],st[1]);
				System.out.println(val);
			}

		} catch (Exception e) {
			System.out.println(e);
			return;
		}


	}

	private static long dfs(char[] arr, int i, int numofchar1, int k, long[][][] dp,char c1,char c2) {
		if(i==arr.length) {
			if(k<0)
			return Integer.MIN_VALUE;
			else
				return 0;
		}
		if(k<0)
			return Integer.MIN_VALUE;
		if(dp[i][numofchar1][k]!=-1)
			return dp[i][numofchar1][k];
		long max=0;
		if(arr[i]==c1) {
			max=Math.max(max, dfs(arr,i+1,numofchar1+1,k,dp,c1,c2));
			max=Math.max(max, dfs(arr,i+1,numofchar1,k-1,dp,c1,c2)+numofchar1);
		}
		else if(arr[i]==c2) {
			max=Math.max(max, dfs(arr,i+1,numofchar1,k,dp,c1,c2)+numofchar1);
			max=Math.max(max, dfs(arr,i+1,numofchar1+1,k-1,dp,c1,c2));
		}
		else {
			max=Math.max(max, dfs(arr,i+1,numofchar1,k,dp,c1,c2));
			max=Math.max(max, dfs(arr,i+1,numofchar1+1,k-1,dp,c1,c2));
			max=Math.max(max, dfs(arr,i+1,numofchar1,k-1,dp,c1,c2)+numofchar1);
			
		}
		
		
		return dp[i][numofchar1][k]=max;
	}

}
