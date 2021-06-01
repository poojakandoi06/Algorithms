package dpandgreedy;

import java.util.*;

public class _79CanIWin {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int maxno = scn.nextInt();
		int target = scn.nextInt();
		solution(maxno, target);
	}

	static HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
	static boolean[] used;

	public static void solution(int maxno, int target) {
		used = new boolean[maxno + 1];
		if (((maxno * (maxno + 1)) / 2) < target) {
			System.out.println("false");
			return;
		}
		if (target <= 0 || maxno > target) {
			System.out.println("true");
			return;
		}

		System.out.println(helper(target));

	}

	private static  boolean helper(int target) {
        if (target <= 0) {
            return false;
        }
        int code = format(used);
        if (map.containsKey(code)) {
            return map.get(code);
        }
        boolean res = false;
        for (int i = 1; i < used.length && !res; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            res = res | !helper(target - i);
            used[i] = false;
        }
        map.put(code, res);
        return res;
    }

	public static int format(boolean[] used) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < used.length; i++) {
			if (used[i]) {
				sb.append(1);
			} else {
				sb.append(0);
			}
		}
		return Integer.parseInt(sb.toString());
	}

}
