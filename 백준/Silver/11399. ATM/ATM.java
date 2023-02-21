
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// input start
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		// input end

		Arrays.sort(arr);
		int sum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			arr[i] += arr[i - 1];
			sum += arr[i];
		}
		System.out.println(sum);
	} // end of main
}

// 1 2 3 4 5
