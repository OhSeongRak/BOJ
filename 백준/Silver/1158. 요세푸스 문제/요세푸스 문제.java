import java.util.Scanner;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
		this.next = null;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

class LinkedList {
	ListNode head;
	ListNode tail;

	public LinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void inserNode(int data) {
		ListNode newNode = new ListNode(data);
		if (head == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.next = newNode;
			this.tail = this.tail.next;
		}
	}

	public void tailToHead() {
		tail.next = head;
	}
}

public class Main {

	public static ListNode solution(ListNode head, int N, int K) {

		ListNode tmp = head;

		System.out.print("<");
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < K - 1; j++)
				tmp = tmp.next;
			System.out.print(tmp.next.val + ", ");
			tmp.next = tmp.next.next;
		}
		System.out.println(tmp.val + ">");
		return head;
	}

	public static void main(String[] args) {
		int N, K;

		LinkedList list = new LinkedList();

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		for (int i = 1; i <= N; i++)
			list.inserNode(i);
		list.tailToHead();

		solution(list.tail, N, K);


	}

}
