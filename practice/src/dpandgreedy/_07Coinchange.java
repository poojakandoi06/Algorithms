package dpandgreedy;
import java.util.*;
public class _07Coinchange {

	public static void main(String[] args) {
		int[] denoms = {1,2,3};
		int amount = 5;
		solution(denoms,amount);
	}

	//combination
	private static void solution(int[] denoms, int amount) {
		int[] dp = new int[amount + 1];
		ArrayList<String> [] ways = new ArrayList[amount + 1];
		dp[0] = 1;
		for(int i = 0 ;i < ways.length ;i++) {
			ways[i] = new ArrayList<String>();
		}
		ways[0].add("");
		for(int i = 0 ; i < denoms.length ;i++) {
			for(int j = denoms[i]; j < dp.length ;j++) {
				dp[j] += dp[j - denoms[i]];
				for(String str : ways[j - denoms[i]]) {
					String nstr = str + denoms[i];
					ways[j].add(nstr);
				}
			}
		}
		System.out.println(dp[dp.length - 1]);
		System.out.println("..............................");
		System.out.println(ways[ways.length - 1]);
	}
	
	//permutation
	private static void solution2(int[] denoms, int amount) {
		int[] dp = new int[amount + 1];
		ArrayList<String> [] ways = new ArrayList[amount + 1];
		dp[0] = 1;
		for(int i = 0 ; i < ways.length ;i++) {
			ways[i] = new ArrayList<String>();
		}
		ways[0].add("");
		for(int i = 1; i <= amount; i++) {
			for(int j = 0 ;j < denoms.length ;j++) {
				if(i >= denoms[j]) {
					dp[i] += dp[i - denoms[j]];
					for(String str : ways[i - denoms[j]]) {
						String nstr = str + denoms[j];
						ways[i].add(nstr);
					}
				}
			}
		}
		System.out.println(dp[dp.length - 1]);
		System.out.println("....................................");
		System.out.println(ways[ways.length - 1]);
	}

}
