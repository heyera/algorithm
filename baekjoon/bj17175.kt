//DP

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br= BufferedReader(InputStreamReader(System.`in`))
    val n=br.readLine().toInt()
    var arr=IntArray(51)
    arr[0]=1
    arr[1]=1
    arr[2]=3
    arr[3]=5
    for (i in 4 .. n){
        arr[i]=(arr[i-1]+arr[i-2]+1)%1000000007
    }
    println(arr[n])
}