package dpandgreedy;
import java.util.*;

public class _51WaterJugProblem {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int d = scn.nextInt();
		solution(n,m,d);
	}

	private static void solution(int n, int m, int d) {
		if(m > n) {
			int temp = m;
			m = n;
			n = temp;
		}
		
		if(d > n || d % gcd(m,n) != 0) {
			System.out.println("-1");
			return;
		}
		
		System.out.println(Math.min(pour(m,n,d), pour(n,m,d)));
	}

	private static int pour(int m, int n, int d) {
		int from = m;
		int to = 0;
		int ans = 1;
		while(from != d || to != d) {
			int temp = Math.min(from, n - to);
			
			from -= temp;
			to += temp;
			ans++;
			
			if(from == d || to == d) {
				break;
			}
			if(from == 0) {
				from = m;
				ans++;
			}
			if(to == n) {
				to = 0;
				ans++;
			}
		}
		return ans;
	}

	private static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		return gcd(b,a % b);
	}
	
	

}
