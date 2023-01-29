import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int cnt = 0;
		for (int A = 2; A < N; A += 2) {
			int remain = N - A; // A(택희)개 뺀 나머지
			if (remain < 3) // 남은 사탕이 3개미만이면 더 이상 못 나눔
				break;
			for (int B = 1; B < remain; B++) {
				int C = remain - B;
				if (C < B + 2) // C(남규) < B(영훈) + 2면 끝
					break;
				cnt++;
			}
		}
		System.out.println(cnt);
	} // end of main
}

// 남는 사탕은 없어야 한다.
// 남규는 영훈이보다 2개 이상 많은 사탕을 가져야 한다.
// 셋 중 사탕을 0개 받는 사람은 없어야 한다.
// 택희가 받는 사탕의 수는 홀수개가 되어서는 안 된다.
