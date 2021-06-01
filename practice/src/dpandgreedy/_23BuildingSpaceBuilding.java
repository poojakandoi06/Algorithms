package dpandgreedy;

public class _23BuildingSpaceBuilding {
	public static void main(String[] args) {
		System.out.println(solution(4));
	}

	public static int solution(int n) {
		int count = oneSideCount(n);
		return count * count;
	}

	public static int oneSideCount(int n) {
		int building = 0;
		int space = 1;
		for (int i = 1; i <= n; i++) {
			int temp = building;
			building = space;
			space += temp;
		}
		return building + space;
	}
}
