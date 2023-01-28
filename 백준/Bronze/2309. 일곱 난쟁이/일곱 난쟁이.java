import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[9];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				int sum = 0;
				for (int k = 0; k < arr.length; k++) {
					if (k == i || k == j)
						continue;
					sum += arr[k];
				}
				if (sum == 100) {
					for (int k = 0; k < arr.length; k++) {
						if (k == i || k == j)
							continue;
						System.out.println(arr[k]);						
					}
                    return;
				}
			}
		}

	} // end of main
}
