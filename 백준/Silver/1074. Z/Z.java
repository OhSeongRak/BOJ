
import java.util.Scanner;

public class Main {
	static int sum = 0;

	static void find(int height, int r, int c) {
		if (height == 1)
			return;

		int gridNum = 0;

		if (r < height / 2) { // 1 or 2 사분면
			if (c < height / 2)
				gridNum = 1;
			else
				gridNum = 2;
		} else { // 3 or 4 사분면
			if (c < height / 2)
				gridNum = 3;
			else
				gridNum = 4;
		}

		sum += (height / 2) * (height / 2) * (gridNum - 1);
//		System.out.printf("%d %d %d \n", height, gridNum, sum);

		switch (gridNum) {
		case 1:
			find(height / 2, r, c);
			break;
		case 2:
			find(height / 2, r, c - height / 2);
			break;
		case 3:
			find(height / 2, r - height / 2, c);
			break;
		default:
			find(height / 2, r - height / 2, c - height / 2);
			break;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();

		find((int) Math.pow(2, N), r, c);
		System.out.println(sum);
	} // end of main
}

// 전체 판의 높이, r, c -> 몇 사분면인지 구함
// 몇 사분면인지 확인 후 직전 사분면까지의 개수를 더함
// 만약 높이가 0이 되면 return