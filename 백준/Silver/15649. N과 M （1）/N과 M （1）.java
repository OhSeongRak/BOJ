
import java.util.Scanner;

public class Main {
	public static int N, R;
	public static int[] input; // 순열에 사용할 숫자
	public static int[] numbers; // input에서 선택된 값
	public static boolean[] isSelected; // 선택된 숫자의 사용 여부 (인덱스를 담음)
	public static int totalCount = 0; // 순열 경우의 수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		numbers = new int[R];
		isSelected = new boolean[N]; // 인덱스 사용 여부

		for (int i = 0; i < N; i++) {
			input[i] = i + 1;
		}

		perm(0);
	} // end of main

	// numbers 배열 칸에 cnt칸에 가능한 숫자를 넣어 보기
	public static void perm(int cnt) {
		if (cnt == R) {
			for(int k : numbers)
				System.out.print(k + " ");
			System.out.println();
			totalCount++;
			return;
		}

		for (int i = 0; i < N; i++) { // cnt 칸에 넣을 수 있는 숫자를 하나씩 넣어보자
			if (isSelected[i]) // numbers[] // 0 ~ cnt-1에 사용하지 않은 숫자를 찾아서 쓰기
				continue;
			numbers[cnt] = input[i];
			isSelected[i] = true;
			perm(cnt + 1);
			isSelected[i] = false;
		}

	} // end of method
} // end of class
