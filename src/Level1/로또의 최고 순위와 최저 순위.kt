/*
 * Date: 2022-01-06
 * Author Lee-Sungje
 * Problem: programmers - Level 1 로또의 최고 순위와 최저 순위
 * Url: https://programmers.co.kr/learn/courses/30/lessons/77484
 */

package Level1

class Solution {
    private fun rank(sameNumber: Int) = when(sameNumber) {
        6 -> 1
        5 -> 2
        4 -> 3
        3 -> 4
        2 -> 5
        else -> 6
    }

    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var countWin: Int = 0
        var countZero: Int = 0
        for (lotto in lottos) {
            if (lotto == 0) {
                countZero++
                continue
            }

            for (winNumber in win_nums) {
                if (lotto == winNumber) {
                    countWin++
                    break
                }
            }
        }

        return intArrayOf(rank(countWin+countZero), rank(countWin))
    }
}