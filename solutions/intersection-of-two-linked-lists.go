package main

/*
https://leetcode.com/problems/intersection-of-two-linked-lists/
*/

type ListNode struct {
	Val  int
	Next *ListNode
}

func getIntersectionNode(headA, headB *ListNode) *ListNode {
	lengthA := 0
	tempHeadA := headA
	for tempHeadA != nil {
		lengthA++
		tempHeadA = tempHeadA.Next
	}

	lengthB := 0
	tempHeadB := headB
	for tempHeadB != nil {
		lengthB++
		tempHeadB = tempHeadB.Next
	}

	if lengthA > lengthB {
		for i := 0; i < lengthA-lengthB; i++ {
			headA = headA.Next
		}
	} else {
		for i := 0; i < lengthB-lengthA; i++ {
			headB = headB.Next
		}
	}

	for headA != nil && headB != nil {
		if headA == headB {
			return headA
		}
		headA = headA.Next
		headB = headB.Next
	}

	return nil
}
