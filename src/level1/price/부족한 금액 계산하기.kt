/*
 * Date: 2022-01-15
 * Author Lee-Sungje
 * Problem: programmers - Level 1 부족한 금액 계산하기
 * Url: https://programmers.co.kr/learn/courses/30/lessons/82612
 */

package level1.price

class Solution {
    private tailrec fun pay(price: Int, count: Int, amount: Long = 0): Long =
        if (count <= 0) {
            amount
        } else {
            pay(price, count - 1, amount + (price * count))
        }

    fun solution(price: Int, money: Int, count: Int): Long =
        pay(price, count).let { amount ->
            if (amount <= money) {
                0L
            } else {
                amount - money
            }
        }
}