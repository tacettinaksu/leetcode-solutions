package main

/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/
*/

func removeDuplicates(nums []int) int {

	lastUniqueNumber := nums[0]
	lastUniqueIndex := 1

	for i := 1; i < len(nums); i++ {
		if nums[i] == lastUniqueNumber {
			continue
		}
		nums[lastUniqueIndex] = nums[i]
		lastUniqueNumber = nums[lastUniqueIndex]
		lastUniqueIndex++
	}
	return lastUniqueIndex
}
