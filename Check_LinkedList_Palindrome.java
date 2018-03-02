package Week_4;
/*
 * 1.PROBLEM STATEMENT:
 * Given a singly linked list, determine if it is a palindrome.
 * 2. EXAMPLE:
 *  [] 								true
 *  [1,1]							true
 *  [1,2]							false
 *  [3,3,3,3,3]						true
 *  [1,2,2,2,1]						true
 *  [1,2,3,4,2,3,2,1]				false
 *  3. BRUTE FORCE:
 *  Using stack store the second half elements of LL and then compare it with the first half by popping elements one by one
 *  4. OPTIMIZATION
 *  Instead of storing the elements in stack reverse the second half of the list and then compare it with first half 
 *  5. PERFORMANCE:
 *  Time complexity : O(n+n+n) = O(n)
 *  Space complexity: o(1)
 * */
import java.util.Scanner;

public class Check_LinkedList_Palindrome {
	static boolean isEvenNode = false;

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ListNode tail = null;
		ListNode head = null;
		if (n > 0) {
			head = new ListNode(s.nextInt());
			tail = head;
		}
		for (int i = 0; i < n - 1; i++) {
			tail.next = new ListNode(s.nextInt());
			tail = tail.next;

		}
		System.out.println(isPalindrome(head));
	}

	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		} else if (head.next.next == null) {
			return head.val == head.next.val;
		}

		ListNode middle = returnMiddle(head);
		if (!isEvenNode) {
			ListNode l = new ListNode(middle.val);
			l.next = middle.next;
			middle.next = l;
		}
		middle.next = reverseLinkedList(middle.next);
		ListNode tempL = head;
		ListNode tempR = middle.next;
		while (tempL != middle.next && tempR != null) {
			if (tempL.val != tempR.val) {
				return false;
			}
			tempL = tempL.next;
			tempR = tempR.next;
		}
		return (tempL == middle.next && tempR == null);
	}

	public static ListNode reverseLinkedList(ListNode head) {

		if (head == null)
			return null;
		if (head.next == null)
			return head;
		ListNode finalHead = reverseLinkedList(head.next);
		ListNode temp = finalHead;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = head;

		head.next = null;
		return finalHead;
	}

	public static ListNode returnMiddle(ListNode head) {
		if (head != null) {
			ListNode slow = head;
			ListNode fast = head;
			ListNode slowPrev = null;
			while (fast != null && fast.next != null) {
				fast = fast.next.next;
				slowPrev = slow;
				slow = slow.next;

			}
			if (fast == null) {
				isEvenNode = true;
			}
			return fast == null ? slowPrev : slow;
		}
		return null;
	}
}
