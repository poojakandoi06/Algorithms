import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Undostress {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			//int n = s.nextInt();
			//int k = s.nextInt();
//			int[] arr = new int[n];
//			for (int i = 0; i < n; i++)
//				arr[i] = s.nextInt();
			System.out.println(Questions2(3, new int[] {5,10,-5}));
			//System.out.println(Question1(12, 3, new int[]{2,3,4}).toString());
		} catch (Exception e) {
			System.out.println(e);
			return;
		}

	}

	public static ArrayList<Integer> Question1(int n, int k, int[] arr) {
		int[] prev = new int[n + 1];
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;
		prev[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = k - 1; j >= 0; j--) {
				if (i >= arr[j] && i % arr[j] == 0 && dp[i / arr[j]] != Integer.MAX_VALUE) {
					int val = dp[i / arr[j]] + 1;
					if (val < dp[i]) {
						dp[i] = val;
						prev[i] = arr[j];
					}
				}
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		if (dp[n] == Integer.MAX_VALUE) {
			list.add(-1);
			return list;
		} else {
			while (n >= 1) {
				list.add(0, prev[n]);
				if (n == 1)
					n = 0;
				else
					n = n / prev[n];
			}
			return list;
		}
	}
	public static ArrayList<Integer> Questions2(int n, int[] arr){
		Stack<Integer> st=new Stack<Integer>();
		for(int i:arr) {
			if(st.isEmpty() || i>0) {
				st.push(i);
			}
			else {
				boolean won=true;
				while(!st.isEmpty() && st.peek()>0) {
					if(st.peek()<-1*i) {
						st.pop();
					}
					else if(st.peek()==-1*i) {
						st.pop();
						won=false;
						break;
					}
					else {
						won=false;
						break;
					}
				}
				if(won==true)
					st.push(i);
			}
		}
		ArrayList<Integer> res=new ArrayList<Integer>();
		while(st.size()>0) {
			res.add(0,st.pop());
		}
		return res;
	}

}
