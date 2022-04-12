package main

/*
https://leetcode.com/problems/game-of-life/
*/

func gameOfLife(board [][]int) {
	m := len(board)
	n := len(board[0])

	var temp = make([][]int, m)
	for i := range temp {
		temp[i] = make([]int, n)
	}

	for i := range board {
		for j := range board[i] {
			temp[i][j] = board[i][j]
		}
	}

	for i := range temp {
		for j := range temp[i] {
			neighbourLiveCount := 0
			if i-1 >= 0 {
				if j-1 >= 0 {
					neighbourLiveCount += temp[i-1][j-1]
				}
				neighbourLiveCount += temp[i-1][j]
				if j+1 < n {
					neighbourLiveCount += temp[i-1][j+1]
				}
			}

			if j+1 < n {
				neighbourLiveCount += temp[i][j+1]
			}

			if j-1 >= 0 {
				neighbourLiveCount += temp[i][j-1]
			}

			if i+1 < m {
				if j-1 >= 0 {
					neighbourLiveCount += temp[i+1][j-1]
				}

				neighbourLiveCount += temp[i+1][j]

				if j+1 < n {
					neighbourLiveCount += temp[i+1][j+1]
				}
			}

			if temp[i][j] == 0 && neighbourLiveCount == 3 {
				board[i][j] = 1
			} else if temp[i][j] == 1 {
				if neighbourLiveCount < 2 || neighbourLiveCount > 3 {
					board[i][j] = 0
				}
			}

		}
	}

}
