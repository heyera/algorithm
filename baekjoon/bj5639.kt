import java.io.BufferedReader
import java.io.InputStreamReader

data class Node5639(var value: Int, var left: Node5639? = null, var right: Node5639? = null)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val inputList = mutableListOf<Int>()

    while (true) {
        val line = br.readLine() ?: break
        inputList.add(line.toInt())
    }

    val root = Node5639(inputList[0])

    for (i in 1 until inputList.size) {
        root.insert(inputList[i])
    }

    postOrder(root)

}

fun Node5639.insert(num: Int) {
    if (value > num) {
        if (left != null) left!!.insert(num)
        else left = Node5639(num)
    } else {
        if (right != null) right!!.insert(num)
        else right = Node5639(num)
    }
}

private fun postOrder(node: Node5639?) {
    if (node == null) return
    postOrder(node.left)
    postOrder(node.right)
    println(node.value)
}



