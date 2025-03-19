import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val before = br.readLine()
    val remove = br.readLine()


    val stack = CharArray(before.length)
    var stackSize = 0

    for (char in before) {
        stack[stackSize] = char
        stackSize++

        if (stackSize >= remove.length) {
            var match = true
            for (j in remove.indices) {
                if (stack[stackSize - remove.length + j] != remove[j]) {
                    match = false
                    break
                }
            }


            if (match) {
                stackSize -= remove.length
            }
        }
    }



    if (stackSize == 0)
        println("FRULA")
    else
        println(stack.concatToString(0, stackSize))


}