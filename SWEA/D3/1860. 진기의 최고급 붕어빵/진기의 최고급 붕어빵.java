import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		loop: for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int[] arriveArr = new int[N];

			for (int i = 0; i < arriveArr.length; i++) {
				arriveArr[i] = sc.nextInt();
			}

			Arrays.sort(arriveArr);

			int fishCnt = 0;
			int idx = 0;
			for (int time = 0; time <= arriveArr[N - 1]; time++) {
				if (time != 0 && time % M == 0) // M초 지났으면 붕어빵 개수를 K만큼 증가
					fishCnt += K;
				if (time == arriveArr[idx]) { // 사람이 도착했다면
					if (fishCnt == 0) { // 붕어빵이 없으면 Impossible
						System.out.printf("#%d Impossible%n", test_case);
						continue loop;
					} else { // 있다면 붕어빵 개수 1 감소, idx++
						fishCnt--;
						idx++;
					}
				}
			}

			System.out.printf("#%d Possible%n", test_case);
//			System.out.printf("#%d %d%n", test_case, answer);
		}

	} // end of main
}
