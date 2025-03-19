import java.io.BufferedReader
import java.io.InputStreamReader

data class Node(val value: Char, var left: Node? = null, var right: Node? = null)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val nodes = mutableMapOf<Char, Node>()

    repeat(n) {
        val (parent, left, right) = br.readLine().split(" ").map { it.first() }
        nodes.putIfAbsent(parent, Node(parent))
        if (left != '.') nodes.putIfAbsent(left, Node(left))
        if (right != '.') nodes.putIfAbsent(right, Node(right))

        nodes[parent]!!.left = nodes[left]
        nodes[parent]!!.right = nodes[right]
    }
    val root = nodes['A']
    preorder(root)
    println()
    inorder(root)
    println()
    postorder(root)
}

fun preorder(node: Node?) {
    if (node == null) return
    print(node.value)
    preorder(node.left)
    preorder(node.right)
}


fun inorder(node: Node?) {
    if (node == null) return
    inorder(node.left)
    print(node.value)
    inorder(node.right)
}


fun postorder(node: Node?) {
    if (node == null) return
    postorder(node.left)
    postorder(node.right)
    print(node.value)
}

