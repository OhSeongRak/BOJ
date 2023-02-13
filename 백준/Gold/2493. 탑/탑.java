
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br.readLine();
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] tops = new int[N + 1];
		int[] numbers = new int[N + 1];
		st = new StringTokenizer(br.readLine()); // Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			tops[i] = Integer.parseInt(st.nextToken());
		}

		Stack<int[]> stack = new Stack<>();
		for (int i = N; i >= 1; i--) {
			if (stack.isEmpty()) {
				stack.push(new int[] { i, tops[i] });
				continue;
			}
			while (!stack.isEmpty() && stack.peek()[1] < tops[i]) {
				numbers[stack.pop()[0]] = i;
			}
			stack.push(new int[] { i, tops[i] });
		}

		while (!stack.isEmpty()) {
			numbers[stack.pop()[0]] = 0;
		}

		for (int i = 1; i <= N; i++) {
			System.out.print(numbers[i] + " ");
		}
	} // end of main
}
