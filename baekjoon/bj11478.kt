import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br= BufferedReader(InputStreamReader(System.`in`))
    val str= br.readLine()
    val nameSet=mutableSetOf<String>()
    for (start in 0..str.length){
        for(end in start+1..str.length){
            nameSet.add(str.substring(start,end))
        }
    }
    println(nameSet.size)

}