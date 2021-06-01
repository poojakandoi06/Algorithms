package dpandgreedy;

public class _94DominoAndTrominoTiling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void soutiion(int N) {
		if (N == 1) {
			System.out.println("1");
			return;
		} else if (N == 2) {
			System.out.println("2");
			return;
		}
		int mod = 1000000007;
		int[] f = new int[N + 1];

		f[1] = 1;
		f[2] = 2;
		f[3] = 5;
		for (int i = 4; i <= N; i++) {
			f[i] = 2 * f[i - 1] % mod + f[i - 3] % mod;
			f[i] %= mod;
		}
		System.out.println(f[N]);

	}

}
