import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(1001) { "" }
    arr[1] = "CY"
    arr[2] = "SK"
    arr[3] = "CY"
    arr[4] = "SK"
    if(n<5) {
        println(arr[n])
        return
    }
    for (i in 5..n) {
        if(arr[i-1]!="SK"||arr[i-3]!="SK"||arr[i-4]!="SK")
            arr[i]="SK"
        else
            arr[i]="CY"
    }
    println(arr[n])
}