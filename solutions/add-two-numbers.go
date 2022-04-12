package main

/*
https://leetcode.com/problems/add-two-numbers/
*/

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	result := l1
	carry := 0

	var last *ListNode

	for l1 != nil && l2 != nil {
		sum := l1.Val + l2.Val + carry

		l1.Val = sum % 10
		carry = sum / 10

		last = l1
		l1 = l1.Next
		l2 = l2.Next
	}

	if l1 == nil {
		last.Next = l2
		l1 = l2
	}

	for l1 != nil {
		sum := l1.Val + carry
		l1.Val = sum % 10
		carry = sum / 10

		last = l1
		l1 = l1.Next
	}

	if carry > 0 {
		last.Next = &ListNode{
			Val:  carry,
			Next: nil,
		}
	}

	return result
}
