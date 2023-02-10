
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br.readLine();

		int n = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		int cnt = 0;
		while (queue.size() > 1) {
			if (cnt % 2 == 0)
				queue.poll();
			else
				queue.add(queue.poll());

			cnt++;
		}

		System.out.println(queue.poll());
	} // end of main
}
