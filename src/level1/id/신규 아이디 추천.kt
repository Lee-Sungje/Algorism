/*
 * Date: 2022-01-13
 * Author Lee-Sungje
 * Problem: programmers - Level 1 신규 아이디 추천
 * Url: https://programmers.co.kr/learn/courses/30/lessons/72410
 */

package level1.id

class Solution {
    fun solution(new_id: String): String {
        return new_id.lowercase()
            .replace("[^-_.a-z0-9]+".toRegex(), "")
            .replace("([.]){2,}".toRegex(), ".")
            .replace("^[.]{0,}|[.]{0,}\$".toRegex(), "")
            .ifEmpty { "a" }
            .let {
                when (it.length) {
                    in 1..15 -> it
                    else -> it.slice(0 until 15)
                        .replace("[.]\$".toRegex(), "")
                }
            }
            .let {
                when (it.length) {
                    in 1 until 3 -> run {
                        var replaceId = it
                        while (replaceId.length in  1 until 3)
                            replaceId += it.last()
                        replaceId
                    }
                    else -> it
                }
            }
    }
}