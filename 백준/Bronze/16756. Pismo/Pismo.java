
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int min = Integer.MAX_VALUE;

		for (int i = 1; i < arr.length; i++) {
			if (Math.abs(arr[i] - arr[i - 1]) < min)
				min = Math.abs(arr[i] - arr[i - 1]);
		}

		System.out.println(min);
	} // end of main
}
