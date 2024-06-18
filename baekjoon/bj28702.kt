import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val strArr = Array<String>(3){" "}
    repeat(3) {
        strArr[it] = br.readLine()
    }

    var number: Int = 0
    for (it in 0 until 3) {
        if (isNumber(strArr[it])) {
            number += strArr[it].toInt() + 3 - it
            break
        }
    }
    println(isFizzBuzz(number))

}

fun isNumber(s: String): Boolean {
    return try {
        s.toInt()
        true
    } catch (ex: NumberFormatException) {
        false
    }
}

fun isFizzBuzz(n: Int): String {
    if (n % 3 == 0 && n % 5 == 0)
        return "FizzBuzz"
    if (n % 3 == 0 && n % 5 != 0)
        return "Fizz"
    if (n % 3 != 0 && n % 5 == 0)
        return "Buzz"
    return "$n"
}