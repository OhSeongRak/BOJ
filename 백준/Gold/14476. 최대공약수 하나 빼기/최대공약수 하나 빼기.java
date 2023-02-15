
import java.util.Scanner;

public class Main {
	// x, y의 최대공약수를 리턴하는 함수 : 유클리드 호제법 x <= y가 전제
	static int gcd(int x, int y) {
		// x > y라면 swap
		if (x > y) {
			int t = x;
			x = y;
			y = t;
		}
		if (x == 0)
			return y;
		return gcd(y % x, x);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N + 2]; // 1~N번째 인덱스에 입력 값을 담음.
		int[] leftGcd = new int[N + 2]; // arr의 1~i번째 숫자의 최대공약수
		int[] rightGcd = new int[N + 2]; // arr의 i~N번째 숫자의 최대공약수
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}

		// 1~i번째 숫자까지의 최대공약수 == gcd(1~i-1번째 숫자까지의 최대공약수, i번째 숫자)
		for (int i = 1; i <= N; i++) {
			leftGcd[i] = gcd(leftGcd[i - 1], arr[i]);
		}

		// i~N번째 숫자까지의 최대공약수 == gcd(i+1~N번째 숫자까지의 최대공약수, i번째 숫자)
		for (int i = N; i >= 1; i--) {
			rightGcd[i] = gcd(rightGcd[i + 1], arr[i]);
		}

		int answer = -1;
		int subNum = 0; // 제외된 숫자
		for (int i = 1; i <= N; i++) {
			// i번째 숫자를 제외한 최대공약수 == gcd(1~i-1번째 숫자의 최대공약수, i+1~N번째 숫자의 최대공약수)
			int g = gcd(leftGcd[i - 1], rightGcd[i + 1]);
			if (answer < g && arr[i] % g != 0) { // 문제의 조건(뺀 값의 약수에 g가 없어야 함)을 만족한다면
				answer = g;
				subNum = arr[i];
			}
		}

		if (answer == -1)
			System.out.println(answer);
		else
			System.out.println(answer + " " + subNum);

	} // end of main
} // end of class