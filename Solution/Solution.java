/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 package Solution;
 import java.util.*;

class Solution {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		ListNode head = new ListNode(scanner.nextInt());
		
		ListNode node = head;
		while(scanner.hasNextInt()){
			node.next = new ListNode(scanner.nextInt());
			node = node.next;

		}

		printChain(oddEvenList(head));
		return;
	}
	
		
		public static ListNode oddEvenList(ListNode head) {
			if(head == null){
				return null;
			}
			if(head.next == null){
				return head;
			}
			ListNode oddCursor = head;
			ListNode evenCursor = head.next;
			ListNode mergeNode = head.next;


			while(oddCursor.next != null && evenCursor.next != null){
				oddCursor.next = evenCursor.next;
				oddCursor = oddCursor.next;
				evenCursor.next = oddCursor.next;
				evenCursor = evenCursor.next;
			}

			oddCursor.next = oddEvenList(mergeNode);


			return head;

		}
		
		public static void printChain(ListNode head){
			do{
				System.out.println(head.val);
				head = head.next;	
			}while(head != null);
		}
	
}


