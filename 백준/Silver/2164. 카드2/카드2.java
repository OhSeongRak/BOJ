import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int card = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i<=card; i++) 
			q.offer(i);
		
		while(q.size() != 1) {
			q.poll();
			int n = q.poll();
			q.offer(n);
		}
		
		System.out.println(q.peek());
	}
}