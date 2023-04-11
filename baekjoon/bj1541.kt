import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine(), "-")
    var result: Int = 0;

    val plusst = StringTokenizer(st.nextToken(), "+")
    val stcount: Int = plusst.countTokens();
    for (i in 0 until stcount) {
        result += plusst.nextToken().toInt()
    }
    while (st.hasMoreTokens()) {
        var temp: Int = 0
        val minusSt=StringTokenizer(st.nextToken(),"+")
        while (minusSt.hasMoreTokens()){
            temp+=minusSt.nextToken().toInt()
        }
        result-=temp
    }
    println(result)

}