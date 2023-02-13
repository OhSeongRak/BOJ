
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br.readLine();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()); // Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		CircularLinkedList cll = new CircularLinkedList();
		for (int i = 0; i < N; i++) {
			cll.add(i + 1);
		}
		cll.tail.next = cll.head;

		Node pointer = cll.tail;
		System.out.print('<');
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < K - 1; j++) {
				pointer = pointer.next;
			}
			System.out.print(pointer.next.data + ", ");
			pointer.next = pointer.next.next;

		}
		System.out.println(pointer.data + ">");
	} // end of main
}

class Node {
	int data;
	Node next;

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}

class CircularLinkedList {
	public Node head = null;
	public Node tail = null;

	public void add(int data) {
		Node newNode = new Node(data, null);
		if (head == null) {
			this.head = newNode;
			this.tail = newNode;
			return;
		}
		this.tail.next = newNode;
		this.tail = newNode;
	}
}
