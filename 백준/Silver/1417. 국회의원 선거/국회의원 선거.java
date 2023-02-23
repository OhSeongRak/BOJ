
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br.readLine();
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		StringBuilder sb = new StringBuilder(); // sb.append();
//		st = new StringTokenizer(br.readLine()); // Integer.parseInt(st.nextToken());

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int myVote = sc.nextInt();
		if (N == 1) {
			System.out.println(0);
			return;
		}

		PriorityQueue<Integer> voteQueue = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < N - 1; i++)
			voteQueue.add(sc.nextInt());

		int cnt = 0;
		while (true) {
			int first = voteQueue.poll();
			if (first < myVote) {
				System.out.println(cnt);
				return;
			}

			myVote++;
			cnt++;
			voteQueue.add(first - 1);
		}

	} // end of main
}
