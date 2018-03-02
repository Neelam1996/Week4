package Week_4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test_CheckPalindromeLL {

	@Test
	void NullLL() {
		assertEquals(true, Check_LinkedList_Palindrome.isPalindrome(null));
	}

	void SingleElementList() {
		ListNode head = new ListNode(1);
		assertEquals(true, Check_LinkedList_Palindrome.isPalindrome(head));
	}

	void DoubleElement_True() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		assertEquals(true, Check_LinkedList_Palindrome.isPalindrome(head));
	}

	void DoubleElement_False() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		assertEquals(false, Check_LinkedList_Palindrome.isPalindrome(head));
	}

	void WorstCase_True() {
		ListNode head = new ListNode(2);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(2);
		assertEquals(true, Check_LinkedList_Palindrome.isPalindrome(head));
	}

	void WorstCase_False() {
		ListNode head = new ListNode(2);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(3);
		assertEquals(false, Check_LinkedList_Palindrome.isPalindrome(head));
	}

	void ValidTestCase() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(1);
		assertEquals(true, Check_LinkedList_Palindrome.isPalindrome(head));
	}

}
