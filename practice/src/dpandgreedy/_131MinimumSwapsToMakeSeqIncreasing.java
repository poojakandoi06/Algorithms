package dpandgreedy;

public class _131MinimumSwapsToMakeSeqIncreasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minSwap(int[] A, int[] B) {
        int swap = 1, fix = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] >= B[i] || B[i - 1] >= A[i]) {
		// In this case, the ith manipulation should be same as the i-1th manipulation
                // fix = fix;
                swap++;
            } else if (A[i - 1] >= A[i] || B[i - 1] >= B[i]) {
		// In this case, the ith manipulation should be the opposite of the i-1th manipulation
                int temp = swap;
                swap = fix + 1;
                fix = temp;
            } else {
                // Either swap or fix is OK. Let's keep the minimum one
                int min = Math.min(swap, fix);
                swap = min + 1;
                fix = min;
            }
        }
        return Math.min(swap, fix);
    }

}
