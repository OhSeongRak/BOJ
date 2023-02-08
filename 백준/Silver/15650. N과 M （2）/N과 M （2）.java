import java.util.Scanner;

public class Main {
	static int[] numbers;
	static int[] inputs;
	static int n;
	static int r;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		numbers = new int[r];
		inputs = new int[n];

		for (int i = 0; i < n; i++) {
			inputs[i] = i + 1;
		}

		comb(0, 0);

	} // end of main

	public static void comb(int cnt, int start) {
		if (cnt == r) {
			for (int k : numbers)
				System.out.print(k + " ");
			System.out.println();
			return;
		}
		for (int i = start; i < inputs.length; i++) {
			numbers[cnt] = inputs[i];
			comb(cnt + 1, i + 1);
		}
	} // end of method
}
