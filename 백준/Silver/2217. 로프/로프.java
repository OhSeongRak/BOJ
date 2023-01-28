
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] cumSum = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int answer = 0;
		for (int i = 0; i < arr.length; i++) {
			answer = answer < arr[i] * (N - i) ? arr[i] * (N - i) : answer;
		}
		System.out.println(answer);

	} // end of main
}
