import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }


    val trueList = br.readLine().split(" ").map { it.toInt() }
    val truthCount = trueList[0]
    val truthPeople = mutableSetOf<Int>()
    repeat(truthCount) { i ->
        truthPeople.add(trueList[i + 1])
    }

    val parties = mutableListOf<MutableList<Int>>()
    val graph = Array(n + 1) { mutableListOf<Int>() }

    repeat(m) {

        val party = mutableListOf<Int>()
        val st = StringTokenizer(br.readLine(), " ")

        repeat(st.nextToken().toInt()) {
            party.add(st.nextToken().toInt())
        }

        for (i in party.indices) {
            for (j in i + 1 until party.size) {
                if (party[j] !in graph[party[i]]) {
                    graph[party[i]].add(party[j])
                    graph[party[j]].add(party[i])
                }
            }
        }

        parties.add(party)
    }

    val que = LinkedList(truthPeople)
    val visited = Array(n + 1) { false }
    truthPeople.forEach { people ->
        visited[people] = true
    }

    while (que.isNotEmpty()) {
        val poll = que.poll()

        graph[poll].forEach { people ->
            if (!visited[people]) {
                visited[people] = true
                que.add(people)
            }
        }
    }


    var lieCount = 0
    for (party in parties) {
        if (party.none { visited[it] }) {
            lieCount++
        }
    }

    println(lieCount)

}